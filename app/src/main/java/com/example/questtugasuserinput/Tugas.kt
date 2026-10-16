package com.example.questtugasuserinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
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
    ) { _ ->
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(R.drawable.bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.header_height))
            )

            Surface(modifier = Modifier
                .fillMaxSize()
                .padding(top = dimensionResource(R.dimen.form_top_offset)),
            shape = RoundedCornerShape(
                topStart = dimensionResource(R.dimen.form_corner_radius),
                topEnd = dimensionResource(R.dimen.form_corner_radius)
            ),
                color = colorResource(R.color.white),
                shadowElevation = dimensionResource(R.dimen.card_elevator)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.screen_padding)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_medium))
                ){
                    Text(
                        text = stringResource(R.string.form_title),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.coklat_primary),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = stringResource(R.string.form_Subtitle),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.text_hint),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_small)))
                    {
                        OutlinedTextField(
                            value = nama_depan,
                            onValueChange = {nama_depan = it },
                            label = {Text(stringResource(R.string.nama_depan))},
                            singleLine = true,
                            shape = fieldShapes,
                            colors = fieldColors,
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = nama_belakang,
                            onValueChange = {nama_belakang = it},
                            label = {Text(stringResource(R.string.nama_belakang))},
                            singleLine = true,
                            shape = fieldShapes,
                            colors = fieldColors,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    OutlinedTextField(
                        value = email,
                        onValueChange = {email = it},
                        label = {Text(stringResource(R.string.email))},
                        singleLine = true,
                        shape = fieldShapes,
                        colors = fieldColors,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_small))){
                        OutlinedTextField(
                            value = tgl_lahir,
                            onValueChange = {},
                            readOnly = true,
                            label = {Text(stringResource(R.string.Tgl_lahir))},
                            trailingIcon = {
                                IconButton(onClick = {showDatePicker = true}) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = stringResource(R.string.desc_calendar_icon),
                                        tint = colorResource(R.color.coklat_primary)
                                    )
                                }
                            },
                            singleLine = true,
                            shape = fieldShapes,
                            colors = fieldColors,
                            modifier = Modifier.weight(1f)
                        )
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = !expanded},
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = pengalaman,
                                onValueChange = {},
                                readOnly = true,
                                label = {Text(stringResource(R.string.Pengalaman))},
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
                                singleLine = true,
                                shape = fieldShapes,
                                colors = fieldColors,
                                modifier = Modifier.menuAnchor()
                            )
                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = {expanded = false}
                            ) {
                                experienceOptions.forEach { option -> DropdownMenuItem(
                                    text = {Text(option, color = colorResource(R.color.text_coklat)) },
                                    onClick = {
                                        pengalaman = option
                                        expanded = false
                                    }
                                )
                                }
                            }
                        }
                    }

                }
            }
        }
    }

}