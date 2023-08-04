package com.example.sportapplication.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sportapplication.SportApplication
import com.example.sportapplication.databinding.FragmentWebBinding
import com.example.sportapplication.presentation.SportWebViewClient
import com.example.sportapplication.presentation.viewmodel.WebViewModel

class WebFragment : BaseFragment<FragmentWebBinding>(FragmentWebBinding::inflate) {

    private val viewModel: WebViewModel by viewModels {
        (requireActivity().application as SportApplication).appComponent.viewModelsFactory()
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.apply {
            webViewClient = SportWebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(viewModel.currentUrl)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.currentUrl = binding.webView.url.toString()
    }
}