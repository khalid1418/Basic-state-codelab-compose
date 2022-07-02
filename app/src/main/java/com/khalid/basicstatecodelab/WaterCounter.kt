package com.khalid.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khalid.basicstatecodelab.ui.theme.WellnessTestItem

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    val count: MutableState<Int> = remember { mutableStateOf(0) }
    var showTask = remember {
        mutableStateOf(true)
    }
    Column(modifier = modifier.padding(16.dp)) {
        if (showTask.value){
            WellnessTestItem(taskName = "Have you taken your 15minute walk today", onClose = {  showTask.value = false})
        }


        Text(text = "you've had ${count.value} glasses.", modifier = modifier.padding(16.dp))
        Row() {


        Button(onClick = { count.value++ }, Modifier.padding(top = 8.dp) , enabled = count.value <10) {
            Text(text = "Add one")
            
            Button(onClick = { count.value = 0 } , modifier = modifier.padding(start = 8.dp)) {
                Text(text = "Clear Water count")

            }
        }
        }
    }
}