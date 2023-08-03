package com.example.sportapplication.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
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
            }
        }
    }

    private fun setInitializing(){
        val leaguesId = arguments?.getInt(LEAGUE_ID_KEY) ?: 0
        viewModel.getMatches(leaguesId)
    }

    private fun setLoading(){
        binding.apply {
            matchesRecyclerView.visibility = View.GONE
            loading.visibility = View.VISIBLE
            error.visibility = View.GONE
        }
    }

    private fun setContent(matches: List<Match>){
        binding.apply {
            matchesRecyclerView.visibility = View.VISIBLE
            loading.visibility = View.GONE
            error.visibility = View.GONE

            val adapter = MatchesAdapter()
            matchesRecyclerView.adapter = adapter
            adapter.submitList(matches)
        }
    }

    private fun setError(errorId: String){
        binding.apply {
            matchesRecyclerView.visibility = View.GONE
            loading.visibility = View.GONE
            error.visibility = View.VISIBLE
            error.text = errorId
        }
    }

    companion object{
        const val LEAGUE_ID_KEY = "league id"
    }
}