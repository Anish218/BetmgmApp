package com.example.assignmentone.presentation.accountscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.assignmentone.MainActivity
import com.example.assignmentone.R
import com.example.assignmentone.common.sharedpreferences.Store
import com.example.assignmentone.presentation.ComposeView.AccountScreenView
import com.example.assignmentone.presentation.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountFragment:Fragment() {
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

                AccountScreenView()
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