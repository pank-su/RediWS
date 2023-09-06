package su.pank.rediexpress.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import su.pank.rediexpress.R
import su.pank.rediexpress.model.Page
import su.pank.rediexpress.viewmodel.OnBoardingViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavHostController, viewModel: OnBoardingViewModel = viewModel()) {


    LaunchedEffect(viewModel.isSeen){
        if (viewModel.isSeen) navController.navigate("auth")
    }

    val pages = listOf(
        Page(
            "Quick Delivery At Your Doorstep",
            "Enjoy quick pick-up and delivery to your destination",
            R.drawable.first
        ),
        Page(
            "Flexible Payment",
            "Different modes of payment either before and after delivery without stress",
            R.drawable.second
        ),
        Page(
            "Real-time Tracking",
            "",
            R.drawable.thirst
        )
    )
    val pagerState = rememberPagerState(0)
    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            pageCount = 3,
            state = pagerState,
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            val page = pages[it]
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = page.image),
                    contentDescription = null,
                    modifier = Modifier.size(346.dp),
                    contentScale = ContentScale.FillWidth
                )
                Text(
                    text = page.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 62.dp)
                )
                Text(
                    text = page.description,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp, start = 60.dp, end = 60.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 82.dp)
        ) {
            Row(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pages.size) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color(0xFF0560FA) else Color(
                            0xFFA7A7A7
                        )
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(9.dp)
                    )
                }
            }
            val isLastPage by remember {
                derivedStateOf { pagerState.currentPage == pages.size - 1 }
            } 
            if (!isLastPage){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 82.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val coroutineScope = rememberCoroutineScope()
                    OutlinedButton(onClick = { coroutineScope.launch {
                        pagerState.animateScrollToPage(2)
                    }}) {
                        Text(text = "Skip")
                    }

                    Button(onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                         }) {
                        Text(text = "Next")
                    }
                }
            } else{
                val context = LocalContext.current
                Button(onClick = { viewModel.isSeenEd(context) }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)) {
                    Text(text = "Sign Up")
                }
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {

                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Already have an account?")
                        Text(text = "Sign In")
                    }
                }
                
            }
            

        }
    }


}

