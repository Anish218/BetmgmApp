package com.example.assignmentone

import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES.M
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.findNavController
import com.example.assignmentone.presentation.AppBottomNavigation
import com.example.assignmentone.presentation.AppTopNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        changeTopBarAndBottomBarStatusToGone()
//        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        findViewById<ComposeView>(
            R.id.composeviewheader
        ).setContent {
            Scaffold(
                topBar = { AppTopNavigation() },
                drawerContent = { Text(text = "Drawer") }
            ) {
            }


        }

        findViewById<ComposeView>(
            R.id.composeviewbottom
        ).setContent {
            Scaffold(
                bottomBar = { AppBottomNavigation(::navigateLobbyScreen) },
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
        super.onResume()}
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






}