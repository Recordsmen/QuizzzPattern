package com.example.quizzzpattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.quizzzpattern.ui.MainViewModel
import com.example.quizzzpattern.ui.theme.QuizzzPatternTheme
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzzPatternTheme {
                QuizzzApp()
            }
        }
    }
}

enum class QuizzzScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Game(title = R.string.game),
    End(title = R.string.end),
}


@Composable
fun QuizzzApp(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = MainViewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = QuizzzScreen.valueOf(
        backStackEntry?.destination?.route ?: QuizzzScreen.Start.name
    )

    Scaffold { innerPadding ->
        val end by viewModel.end.observeAsState()
        val firstButton by viewModel.firstButton .observeAsState()
        val secondButton by viewModel.secondButton.observeAsState()
        val thirdButton by viewModel.thirdButton.observeAsState()
        val fourButton by viewModel.fourButton.observeAsState()
        val question by viewModel.question.observeAsState()

        val score by viewModel.score.observeAsState()

        NavHost(
            navController = navController,
            startDestination = QuizzzScreen.Start.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = QuizzzScreen.Start.name) {
                StartScreen(
                    modifier = modifier,
                    onGameNavigate = {navController.navigate(QuizzzScreen.Game.name)}
                )
            }
            composable(route = QuizzzScreen.Game.name) {
                GameScreen(
                    onSubmitButton = {
                        if(end == true){
                            navController.navigate(QuizzzScreen.End.name)
                    }else { viewModel.nextQuestion(it) }
                                     },
                    question = question ?: "",
                    firstButton = firstButton ?: "",
                    secondButton = secondButton ?: "",
                    thirdButton = thirdButton ?: "",
                    fourButton = fourButton ?: "",
                    end = end ?: false
                )
            }
            composable(route = QuizzzScreen.End.name) {
                EndScreen(
                    modifier = modifier,
                    onRestartGame = {
                        navController.navigate(QuizzzScreen.Game.name)
                        viewModel.restartGame() },
                    score ?: 0
                )
            }
        }
    }
}
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onGameNavigate:() -> Unit,
){
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.first),
            contentDescription = null,
            modifier = Modifier.width(1000.dp)
        )
        Text(textAlign = TextAlign.Center,
            text = stringResource(R.string.description),
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(8.dp))

        IconButton(
            modifier = modifier
                .size(100.dp)
                .clip(shape = RoundedCornerShape(25))
                .background(Color.Gray)
            ,
            onClick = onGameNavigate,
        ){
            Icon(Icons.Filled.PlayArrow,"")
        }
    }
}
@Composable
fun GameScreen(
    modifier: Modifier = Modifier ,
    onSubmitButton:(String) -> Unit,
    question:String,
    firstButton:String,
    secondButton:String,
    thirdButton:String,
    fourButton:String,
    end:Boolean
){
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.second),
            contentDescription = null,
            modifier = Modifier.width(1000.dp)
        )
        Text(
            textAlign = TextAlign.Center ,
            text = question,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier.padding(12.dp)) {
            Row(modifier.padding(12.dp)){
                Button(
                    modifier = modifier.padding(6.dp),
                    onClick = { onSubmitButton(firstButton) }
                ){
                    Text(text = firstButton)
                }
                Button(
                    modifier = modifier.padding(6.dp),
                    onClick = { onSubmitButton(secondButton) }
                ){
                    Text(text = secondButton)
                }
            }
            Row(modifier.padding(12.dp)){
                Button(
                    modifier = modifier.padding(6.dp),
                    onClick = { onSubmitButton(thirdButton) }
                ){
                    Text(text = thirdButton)
                }
                Button(
                    modifier = modifier.padding(6.dp),
                    onClick = { onSubmitButton(fourButton) }
                ){
                    Text(text = fourButton)
                }
            }
        }
    }
}
@Composable
fun EndScreen(
    modifier: Modifier = Modifier,
    onRestartGame:() -> Unit,
    score:Int
){
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.orig),
            contentDescription = null,
            modifier = Modifier.width(1000.dp)
        )
        Text(text = "Your score: $score", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            modifier = modifier,
            onClick = onRestartGame
        ){
            Text(text = stringResource(id = R.string.play))
        }
    }
}


