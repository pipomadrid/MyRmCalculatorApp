package com.example.myrmcalculatorapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myrmcalculatorapp.components.MainButton
import com.example.myrmcalculatorapp.components.MainCard
import com.example.myrmcalculatorapp.components.MainTextField
import com.example.myrmcalculatorapp.components.SpacerH
import javax.crypto.BadPaddingException


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "RM Calculator",color = MaterialTheme.colorScheme.onPrimary) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )

        )

    }) {
        ContentHomeView(it)
    }

}

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var weigth by remember { mutableStateOf(" ") }
        var repsNumber by remember { mutableStateOf(" ") }
        MainTextField(
            value = weigth,
            onValueChange = { weigth = it },
            label = "Weigth",
            ImeAction.Next,
            true)
        SpacerH()
        MainTextField(
            value = repsNumber,
            onValueChange = { repsNumber = it },
            label = "Repetitions",
            ImeAction.Done,
            true)
        SpacerH(36)
        MainButton(text = "Calculate", onClick = {})
        SpacerH()
        MainButton(text = "Clean", Color.Red, onClick = {})
        SpacerH()
        MainCard("Tittle",23.0,Modifier)

    }

}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    HomeView()
}