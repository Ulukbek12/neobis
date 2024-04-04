package сom.example.week4.user;


import com.example.week5.ProductApplication;
import com.example.week5.dto.Request;
import com.example.week5.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ProductApplication.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void testRegisterUser() throws Exception {
        Request request = new Request();
        request.setEmail("test@example.com");
        request.setPassword("password");

        when(userService.registerUser(any(Request.class)))
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully."));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"email\": \"test@example.com\", \"password\": \"password\" }"))
                .andExpect(status().isCreated())
                .andExpect(content().string("User registered successfully."));
    }
    @Test
    public void testAuthenticate() throws Exception {
        Request request = new Request();
        request.setEmail("test@example.com");
        request.setPassword("password");

        when(userService.authenticate(any(Request.class)))
                .thenReturn(ResponseEntity.ok("jwt-token"));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"email\": \"test@example.com\", \"password\": \"password\" }"))
                .andExpect(status().isOk())
                .andExpect(content().string("jwt-token"));
    }
}

