# Screen Navigation using Compose.

1. Add the following packages to your build.gradle file.
    ```gradle
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    ```
2. Create `Serializable` objects for your screens in your MainActivity.kt file.
    ```kotlin
    @Serializable
    object ScreenA
    ```

3. To pass values from one screen to another create serializable data classes.
    ```kotlin
    @Serializable
    data class ScreenB(
        val name: String?,
        val age: Int
    )
    ```

4. Create `NavController` inside your MainActivity class -> setContent.
    ```kotlin
    val navController = rememberNavController()
    ```

5. Then declare `NavHost` to control the screen navigation and create the screen composables.
    ```kotlin
    NavHost(
        navController = navController,
        startDestination = ScreenA
    )
    ```
6. Finally create the screen composables.
    ```kotlin
    composable<ScreenA> {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                navController.navigate(
                    ScreenB(
                        name = "Willium",
                        age = 25
                    )
                )
            }) {
                Text("Go to ScreenB")
            }
        }
    }

    composable<ScreenB> {
        val args = it.toRoute<ScreenB>()
        Column {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("${args.name}, ${args.age} years old.")

            }
        }
    }
    ```

7. To navigate to another screen use the following function:
    ```kotlin
    navController.navigate(
        ScreenB(
            name = "Willium",
            age = 25
        )
    )
    ```