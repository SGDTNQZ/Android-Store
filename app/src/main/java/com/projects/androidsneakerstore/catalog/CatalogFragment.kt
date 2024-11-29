package com.projects.androidsneakerstore.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class CatalogFragment  : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply{
        setContent{
            val navController = findNavController()

            CatalogScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

