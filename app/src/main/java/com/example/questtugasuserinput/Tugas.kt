package com.example.questtugasuserinput

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

@Composable
fun formbiodata(){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope ()
}