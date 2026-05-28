package br.com.lconeto.mercadoportega.selection.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lconeto.mercadoportega.common.data.ShoppingItem
import br.com.lconeto.mercadoportega.common.data.ShoppingListDataSource
import br.com.lconeto.mercadoportega.common.domain.repository.ShoppingRepository
import kotlinx.coroutines.launch

class SelectionViewModel(
    private val repository: ShoppingRepository,
) : ViewModel() {

    private val _catalogItems = MutableLiveData<List<ShoppingItem>>()
    val catalogItems: LiveData<List<ShoppingItem>> = _catalogItems

    private val _saveStatus = MutableLiveData<Boolean>()
    val saveStatus: LiveData<Boolean> = _saveStatus

    private val selectedItems = mutableSetOf<String>()

    init {
        loadCatalog()
    }

    private fun loadCatalog() {
        _catalogItems.value = ShoppingListDataSource.getDefaultList()
    }

    fun toggleSelection(item: ShoppingItem) {
        if (selectedItems.contains(item.name)) {
            selectedItems.remove(item.name)
        } else {
            selectedItems.add(item.name)
        }

        val updatedList = _catalogItems.value.orEmpty().map {
            it.copy(isChecked = selectedItems.contains(it.name))
        }
        _catalogItems.value = updatedList
    }

    fun saveSelection() {
        val listToSave = _catalogItems.value.orEmpty()
            .asSequence()
            .filter { selectedItems.contains(it.name) }
            .map { it.copy(isChecked = false) }
            .toList()

        viewModelScope.launch {
            repository.saveShoppingList(listToSave)
            _saveStatus.value = true
        }
    }
}
