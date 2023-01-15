package com.example.assignmentone.presentation.lobbyscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.assignmentone.R
import com.example.assignmentone.presentation.ComposeView.LobbyScreenView
import com.example.assignmentone.presentation.viewModel.MainViewModel


class LobbyFragment : Fragment() {
    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                LobbyScreenView()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.changescreen(R.id.sportsFragment)

        findNavController().navigate(R.id.sportsFragment)
    }
//    override fun onBackPressed() {
//       Navigation.findNavController()




}