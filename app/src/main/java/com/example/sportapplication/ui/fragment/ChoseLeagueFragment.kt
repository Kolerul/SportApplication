package com.example.sportapplication.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sportapplication.R
import com.example.sportapplication.SportApplication
import com.example.sportapplication.databinding.FragmentChoseLeagueBinding
import com.example.sportapplication.domain.entity.League
import com.example.sportapplication.presentation.adapter.LeagueAdapter
import com.example.sportapplication.presentation.uistate.LeagueUIState
import com.example.sportapplication.presentation.viewmodel.LeagueViewModel

class ChoseLeagueFragment: BaseFragment<FragmentChoseLeagueBinding>(FragmentChoseLeagueBinding::inflate) {

    private val viewModel: LeagueViewModel by viewModels {
        (requireActivity().application as SportApplication).appComponent.viewModelsFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUiStateObserver()
        setOnClickListeners()
    }

    private fun setUiStateObserver(){
        viewModel.uiState.observe(viewLifecycleOwner){ state ->
            when(state){
                is LeagueUIState.Initializing -> {
                    setInitializing()
                }
                is LeagueUIState.Loading -> {
                    setLoading()
                }

                is LeagueUIState.Content -> {
                    setContent(state.leagues)
                }

                is LeagueUIState.Error -> {
                    setError(state.errorId)
                }

                else -> {}
            }
        }
    }

    private fun setOnClickListeners() {
        binding.apply {
            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.refresh_button -> {
                        val countryId = getCountryId()
                        viewModel.getLeagues(countryId)
                        true
                    }

                    else -> false
                }
            }

            toolbar.setNavigationOnClickListener {
                view?.findNavController()?.popBackStack()
            }
        }
    }

    private fun getCountryId(): Int = arguments?.getInt(COUNTRY_ID_KEY) ?: 0

    private fun setInitializing() {
        val countryId = getCountryId()
        viewModel.getLeagues(countryId)
    }

    private fun setLoading() {
        binding.apply {
            text.visibility = View.GONE
            loadingProgressBar.visibility = View.VISIBLE
            contentLayout.visibility = View.GONE
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = false
        }
    }

    private fun setContent(leagues: List<League>){
        binding.apply {
            text.visibility = View.GONE
            loadingProgressBar.visibility = View.GONE
            contentLayout.visibility = View.VISIBLE
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = true

            val adapter = LeagueAdapter{ league ->
                val leagueId = league.leagueId
                val bundle = bundleOf(MatchesFragment.LEAGUE_ID_KEY to leagueId)
                view?.findNavController()?.navigate(R.id.action_choseLeagueFragment_to_matchesFragment, bundle)
            }
            countriesRecyclerView.adapter = adapter
            adapter.submitList(leagues)
        }
    }

    private fun setError(errorId: Int) {
        binding.apply {
            text.text = requireContext().getString(errorId)
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = true
            text.visibility = View.VISIBLE
            loadingProgressBar.visibility = View.GONE
            contentLayout.visibility = View.GONE
        }
    }

    companion object{
        const val COUNTRY_ID_KEY = "country id"
    }
}