package br.com.lconeto.mercadoportega.common.domain.repository

import br.com.lconeto.mercadoportega.common.data.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {
    fun getShoppingList(): Flow<List<ShoppingItem>>
    suspend fun saveShoppingList(items: List<ShoppingItem>)
}
