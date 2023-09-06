package su.pank.rediexpress.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import su.pank.rediexpress.R

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(null){
        delay(3000)
        navController.navigate("onBoardingScreen"){
            popUpTo("onBoardingScreen"){
                inclusive = true
            }
        }

    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.frame),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
    }

}