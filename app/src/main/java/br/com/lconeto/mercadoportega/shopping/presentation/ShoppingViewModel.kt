package br.com.lconeto.mercadoportega.shopping.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import br.com.lconeto.mercadoportega.common.data.ShoppingItem
import br.com.lconeto.mercadoportega.common.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository,
) : ViewModel() {

    val shoppingList: LiveData<List<ShoppingItem>> = repository.getShoppingList()
        .map { sortList(it) }
        .asLiveData()

    fun toggleItemChecked(item: ShoppingItem) {
        val currentList = shoppingList.value.orEmpty().toMutableList()
        val index = currentList.indexOfFirst { (it.name == item.name) && (it.category == item.category) }

        if (index != -1) {
            val updatedItem = item.copy(isChecked = !item.isChecked)
            currentList[index] = updatedItem

            viewModelScope.launch {
                repository.saveShoppingList(currentList)
            }
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
