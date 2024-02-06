package com.example.myrmcalculatorapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round


@Composable
fun SevenCards(rm1:Double,modifier: Modifier = Modifier){
       Column(
           modifier
               .fillMaxWidth()
               .padding(horizontal = 30.dp)
               .verticalScroll(rememberScrollState()),
       ) {
           MainCard("1 RM", rm1, Modifier)
           SpacerH()
           MainCard("2 RM", round((rm1 * 0.95)*100)/100.0, Modifier)
           SpacerH()
           MainCard("3 RM", round((rm1 * 0.93)*100)/100.0, Modifier)
           SpacerH()
           MainCard("4 RM", round((rm1 * 0.90)*100)/100.0, Modifier)
           SpacerH()
           MainCard("5 RM", round((rm1 * 0.87)*100)/100.0, Modifier)
           SpacerH()
           MainCard("6 RM", round((rm1 * 0.85)*100)/100.0, Modifier)
           SpacerH()
           MainCard("7 RM", round((rm1 * 0.83)*100)/100.0, Modifier)
       }

}
@Composable
fun MainCard(title:String,number:Double,modifier: Modifier = Modifier){

    Card(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(8.dp),
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ){
            Text(
                text=title,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text="$number kg",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}