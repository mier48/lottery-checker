package com.albertomier.lotterychecker.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albertomier.lotterychecker.R
import com.albertomier.lotterychecker.core.extensions.formatDate
import com.albertomier.lotterychecker.ui.theme.LotteryCheckerTheme
import com.albertomier.lotterychecker.ui.viewmodel.NumberViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.util.concurrent.ExecutorService

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

    override fun onResume() {
        super.onResume()
        viewModel.getNumbers()
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

@androidx.camera.core.ExperimentalGetImage
@Composable
fun  Body(viewModel: NumberViewModel) {
    val context = LocalContext.current
    viewModel.getNumbers()

    // val status: ApiResponseStatus<Any> by viewModel.status.observeAsState(initial = ApiResponseStatus.Stop())
//    val numberData: com.albertomier.lotterychecker.domain.model.Number by viewModel.number.observeAsState(
//        com.albertomier.lotterychecker.domain.model.Number()
//    )
//
//    var number by rememberSaveable { mutableStateOf("") }

    //viewModel.getNumbers()

    //Log.e("TAGG", "START")

//    when (status) {
//        is ApiResponseStatus.Error -> {
//            Toast.makeText(
//                context,
//                stringResource(id = (status as ApiResponseStatus.Error<Any>).messageId),
//                Toast.LENGTH_LONG
//            ).show()
//        }
//        is ApiResponseStatus.Loading -> ShowProgressIndicator()
//        is ApiResponseStatus.Success -> Unit
//        is ApiResponseStatus.Stop -> Unit
//    }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("+") },
                backgroundColor = Color.Red,
                contentColor = Color.White,
                onClick = {
                    context.startActivity(Intent(context, CameraActivity::class.java))
                }
            )
        },
        content = {
            SetContent(
                modifier = Modifier.padding(bottom = it.calculateBottomPadding()),
                viewModel
            )
        })
}

@Composable
fun SetContent(modifier: Modifier, viewModel: NumberViewModel) {
    val numberList: List<com.albertomier.lotterychecker.domain.model.Number> by viewModel.numberList.observeAsState(
        initial = emptyList()
    )

    Box {
        LazyColumn {
            itemsIndexed(numberList) { _, item ->
                ItemList(item = item, viewModel) { number ->
                    //viewModel.checkNumber(number)
                }
            }
        }
    }
}

@Composable
fun ItemList(
    item: com.albertomier.lotterychecker.domain.model.Number,
    viewModel: NumberViewModel,
    onItemSelected: (item: String) -> Unit
) {
    val prize = item.prize

    Card(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.number,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = "$prize €",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = item.createdAt.formatDate(),
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            IconButton(onClick = { viewModel.removeNumber(item.number) }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null,
                    tint = Color(0xFFFF3300),
                )
            }
            IconButton(onClick = { viewModel.checkNumber(item.number) }) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = null,
                    tint = Color(0xFF33FF00),
                )
            }
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

@Composable
fun boldTextStyle(
    color: Color = MaterialTheme.colors.onPrimary,
    fontSize: TextUnit = Size.textBoldSizeGlobal,
    fontWeight: FontWeight? = Style.fontWeightBoldGlobal,
    fontStyle: FontStyle? = FontStyle.Normal,
    fontFamily: FontFamily? = FontFamily(Font(R.font.dmsansbold)),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    background: Color = Color.Unspecified,
    textDecoration: TextDecoration? = TextDecoration.None,
    textAlign: TextAlign? = TextAlign.Start,
    textDirection: TextDirection? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
): TextStyle {
    return TextStyle(
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        background = background,
        textDecoration = textDecoration,
        textAlign = textAlign,
        textDirection = textDirection,
        lineHeight = lineHeight,
    )
}

object Size {
    var textBoldSizeGlobal = 16.0.sp
    var textPrimarySizeGlobal = 16.0.sp
    var textSecondarySizeGlobal = 14.0.sp
}

object Style {
    var fontWeightBoldGlobal: FontWeight = FontWeight.Bold
    var fontWeightPrimaryGlobal: FontWeight = FontWeight.Normal
    var fontWeightSecondaryGlobal: FontWeight = FontWeight.Normal

}
