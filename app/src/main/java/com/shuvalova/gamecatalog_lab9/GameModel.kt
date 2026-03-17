import androidx.annotation.StringRes
import com.shuvalova.gamecatalog_lab9.R

data class Game(
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int,
    val imageResId: Int,
    val year: Int,
    val genre: String
)

val gamesList = listOf(
    Game(
        titleResId = R.string.game_rdr_title,
        descriptionResId = R.string.game_rdr_desc,
        imageResId = R.drawable.rdr,
        year = 2010,
        genre = "Action / Adventure"
    ),
    Game(
        titleResId = R.string.game_rdr2_title,
        descriptionResId = R.string.game_rdr2_desc,
        imageResId = R.drawable.rdr2,
        year = 2018,
        genre = "Action / Adventure"
    ),
    Game(
        titleResId = R.string.game_ln1_title,
        descriptionResId = R.string.game_ln1_desc,
        imageResId = R.drawable.little,
        year = 2016,
        genre = "Horror / Puzzle"
    ),
    Game(
        titleResId = R.string.game_ln2_title,
        descriptionResId = R.string.game_ln2_desc,
        imageResId = R.drawable.little2,
        year = 2021,
        genre = "Horror / Puzzle"
    ),
    Game(
        titleResId = R.string.game_ln3_title,
        descriptionResId = R.string.game_ln3_desc,
        imageResId = R.drawable.little3,
        year = 2024,
        genre = "Horror / Puzzle"
    ),
    Game(
        titleResId = R.string.game_witcher3_title,
        descriptionResId = R.string.game_witcher3_desc,
        imageResId = R.drawable.witcher,
        year = 2015,
        genre = "RPG"
    ),
    Game(
        titleResId = R.string.game_avatar_title,
        descriptionResId = R.string.game_avatar_desc,
        imageResId = R.drawable.avatar,
        year = 2023,
        genre = "Action / Adventure"
    ),
    Game(
        titleResId = R.string.game_sh2_title,
        descriptionResId = R.string.game_sh2_desc,
        imageResId = R.drawable.silenthill2,
        year = 2024,
        genre = "Horror"
    )
)