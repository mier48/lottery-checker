package com.albertomier.lotterychecker.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.ui.theme.LotteryCheckerTheme
import com.albertomier.lotterychecker.ui.viewmodel.NumberViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LotteryCheckerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Body(viewModel)
                }
            }
        }
    }
}

@Composable
fun ShowProgressIndicator() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(modifier = Modifier.size(100.dp))
    }
}

@Composable
fun Body(viewModel: NumberViewModel) {
    val context = LocalContext.current

    val status: ApiResponseStatus<Any> by viewModel.status.observeAsState(initial = ApiResponseStatus.Stop())
    val numberData: com.albertomier.lotterychecker.domain.model.Number by viewModel.number.observeAsState(
        com.albertomier.lotterychecker.domain.model.Number()
    )

    var number by rememberSaveable { mutableStateOf("") }

    when (status) {
        is ApiResponseStatus.Error -> {
            Toast.makeText(
                context,
                stringResource(id = (status as ApiResponseStatus.Error<Any>).messageId),
                Toast.LENGTH_LONG
            ).show()
        }
        is ApiResponseStatus.Loading -> ShowProgressIndicator()
        is ApiResponseStatus.Success -> Unit
        is ApiResponseStatus.Stop -> Unit
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = number,
            onValueChange = { number = it },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Premio: " + numberData.prize,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = { viewModel.checkNumber(number) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 4.dp,
                    bottom = 4.dp,
                    end = 16.dp
                ),
                text = "Comprobar"
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LotteryCheckerTheme {
        Greeting("Android")
    }
}