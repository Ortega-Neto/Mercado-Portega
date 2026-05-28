package br.com.lconeto.mercadoportega.common.data

sealed class Category(val name: String, val priority: Int) {
    data object Food : Category("Comida 🍎", 1)
    data object Cleaning : Category("Produtos de Limpeza 🧽", 2)
    data object Hygiene : Category("Produtos de Higiene 🧴", 3)
}
