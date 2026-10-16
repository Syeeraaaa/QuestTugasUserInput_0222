package com.example.questtugasuserinput

import android.icu.util.TimeZone
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import java.text.SimpleDateFormat
import java.util.Locale

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


    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val dateFormatter = SimpleDateFormat(stringResource(R.string.frmt_tgl),
        Locale.getDefault())
        .apply { timeZone = TimeZone.getTimeZone("UTC") }

    var expanded by remember { mutableStateOf(false) }
    val experienceOptions = stringArrayResource(R.array.opsi_pengalaman)

    val isFormValid = nama_depan.isNotBlank() && nama_belakang.isNotBlank() && email.isNotBlank() && tgl_lahir.isNotBlank() &&
            pengalaman.isNotBlank() && selectedSkills.isNotEmpty()

    val skill_separator = stringResource(R.string.skill_separator)
    val resultTemplate = stringResource(R.string.hasil)
    val snackbarDurationMs = integerResource(R.integer.snackbar_durasi).toLong()

    val fieldShapes = RoundedCornerShape(dimensionResource(R.dimen.field_corner_radius))
    val fieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = colorResource(R.color.kuning_accent),
        unfocusedBorderColor = colorResource(R.color.field_border),
        focusedLabelColor = colorResource(R.color.coklat_primary),
        unfocusedLabelColor = colorResource(R.color.text_hint),
        cursorColor = colorResource(R.color.coklat_primary),
        unfocusedTextColor = colorResource(R.color.text_coklat)
    )

    Scaffold(
        snackbarHost = {SnackbarHost(hostState = snackbarHostState)},
        containerColor =  colorResource(R.color.form_cream)
    ) {
    }

}