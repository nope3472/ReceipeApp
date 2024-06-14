package eu.tutorials.myrecipeapp

sealed class Screen(val route :String) {
    object ReceipeScreen:Screen("receipescreen")
    object DetailScreen:Screen("detailscreen")
}