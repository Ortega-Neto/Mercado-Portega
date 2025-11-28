package br.com.lconeto.mercadoportega.data

data class ShoppingItem(
    val name: String,
    val category: Category,
    val isChecked: Boolean = false
)
