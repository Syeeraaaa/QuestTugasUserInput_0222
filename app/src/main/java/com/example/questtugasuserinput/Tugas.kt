package com.example.questtugasuserinput

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue

@Composable
fun formbiodata(){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope ()

    var nama_depan by remember { mutableStateOf("") }
    var nama_belakang by remember {mutableStateOf("")}
    var email by remember { mutableStateOf("") }
    var tgl_lahir by remember { mutableStateOf("") }
    var pengalaman by remember {mutableStateOf("")}
}