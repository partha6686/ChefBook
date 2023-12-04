package ps.example.chefbook

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun App(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.root) {
        composable(Screen.RecipeScreen.root) {
            RecipeScreen(viewState = viewState, navigate = {
                path , category ->
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", category)
                navController.navigate(path)
            })
        }
        composable(Screen.DetailScreen.root) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat")?:Category("","","","")
            CategoryDetailScreen(category = category)
        }

    }

}