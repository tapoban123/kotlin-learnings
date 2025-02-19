## Using Retrofit for Native Android Dev

### Origin/Working URL: "https://dummyjson.com/products/"
Let’s consider the following API url:
"https://dummyjson.com/products/phones?page=2&api_key=1234"

Here, BASEURL = https://dummyjson.com/
1. Declare an interface
   ```kotlin
   interface Api{}
   ```
1. Inside the interface declare the type of request.
   ```kotlin
   interface Api{
      @GET()
   }
   ```
2. Specify the endpoint inside the parenthesis.
   ```kotlin
   interface Api{
      @GET(“products”)
   }
   ```
3. Specify the path parameter of type.
   ```kotlin
   interface Api{
      @GET(“products/{type}”)
   }
   ```
4. Declare a suspend function:
   ```kotlin
   interface Api{   
      @GET(“products/{type}”)
      suspend fun getProductsList()
   }
   ```
6. Declare the path parameters and query parameters as arguments to be passed to the function.
   ```kotlin
   interface Api{
      @GET(“products/{type}”)
      suspend fun getProductsList(
         @Path(“type”) type: String,
         @Query(“page”) page: Int,
         @Query(“api_key”) api_key: String
      )
   }
   ```
8. Declare the return data model of the function.
   ```kotlin
   interface Api {
      @GET(“products/{type}”)
      suspend fun getProductsList(
         @Path(“type”) type: String,
         @Query(“page”) page: Int,
         @Query(“api_key”) api_key: String
      ) : Products
   }
   ```

9. Declare the baseUrl:
   ```kotlin
   interface Api {
      @GET(“products/{type}”)
      suspend fun getProductsList(
         @Path(“type”) type: String,
         @Query(“page”) page: Int,
         @Query(“api_key”) api_key: String
      ) : Products
   
      companion object {
         const val BASE_URL = "https://dummyjson.com/“
      }
   }
   ```
10. 
