package com.example.sportapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import coil.load
import com.example.sportapplication.R
import com.example.sportapplication.SportApplication
import com.example.sportapplication.databinding.FragmentTeamBinding
import com.example.sportapplication.domain.entity.Team
import com.example.sportapplication.presentation.adapter.PlayersAdapter
import com.example.sportapplication.presentation.uistate.TeamUIState
import com.example.sportapplication.presentation.viewmodel.TeamViewModel

class TeamFragment : BaseFragment<FragmentTeamBinding>(FragmentTeamBinding::inflate) {

    private val viewModel: TeamViewModel by viewModels {
        (requireActivity().application as SportApplication).appComponent.viewModelsFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUiStateObserver()
        setOnClickListeners()
    }

    private fun setUiStateObserver() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is TeamUIState.Initializing -> {
                    setInitializing()
                }

                is TeamUIState.Loading -> {
                    setLoading()
                }

                is TeamUIState.Content -> {
                    setContent(state.team)
                }

                is TeamUIState.Error -> {
                    setError(state.errorId)
                }
            }
        }
    }

    private fun setOnClickListeners() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                view?.findNavController()?.popBackStack()
            }

            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.refresh_button -> {
                        viewModel.getTeam(getTeamId())
                        true
                    }

                    else -> false
                }
            }
        }
    }

    private fun setInitializing() {
        val teamId = getTeamId()
        viewModel.getTeam(teamId)
    }

    private fun setLoading() {
        binding.apply {
            contentLayout.visibility = View.GONE
            error.visibility = View.GONE
            loadingProgressBar.visibility = View.VISIBLE
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = false
        }
    }

    private fun setContent(team: Team) {
        binding.apply {
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = true
            contentLayout.visibility = View.VISIBLE
            error.visibility = View.GONE
            loadingProgressBar.visibility = View.GONE
            teamName.text = team.teamName
            teamImage.load(team.teamBadgeUri) {
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_no_image)
            }

            val coach = team.coaches[0]
            coachName.text = coach.coachName
            coachAge.text = requireContext().getString(R.string.age, coach.coachAge.toString())
            coachCountry.text = requireContext().getString(R.string.country, coach.coachCountry)

            val adapter = PlayersAdapter()
            teamRecyclerView.adapter = adapter
            Log.d("TeamFragment", team.players.size.toString())
            adapter.submitList(team.players)
        }
    }

    private fun setError(errorId: Int) {
        binding.apply {
            contentLayout.visibility = View.GONE
            loadingProgressBar.visibility = View.GONE
            error.visibility = View.VISIBLE
            toolbar.menu.findItem(R.id.refresh_button).isEnabled = true
            error.text = requireContext().getString(errorId)
        }
    }

    private fun getTeamId() = arguments?.getInt(TEAM_ID_KEY) ?: 0

    companion object {
        const val TEAM_ID_KEY = "team id"
    }
}