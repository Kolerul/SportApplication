package com.example.sportapplication.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sportapplication.R
import com.example.sportapplication.SportApplication
import com.example.sportapplication.databinding.FragmentMatchesBinding
import com.example.sportapplication.domain.entity.Match
import com.example.sportapplication.presentation.viewmodel.MatchesViewModel
import com.example.sportapplication.presentation.adapter.MatchesAdapter
import com.example.sportapplication.presentation.uistate.MatchesUIState

class MatchesFragment: BaseFragment<FragmentMatchesBinding>(FragmentMatchesBinding::inflate) {

    private val viewModel by viewModels<MatchesViewModel> {
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
                is MatchesUIState.Initializing -> {
                    setInitializing()
                }
                is MatchesUIState.Loading -> {
                    setLoading()
                }

                is MatchesUIState.Content -> {
                    setContent(state.matches)
                }

                is MatchesUIState.Error -> {
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
                        val leagueId = getLeagueId()
                        viewModel.getMatches(leagueId)
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

    private fun getLeagueId(): Int = arguments?.getInt(LEAGUE_ID_KEY) ?: 0

    private fun setInitializing() {
        val leaguesId = getLeagueId()
        viewModel.getMatches(leaguesId)
    }

    private fun setLoading() {
        binding.apply {
            matchesRecyclerView.visibility = View.GONE
            loadingProgressBar.visibility = View.VISIBLE
            error.visibility = View.GONE
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = false
        }
    }

    private fun setContent(matches: List<Match>){
        binding.apply {
            matchesRecyclerView.visibility = View.VISIBLE
            loadingProgressBar.visibility = View.GONE
            error.visibility = View.GONE
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = true

            val adapter = MatchesAdapter { teamId ->
                val bundle = bundleOf(TeamFragment.TEAM_ID_KEY to teamId)
                view?.findNavController()
                    ?.navigate(R.id.action_matchesFragment_to_teamFragment, bundle)
            }
            matchesRecyclerView.adapter = adapter
            adapter.submitList(matches)
        }
    }

    private fun setError(errorId: Int) {
        binding.apply {
            matchesRecyclerView.visibility = View.GONE
            loadingProgressBar.visibility = View.GONE
            error.visibility = View.VISIBLE
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = true
            error.text = requireContext().getString(errorId)
        }
    }

    companion object{
        const val LEAGUE_ID_KEY = "league id"
    }
}