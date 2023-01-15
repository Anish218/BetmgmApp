package com.example.assignmentone.presentation.splashscreen

import android.content.ContentValues.TAG
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.assignmentone.MainActivity
import com.example.assignmentone.R
import com.example.assignmentone.presentation.SplashScreenView
import com.example.assignmentone.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashScreenFragment : Fragment() {
    private val mainViewModel:MainViewModel by viewModels()

    private val splashScreenViewModel: SplashScreenViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply { setContent {
            SplashScreenView(

                splashScreenViewModel,::exitApp)

        } }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "000000:${splashScreenViewModel.dynaconResponseObserver} ")
        Log.i(TAG, "onViewCreated: +++++++++++")
        splashScreenViewModel.dynaconResponseObserver.observeForever {
            Log.i(TAG, "dynacon response: ${it.Entries} ")
        }
        splashScreenViewModel.siteCoreResponseObserver.observeForever {
            Log.i(TAG, "sitecore response: ${it.Item} ")
        }
        splashScreenViewModel.isDynaconApiSuccess.observeForever {
            if(it==false){

            }
        }
        val connMgr = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo = connMgr.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            // fetch data
            splashScreenViewModel.callDynaconAndSiteCoreApi()
            splashScreenViewModel.changeNetworkState(true)

        } else {
            // display error
            splashScreenViewModel.changeNetworkState(false)

        }

//        Log.i(TAG, "onViewCreated: ${dynaconApiUsecase.invoke()}")
        Handler().postDelayed({

//            val useCase = FetchDynaconDataUseCase()
//            splashscreenviewmodel=
//                ViewModelProvider(this@SplashScreenFragment, SplashScreenViewModelFactory())
//                    .get(SplashScreenViewModel::class.java)
//            splashscreenviewmodel..observe(viewLifecycleOwner, Observer{
//                Log.i("dynocon", it.Entries.toString())
//            })
            //mainViewModel.changeSplashScreeenLoadState()
            //println("after state change"+mainViewModel.isSplashScreenLoaded.value)
           if(splashScreenViewModel.isDynaconApiSuccess.value==false|| splashScreenViewModel.isNetworkConnected.value==false){
               println("@@@@")
               //println(findNavController().currentBackStackEntry)
               //findNavController().popBackStack()
            //println(findNavController().currentBackStackEntry)
               (activity as? MainActivity)?.finish()
           }
            else
            findNavController().navigate(R.id.action_splashScreenFragment_to_lobbyFragment)



            //           findNavController().popBackStack(R.id.firstFragment,false)

        }, 7000)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainViewModel.splashScreenLoaded.value=false
        (activity as? MainActivity)?.changeTopBarAndBottomBarStatusToVisible()


    }
    fun exitApp(){
        println("exitapp")
        (activity as? MainActivity)?.finish()
    }




}