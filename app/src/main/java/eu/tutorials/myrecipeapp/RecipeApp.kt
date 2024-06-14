package eu.tutorials.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation. NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp (navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState
    NavHost(navController = navController, startDestination = Screen.ReceipeScreen.route ){
          composable(Screen.ReceipeScreen.route) {
              RecipeScreen(viewstate = viewstate, navigatetodetail = {
                  navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                  navController.navigate(Screen.DetailScreen.route)
              })
          }
        composable(route = Screen.DetailScreen.route) { navBackStackEntry ->
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                ?: Category(idCategory = "", strCategory = "", strCategoryThumb = "", strCategoryDescription = "")
            CategoryDetailScreen(category = category)
        }
    }
}

