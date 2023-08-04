package com.example.sportapplication.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.sportapplication.R
import com.example.sportapplication.databinding.FragmentGreetingBinding
import com.example.sportapplication.ui.util.animationAppearanceFromZeroAlpha

class GreetingFragment : BaseFragment<FragmentGreetingBinding>(FragmentGreetingBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isFirstLaunch = savedInstanceState?.getBoolean(IS_FIRST_LAUNCH_KEY) ?: true
        if (isFirstLaunch) {
            setWelcomeAnimation()
        }
        setOnClickListeners()
    }

    private fun setWelcomeAnimation() {
        binding.apply {
            welcomeText.visibility = View.VISIBLE
            navigationLayout.visibility = View.GONE
            welcomeText.animationAppearanceFromZeroAlpha(2000) {
                navigationLayout.visibility = View.VISIBLE
                welcomeText.visibility = View.GONE
            }
        }
    }

    private fun setOnClickListeners() {
        binding.apply {
            toMatchesButton.setOnClickListener {
                view?.findNavController()
                    ?.navigate(R.id.action_greetingFragment_to_choseCountryFragment)
            }

            toNewsButton.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_greetingFragment_to_webFragment)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(IS_FIRST_LAUNCH_KEY, false)
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val IS_FIRST_LAUNCH_KEY = "first launch"
    }
}