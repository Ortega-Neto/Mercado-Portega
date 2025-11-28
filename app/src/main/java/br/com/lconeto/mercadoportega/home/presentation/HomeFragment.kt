package br.com.lconeto.mercadoportega.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lconeto.mercadoportega.R
import br.com.lconeto.mercadoportega.common.domain.extensions.navigateTo
import br.com.lconeto.mercadoportega.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateButtons()
        setupListeners()
    }

    private fun populateButtons() {
        binding.homeShopping.textContactTitle.text = getString(R.string.home_shopping)
        binding.homeShopping.imageContactTitle.setImageResource(R.drawable.ic_shoppin_car)
    }

    private fun setupListeners() {
        binding.homeShopping.root.setOnClickListener {
            navigateTo(HomeFragmentDirections.actionNavHomeToShoppingFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
