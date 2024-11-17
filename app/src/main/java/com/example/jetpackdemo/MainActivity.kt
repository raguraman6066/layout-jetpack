package com.example.jetpackdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScaffoldWithAppBarsAndFAB()
        }
    }



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyScaffoldWithAppBarsAndFAB() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Top App Bar") },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(0xFF6200EE),
                        titleContentColor = Color.White
                    )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = Color(0xFF6200EE),
                    contentColor = Color.White,
                    tonalElevation = 8.dp
                ) {
                    Text(
                        text = "Bottom App Bar",
                        modifier = Modifier.weight(1f)
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                              Toast.makeText(this,"you clicked fab",Toast.LENGTH_SHORT).show()
                              },
                    containerColor = Color(0xFF6200EE),
                    contentColor = Color.White
                ) {
                  Icon(painter = painterResource(id = R.drawable.lion)  , contentDescription ="lion" )
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            content = { paddingValues ->
                Text(
                    text = "Hello from Scaffold!",
                    modifier = Modifier.padding(paddingValues)
                )
            }
        )
    }



    @Composable
    fun MySurface(){
        Surface(modifier = Modifier.size(100.dp),
            color = Color.Blue,
            contentColor = colorResource(
            id = R.color.purple_200
        ),
            shadowElevation = 1.dp,
            border = BorderStroke(1.dp,Color.Cyan)
        ) {
            Column{
                Text(text = "Hello")
                Text(text = "World")
            }
        }
    }

    @Composable
    fun MyRow() {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Hello")
            Text(text = "World")
        }
    }

    @Composable
    fun MyColumn() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello")
            Text(text = "World")
        }
    }

    @Composable
    fun MyBox(){
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "Hello", modifier = Modifier.align(Alignment.BottomCenter))
            Text(text = "World", modifier = Modifier.align(Alignment.Center))
        }
    }


}


