package com.example.questtugasuserinput

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

@Composable
fun formbiodata(){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope ()

    var nama_depan by remember { mutableStateOf("") }
    var nama_belakang by remember {mutableStateOf("")}
    var email by remember { mutableStateOf("") }
    var tgl_lahir by remember { mutableStateOf("") }
    var pengalaman by remember {mutableStateOf("")}

    val skillAndroid = stringResource(R.string.skill_android)
    val skillUiux = stringResource(R.string.skill_uiux)
    val skillWeb = stringResource(R.string.skill_web)
    val skillOptions = listOf(skillAndroid,skillUiux,skillWeb)
    val selectedSkills = remember { mutableStateListOf<String>() }
}