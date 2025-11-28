package br.com.lconeto.mercadoportega.shopping.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.mercadoportega.common.data.ShoppingItem
import br.com.lconeto.mercadoportega.common.data.ShoppingListDataSource
import br.com.lconeto.mercadoportega.databinding.FragmentShoppingBinding
import br.com.lconeto.mercadoportega.shopping.domain.OnItemClicked
import br.com.lconeto.mercadoportega.shopping.domain.ShoppingAdapter

class ShoppingFragment : Fragment() {
    private var _binding: FragmentShoppingBinding? = null
    private val binding get() = _binding!!

    private var shoppingList: MutableList<ShoppingItem> = ShoppingListDataSource.getInitialList().toMutableList()

    private lateinit var shoppingAdapter: ShoppingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val onItemClicked: OnItemClicked = { clickedItem ->
            toggleItemCheckedState(clickedItem)
        }
        shoppingAdapter = ShoppingAdapter(shoppingList, onItemClicked)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewShopping.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = shoppingAdapter
        }
    }

    private fun toggleItemCheckedState(item: ShoppingItem) {
        val index = shoppingList.indexOfFirst { it.name == item.name && it.category == item.category }

        if (index != -1) {
            val updatedItem = item.copy(isChecked = !item.isChecked)
            shoppingList[index] = updatedItem
            reorderList()
        }
    }

    private fun reorderList() {
        val sortedList = shoppingList.sortedBy { it.isChecked }
        shoppingList.clear()
        shoppingList.addAll(sortedList)
        shoppingAdapter.updateList(shoppingList)

        setupRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
