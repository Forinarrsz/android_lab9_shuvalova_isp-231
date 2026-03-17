package com.shuvalova.gamecatalog_lab9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shuvalova.gamecatalog_lab9.ui.theme.Gamecatalog_lab9Theme
import gamesList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Gamecatalog_lab9Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Gamecatalog_lab9Theme {
        Greeting("Android")
    }
}
@Composable
fun MainScreen() {
    var currentIndex by remember { mutableStateOf(0) }
    var isFavorite by remember { mutableStateOf(false) }

    val currentGame = gamesList[currentIndex]

    val onNext = {
        currentIndex = (currentIndex + 1) % gamesList.size
        isFavorite = false
    }
    val onPrev = {
        currentIndex = (currentIndex - 1 + gamesList.size) % gamesList.size
        isFavorite = false
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        GameImageSection(imageResId = currentGame.imageResId)
        GameInfoSection(game = currentGame)

        Spacer(modifier = Modifier.weight(1f))
        ControlPanel(
            onPrevClick = onPrev,
            onNextClick = onNext,
            isFavorite = isFavorite,
            onFavoriteChange = { isFavorite = it }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Gamecatalog_lab9Theme {
        MainScreen()
    }
}