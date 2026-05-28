package br.com.lconeto.mercadoportega.shopping.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.mercadoportega.R
import br.com.lconeto.mercadoportega.common.domain.extensions.setTitleName
import br.com.lconeto.mercadoportega.databinding.FragmentShoppingBinding
import br.com.lconeto.mercadoportega.shopping.domain.ShoppingAdapter

class ShoppingFragment : Fragment() {
    private var _binding: FragmentShoppingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShoppingViewModel by viewModels()

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
        setTitleName(getString(R.string.home_shopping))
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        shoppingAdapter = ShoppingAdapter(emptyList()) { clickedItem ->
            viewModel.toggleItemChecked(clickedItem)
        }
        binding.recyclerViewShopping.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = shoppingAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.shoppingList.observe(viewLifecycleOwner) { items ->
            shoppingAdapter.updateList(items)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
