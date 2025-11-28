package br.com.lconeto.mercadoportega.common.data

sealed class Category(val name: String) {
    data object Food : Category("Comida 🍎")
    data object Cleaning : Category("Produtos de Limpeza 🧽")
    data object Hygiene : Category("Produtos de Higiene 🧴")
}
