package br.com.lconeto.mercadoportega.common.domain.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navigateTo(action: NavDirections) {
    val navController = findNavController()
    navController.navigate(action)
}
