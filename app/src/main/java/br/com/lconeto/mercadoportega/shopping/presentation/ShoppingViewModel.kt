package br.com.lconeto.mercadoportega.shopping.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lconeto.mercadoportega.common.data.ShoppingItem
import br.com.lconeto.mercadoportega.common.data.ShoppingListDataSource
import br.com.lconeto.mercadoportega.common.domain.repository.ShoppingRepository

class ShoppingViewModel(
    private val repository: ShoppingRepository = ShoppingListDataSource
) : ViewModel() {

    private val _shoppingList = MutableLiveData<List<ShoppingItem>>()
    val shoppingList: LiveData<List<ShoppingItem>> = _shoppingList

    init {
        loadItems()
    }

    fun loadItems() {
        _shoppingList.value = repository.getShoppingList()
    }

    fun toggleItemChecked(item: ShoppingItem) {
        val currentList = _shoppingList.value.orEmpty().toMutableList()
        val index = currentList.indexOfFirst { it.name == item.name && it.category == item.category }

        if (index != -1) {
            val updatedItem = item.copy(isChecked = !item.isChecked)
            currentList[index] = updatedItem
            _shoppingList.value = sortList(currentList)
        }
    }

    private fun sortList(list: List<ShoppingItem>): List<ShoppingItem> {
        return list.sortedWith(
            compareBy<ShoppingItem> { it.isChecked }
                .thenBy { it.category.priority }
                .thenBy { it.name }
        )
    }
}
