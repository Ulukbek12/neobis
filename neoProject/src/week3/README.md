# Instruction
## There some advices of how you can interact with project
1. Introduction
   - Look through all files in main
2. Begin to run code
   - Tap a run code in a right-up corner(Be sure that you are running ProdcutApplication)
   - Wait about ten second and look at run panel, If there are no errors, you will see:
       1. Approximately wait time
       2. And two Products: Apple, Beef
    - Project is succesfully run!
3. Go to terminal in IDEA, in my case it is Intellij and write simple http request
     1. I have five endpoints and we will go through them.
    - Get all procuts: Invoke-WebRequest -Method Get -Uri http://localhost: your local host/products
    - Get specific procut: Invoke-WebRequest -Method Get -Uri http://localhost: your local host/products/id ---> id of a product
    - Post a new product, firstly you have to write what this product is and then a http request :<br>
      1. $body = @{
          name = "name"
          price = "price"
          description = "description"
         } | ConvertTo-Json
      2.  Invoke-WebRequest -Method Post -Uri http://localhost: your local host/products -Body $body -ContentType "application/json"
     - Put a new product is almost the same:
        1. $body = @{
          name = "name"
          price = "price"
          description = "description"
         } | ConvertTo-Json
        2.  Invoke-WebRequest -Method Put -Uri http://localhost: your local host/products/id -Body $body -ContentType "application/json"
      - Delete a specific product: Invoke-WebRequest -Method Delete -Uri http://localhost: your local host/products/id 
