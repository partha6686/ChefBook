package ps.example.chefbook

sealed class Screen(val root: String) {
    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}