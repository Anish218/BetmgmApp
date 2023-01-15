package com.example.assignmentone.presentation.sportsscreen

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.assignmentone.MainActivity
import com.example.assignmentone.R
import com.example.assignmentone.common.sharedpreferences.Store
import com.example.assignmentone.presentation.animation.shimmer.ShimmerAnimation
import com.example.assignmentone.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SportsScreenFragment : Fragment() {

    private val sportsScreenViewModel: SportsScreenViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels()


    private  lateinit var view:ComposeView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sportsScreenViewModel.changeShimmerAnimation(true)
        if(sportsScreenViewModel.isLobbyApiSuccess.value==false)
            sportsScreenViewModel.callLobbyApi()
        val dataStore=Store(requireContext())

        return ComposeView(requireContext()).apply {
            sportsScreenViewModel.showShimmerAnimation.observeForever {
                if (it == true)
                    setContent { ShimmerAnimation(sportsScreenViewModel,::exitApp) }
                else {
println("shimeer animation is false")
                    CoroutineScope(Dispatchers.Main).launch {
                        println("status changed")
                        dataStore.saveBottomBarStatus(true)
                    }
                    setContent { SportsScreenView(sportsScreenViewModel ,::navigateSearchScreen) }

                }

            }

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sportsScreenViewModel.isLobbyApiSuccess.observeForever{
            if(it==true){
                sportsScreenViewModel.changeShimmerAnimation(false)
                println("shimmer animation in fragment"+sportsScreenViewModel.showShimmerAnimation.value)
                mainViewModel.changeBottomBarStatus(true)
                activity?.let { it1 -> sportsScreenViewModel.getFixturesForMarquee(it1) }
            }
            else
            {
                //sportsScreenViewModel.changeShimmerAnimation(true)


            }
        }
       // findNavController().previousBackStackEntry==
        val callback=object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(findNavController().previousBackStackEntry!!.destination.id==com.example.assignmentone.R.id.lobbyFragment)
                {
                    (activity as? MainActivity)?.finish()
                }
                else {
                    val dataStore=Store(requireContext())

                    CoroutineScope(Dispatchers.Main).launch {
                        println("status changed")
                        findNavController().currentBackStackEntry?.destination?.let {
                            dataStore.saveIconColorStatus(
                                it.id)
                        }
                    }
                    findNavController().popBackStack()
                }
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)
    }

fun exitApp(){
    println("exitapp")
    (activity as? MainActivity)?.finish()
}

    override fun onDestroyView() {
        super.onDestroyView()
        println("view destroed")

    }
    fun navigateSearchScreen(id: Int){
        findNavController().navigate(id)
    }





}