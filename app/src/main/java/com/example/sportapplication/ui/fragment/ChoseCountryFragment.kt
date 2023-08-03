package com.example.sportapplication.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sportapplication.R
import com.example.sportapplication.SportApplication
import com.example.sportapplication.databinding.FragmentChoseCountryBinding
import com.example.sportapplication.domain.entity.Country
import com.example.sportapplication.presentation.adapter.CountryAdapter
import com.example.sportapplication.presentation.uistate.CountryUIState
import com.example.sportapplication.presentation.viewmodel.CountryViewModel

class ChoseCountryFragment: BaseFragment<FragmentChoseCountryBinding>(FragmentChoseCountryBinding::inflate) {

    private val viewModel: CountryViewModel by viewModels {
        (requireActivity().application as SportApplication).appComponent.viewModelsFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUiStateObserver()
    }

    private fun setUiStateObserver(){
        viewModel.uiState.observe(viewLifecycleOwner){ state ->
            when(state){
                is CountryUIState.Initializing -> {
                    setInitializing()
                }
                is CountryUIState.Loading -> {
                    setLoading()
                }
                is CountryUIState.Content -> {
                    setContent(state.countries)
                }
                is CountryUIState.Error -> {
                    setError(state.errorId)
                }
            }
        }
    }

    private fun setInitializing(){
        viewModel.getCountries()
        binding.apply {
            text.text = "WELCOME!"
            text.visibility = View.VISIBLE
            contentLayout.visibility = View.GONE
        }
    }

    private fun setLoading(){
        binding.apply {
            text.text = "Loading"
            text.visibility = View.VISIBLE
            contentLayout.visibility = View.GONE
        }
    }

    private fun setContent(countries: List<Country>){
        binding.apply {
            text.visibility = View.GONE
            contentLayout.visibility = View.VISIBLE

            val adapter = CountryAdapter { country ->
                val id = country.countryId
                val bundle = bundleOf(ChoseLeagueFragment.COUNTRY_ID_KEY to id)
                view?.findNavController()?.navigate(R.id.action_choseCountryFragment_to_choseLeagueFragment, bundle)
            }
            countriesRecyclerView.adapter = adapter
            adapter.submitList(countries)
        }
    }

    private fun setError(errorId: String){
        binding.apply {
            text.text = errorId
            text.visibility = View.VISIBLE
            contentLayout.visibility = View.GONE
        }
    }


}