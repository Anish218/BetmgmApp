package com.example.assignmentone.presentation.casinoscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.assignmentone.MainActivity
import com.example.assignmentone.common.sharedpreferences.Store
import com.example.assignmentone.presentation.ComposeView.AccountScreenView
import com.example.assignmentone.presentation.ComposeView.CasinoScreenView
import com.example.assignmentone.presentation.navigation.NAV_SPORTS
import com.example.assignmentone.presentation.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CasinoFragment : Fragment() {
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent{
                (activity as MainActivity).changeTopBarAndBottomBarStatusToGone()

                CasinoScreenView()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.changescreen(com.example.assignmentone.R.id.accountFragment)
        val callback=object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                val dataStore= Store(requireContext())

                CoroutineScope(Dispatchers.Main).launch {
                    println("status changed")
                    findNavController().currentBackStackEntry?.destination?.let {
                        dataStore.saveIconColorStatus(
                            it.id)
                    }
                }

                findNavController().popBackStack()
                (activity as MainActivity).changeTopBarAndBottomBarStatusToVisible()



            }


        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)
    }


}