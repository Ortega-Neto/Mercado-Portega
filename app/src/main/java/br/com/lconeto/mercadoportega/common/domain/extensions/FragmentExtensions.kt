package br.com.lconeto.mercadoportega.common.domain.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navigateTo(action: NavDirections) {
    val navController = findNavController()
    navController.navigate(action)
}

fun Fragment.setTitleName(title: String) {
    (requireActivity() as AppCompatActivity).supportActionBar?.title = title
}
