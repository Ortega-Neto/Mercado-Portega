package br.com.lconeto.mercadoportega.selection.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.mercadoportega.common.data.ShoppingDataStore
import br.com.lconeto.mercadoportega.common.data.ShoppingRepositoryImpl
import br.com.lconeto.mercadoportega.databinding.FragmentSelectionBinding
import br.com.lconeto.mercadoportega.shopping.domain.ShoppingAdapter

class SelectionFragment : Fragment() {

    private var _binding: FragmentSelectionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SelectionViewModel by viewModels {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val dataStore = ShoppingDataStore(requireContext().applicationContext)
                val repository = ShoppingRepositoryImpl(dataStore)
                return SelectionViewModel(repository) as T
            }
        }
    }

    private lateinit var adapter: ShoppingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupListeners()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = ShoppingAdapter(emptyList()) { item ->
            viewModel.toggleSelection(item)
        }
        binding.recyclerViewSelection.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = this@SelectionFragment.adapter
        }
    }

    private fun setupListeners() {
        binding.buttonSaveSelection.setOnClickListener {
            viewModel.saveSelection()
            viewModel.saveStatus.observe(viewLifecycleOwner) { isSaved ->
                if (isSaved) {
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun observeViewModel() {
        viewModel.catalogItems.observe(viewLifecycleOwner) { items ->
            adapter.updateList(items)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
