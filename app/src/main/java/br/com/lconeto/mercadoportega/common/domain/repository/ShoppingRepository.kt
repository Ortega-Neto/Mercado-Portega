package br.com.lconeto.mercadoportega.common.domain.repository

import br.com.lconeto.mercadoportega.common.data.ShoppingItem

interface ShoppingRepository {
    fun getShoppingList(): List<ShoppingItem>
}
