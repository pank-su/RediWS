package su.pank.rediexpress

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import su.pank.rediexpress.model.Page
import su.pank.rediexpress.screen.Auth
import su.pank.rediexpress.screen.OnBoardingScreen
import su.pank.rediexpress.screen.SplashScreen
import su.pank.rediexpress.viewmodel.OnBoardingViewModel
import su.pank.rediexpress.viewmodel.OnBoardingViewModelFactory

@Composable
fun GeneralNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("onBoardingScreen") {
            val context = LocalContext.current
            val viewModel: OnBoardingViewModel = viewModel(factory = OnBoardingViewModelFactory(context))
            OnBoardingScreen(navController, viewModel)
        }
        composable("auth"){
            Auth()
        }
    }
}




