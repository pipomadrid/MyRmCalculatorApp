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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrmcalculatorapp.R
import com.example.myrmcalculatorapp.components.MainButton
import com.example.myrmcalculatorapp.components.MainTextField
import com.example.myrmcalculatorapp.components.SevenCards
import com.example.myrmcalculatorapp.components.SpacerH


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.calculatorTitle),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        ContentHomeView(it, HomeViewModel())
    }

}

@Composable
fun ContentHomeView(paddingValues: PaddingValues,homeViewModel:HomeViewModel) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      /*  val weigth:Int by homeViewModel.weigth.observeAsState(initial = 0)
        val repsNumber:Int by homeViewModel.repsNumber.observeAsState(initial = 0)
        val rm1 :Double by homeViewModel.rm1.observeAsState(initial = 0.0)*/
        MainTextField(
            value = homeViewModel.getWeigthString(),
            onValueChange = { homeViewModel.onTextChange(it.toIntOrNull()?:0,"w")},
            label = stringResource(R.string.weigth),
            ImeAction.Next,
            true)
        SpacerH()
        MainTextField(
            value = homeViewModel.getRepsString(),
            onValueChange = {  homeViewModel.onTextChange(it.toIntOrNull()?:0,"r") },
            label = stringResource(R.string.repetitions),
            ImeAction.Done,
            true)
        SpacerH(36)
        MainButton(text = stringResource(R.string.calculate), onClick = {
            homeViewModel.calculateRm()

        })
        SpacerH()
        MainButton(text = stringResource(R.string.cleanValues), Color.Black, onClick = {
            homeViewModel.onClean()
            homeViewModel.calculateRm()
        })
        SpacerH()
        SevenCards(homeViewModel.state.rm1)

    }

}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    HomeView()
}



