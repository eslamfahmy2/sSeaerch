package com.fahmy.presentation.ui.city.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fahmy.presentation.ui.city.CityIntent
import com.fahmy.presentation.ui.city.CityState
import com.fahmy.presentation.ui.city.CityViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun CityScreen(viewModel: CityViewModel) {

    val coroutineScope = rememberCoroutineScope()

    val state by remember { viewModel.state }

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {

            Column() {

                Text(
                    text = "Cities",
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold,
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    value = viewModel.query.value,
                    onValueChange = {

                        coroutineScope.launch {
                            viewModel.userIntent.send(CityIntent.Filter(it))
                        }
                    },
                    label = {
                        Text(text = "Search")
                    },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.secondaryVariant,
                        fontSize = 16.sp
                    )

                )

            }

        },
        scaffoldState = scaffoldState,
        snackbarHost = {
            scaffoldState.snackbarHostState
        },
        bottomBar = {

        }
    ) {

        when (state) {
            is CityState.Error -> {
                (state as CityState.Error).message?.let {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = it,
                            actionLabel = "Dismiss",
                        )
                    }
                }
            }
            CityState.Loading -> {
                LoadingListScreen(
                    count = 3,
                    height = 250.dp
                )
            }
            is CityState.Success -> {

                val data = (state as CityState.Success).data

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(data) {
                        CityItem(city = it, onItemClick = { })
                    }
                }


            }
        }
    }

}