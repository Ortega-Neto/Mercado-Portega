package br.com.lconeto.mercadoportega.common.data

sealed class Category(val name: String, val priority: Int) {
    data object Food : Category("Comida 🍎", PRIORITY_FOOD)
    data object Hortifruti : Category("Hortifruti 🥦", PRIORITY_HORTIFRUTI)
    data object Cleaning : Category("Produtos de Limpeza 🧽", PRIORITY_CLEANING)
    data object Hygiene : Category("Produtos de Higiene 🧴", PRIORITY_HYGIENE)

    companion object {
        private const val PRIORITY_FOOD = 1
        private const val PRIORITY_HORTIFRUTI = 2
        private const val PRIORITY_CLEANING = 3
        private const val PRIORITY_HYGIENE = 4
    }
}
