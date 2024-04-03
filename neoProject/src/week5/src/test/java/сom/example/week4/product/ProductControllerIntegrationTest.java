package сom.example.week4.product;


import com.example.week4.ProductApplication;
import com.example.week4.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//почему то эти метода влияют на основную бд, хотя я использовал h2 memory
//позже постораюсь разобраться, а так week5 вроде закончен
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    //Getter tests
    @Test
    @WithMockUser(username = "utoraliev@gmail.com", roles = "ADMIN")
    public void getAllProductsTest()throws Exception{
        this.mockMvc.perform(get("/products/user"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "utoraliev@gmail.com", roles = "ADMIN")
    public void getOneProductTest()throws Exception{
        Long productId = 5L;
        this.mockMvc.perform(get("/products/user/{id}",productId))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "utoraliev@gmail.com", roles = "ADMIN")
    public void getProductsGreaterThanTest()throws Exception{
        double price = 2.1;
        this.mockMvc.perform(get("/products/user/greaterThan/{price}",price))
                .andDo(print())
                .andExpect(status().isOk());
    }
    //Post tests
    @Test
    @WithMockUser(username = "utoraliev@gmail.com", roles = "ADMIN")
    public void postNewProductTest() throws Exception {
        Product product = new Product("Test product", 10.0, "Test desc");
        String json = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/products/admin/add")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "utoraliev@gmail.com",roles = "ADMIN")
    public void postBulkOfProductsTest() throws Exception{
        List<Product> products = List.of(
                new Product("Test product 1", 10.0,"Test desc 1"),
                new Product("Test product 2",11.0,"Test desc 2")
        );
        for(var product : products){
            String json = objectMapper.writeValueAsString(product);
            mockMvc.perform(post("/products/admin/add")
                    .content(json)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }
    //Put tests
    @Test
    @WithMockUser(username = "utoraliev@gmail.com",roles = "ADMIN")
    public void updateProductTest() throws Exception {
        Product existedProduct = new Product("Updated product ",10.0,"Test desc ");
        Long productId = 9L;
        String json = objectMapper.writeValueAsString(existedProduct);
        mockMvc.perform(put("/products/user/updateProduct/{id}",productId)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "utoraliev@gmail.com",roles = "ADMIN")
    public void updateBulkOfProductsTest() throws Exception {
        List<Product> products = List.of(
                new Product("Updated Product 1",10.0,"Test desc 1"),
                new Product("Updated Product 2", 11.0,"Test desc 2")
        );

        String productsJson = objectMapper.writeValueAsString(products);

        mockMvc.perform(put("/products/user/updateProducts")
                        .content(productsJson)
                        .contentType(MediaType.APPLICATION_JSON)
                .param("ids", "15", "16"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "utoraliev@gmail.com",roles = "ADMIN")
    public void deleteProductTest() throws Exception{
        Long productId = 14L;
        mockMvc.perform(delete("/products/admin/{id}",productId))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "utoraliev@gmail.com",roles = "ADMIN")
    public void deleteAllProductsTest() throws Exception{
        mockMvc.perform(delete("/products/admin/deleteAll"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}