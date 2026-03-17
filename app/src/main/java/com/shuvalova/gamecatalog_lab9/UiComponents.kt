package com.shuvalova.gamecatalog_lab9

import Game
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameImageSection(imageResId: Int) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "Game Cover",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        contentScale = ContentScale.Crop
    )
}
@Composable
fun GameInfoSection(game: Game) {
    Column(modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween)
    {
        Text(
            text = stringResource(game.titleResId),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "${game.year} г.", color = MaterialTheme.colorScheme.primary)
            Text(text = game.genre, color = MaterialTheme.colorScheme.secondary)
        }
        Text(
            text = stringResource(game.descriptionResId),
            fontSize = 16.sp,
            lineHeight = 24.sp
        )
    }
}
@Composable
fun ControlPanel(
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,
    isFavorite: Boolean,
    onFavoriteChange: (Boolean) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 8.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) { Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Add to favorite")
            Switch(
                checked = isFavorite,
                onCheckedChange = onFavoriteChange
            )
        }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = onPrevClick) {
                    Text("← Назад")
                }
                Button(onClick = onNextClick) {
                    Text("Вперед →")
                }
            }
        }
    }
}