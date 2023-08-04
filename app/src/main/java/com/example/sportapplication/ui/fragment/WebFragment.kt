package com.example.sportapplication.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import com.example.sportapplication.databinding.FragmentWebBinding
import com.example.sportapplication.presentation.SportWebViewClient

class WebFragment : BaseFragment<FragmentWebBinding>(FragmentWebBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.apply {
            webViewClient = SportWebViewClient()
            loadUrl("https://www.championat.com/")
        }

        overrideBackCallback()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                view?.findNavController()?.popBackStack()
            }
        }
    }

    private fun overrideBackCallback() {
        val callback = requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    binding.apply {
                        if (webView.canGoBack()) {
                            webView.goBack()
                        } else {
                            view?.findNavController()?.popBackStack()
                        }
                    }
                }
            })
    }
}