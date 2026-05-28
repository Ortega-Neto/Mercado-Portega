package br.com.lconeto.mercadoportega.common.data

import br.com.lconeto.mercadoportega.common.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow

class ShoppingRepositoryImpl(
    private val dataStore: ShoppingDataStore,
) : ShoppingRepository {

    override fun getShoppingList(): Flow<List<ShoppingItem>> {
        return dataStore.getShoppingList()
    }

    override suspend fun saveShoppingList(items: List<ShoppingItem>) {
        dataStore.saveShoppingList(items)
    }
}
