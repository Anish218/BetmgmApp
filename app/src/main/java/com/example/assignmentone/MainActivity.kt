package com.example.assignmentone

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.findNavController
import com.example.assignmentone.common.sharedpreferences.Store
import com.example.assignmentone.presentation.AppBottomNavigation
import com.example.assignmentone.presentation.AppTopNavigation
import com.example.assignmentone.presentation.sportsscreen.SportsScreenViewModel
import com.example.assignmentone.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mainViewModel:MainViewModel by viewModels()
    val sportsScreenViewModel:SportsScreenViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataStore=Store(applicationContext)
        CoroutineScope(Dispatchers.Main).launch {
            println("status changingg on crated")
            dataStore.saveBottomBarStatus(false)
            dataStore.saveIconColorStatus(R.id.sportsFragment)
        }
        println("oncreate")
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        changeTopBarAndBottomBarStatusToGone()
//        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        findViewById<ComposeView>(
            R.id.composeviewheader
        ).setContent {
            Scaffold(
                topBar = { AppTopNavigation(::navigateTWebScreen) },
                drawerContent = { Text(text = "Drawer") }
            ) {
            }


        }

        findViewById<ComposeView>(
            R.id.composeviewbottom
        ).setContent {
            Scaffold(
                bottomBar = { AppBottomNavigation(mainViewModel,sportsScreenViewModel,::navigateLobbyScreen) },
                drawerContent = { Text(text = "Drawer") }
            ) {
            }


        }





    }
    fun navigateLobbyScreen(idy: Int){
        println(idy)
        //CasinoFragment
        // val action =LobbyFragmentDirections.actionLobbyFragmentToCasinoFragment()
        findNavController(R.id.fragmentContainerView).navigate(idy)

    }

    override fun onResume() {
        super.onResume()
        println("onresume")
    }
    fun changeTopBarAndBottomBarStatusToVisible(){
        println("called")

        val topheader=findViewById<ComposeView>( R.id.composeviewheader)
        topheader.visibility= View.VISIBLE
        val bottombar=findViewById<ComposeView>( R.id.composeviewbottom)
        bottombar.visibility= View.VISIBLE





    }


    fun changeTopBarAndBottomBarStatusToGone(){
        println("called")

        val topheader=findViewById<ComposeView>( R.id.composeviewheader)
        topheader.visibility= View.GONE
        val bottombar=findViewById<ComposeView>( R.id.composeviewbottom)
        bottombar.visibility= View.GONE





    }

    override fun onStop() {
        super.onStop()
        println("ondestroy")
    }
    fun navigateTWebScreen(id:Int){
        findNavController(R.id.fragmentContainerView).navigate(id)

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        // on below line we are checking if the request
//        // code is same and result code is ok
//        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
//            // if the condition is satisfied we are getting
//            // the data from our string array list in our result.
//            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//            // on below line we are setting result
//            // in our output text method.
//            outputTxt = result?.get(0).toString()
//        }
//    }






}