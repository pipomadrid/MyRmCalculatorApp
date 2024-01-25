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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrmcalculatorapp.components.MainButton
import com.example.myrmcalculatorapp.components.MainTextField
import com.example.myrmcalculatorapp.components.SevenCards
import com.example.myrmcalculatorapp.components.SpacerH
import kotlin.math.round


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "RM Calculator", color = MaterialTheme.colorScheme.onPrimary, fontSize = 20.sp)
            },
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
        var repsNumber by remember { mutableStateOf(" ")}
        var rm1 by remember {mutableStateOf(0.0)}
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
        MainButton(text = "Calculate", onClick = {
            rm1 = calculateRm(weigth,repsNumber)

        })
        SpacerH()
        MainButton(text = "Clean", Color.Red, onClick = {
            weigth = ""
            repsNumber= ""
            rm1 = 0.0
        })
        SpacerH()
        SevenCards(rm1)

    }

}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    HomeView()
}

fun calculateRm(weigth: String,repsNumber:String):Double {
    val weigthDouble = weigth.toDouble()
    val repsNumberDouble = repsNumber.toDouble()
    val rm1 = weigthDouble / (1.0278 - (0.0278 * repsNumberDouble))
    return round(rm1 * 100)/100.0

}

