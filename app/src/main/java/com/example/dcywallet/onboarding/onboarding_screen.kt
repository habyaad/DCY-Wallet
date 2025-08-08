package com.example.dcywallet.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dcywallet.R
import com.example.dcywallet.utils.common.styles.gradientBrush
import com.example.dcywallet.utils.common.widgets.CustomGeneralButton
import com.example.dcywallet.utils.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable()
fun OnBoardingScreen(navController: NavHostController) {
    val items = (0..2).toList()
    val pages = listOf<OnBoardingModel>(
        OnBoardingModel.Onboard1,
        OnBoardingModel.Onboard2,
        OnBoardingModel.Onboard3
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })

    Scaffold(
        Modifier.fillMaxWidth(1f),
        containerColor = colorResource(id = R.color.gray24),
        bottomBar = {

            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 8.dp, bottom = 42.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(modifier = Modifier.padding(all = 8.dp)) {
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            items(items) {
                                Box(
                                    modifier = Modifier
                                        .background(
                                            colorResource(id = if (it == pagerState.currentPage) R.color.primary5 else R.color.gray18),
                                            shape = CircleShape
                                        )
                                        .width(8.dp)
                                        .height(8.dp)
                                ) {

                                }
                            }
                        }
                    }
                    Box(modifier = Modifier.height(24.dp))
                    CustomGeneralButton(text = "Get started") {
                        navController.navigate(route = Screens.WalletSetup.route) {
                            popUpTo(0)}
                    }

                }

            }

        }) { innerPadding ->

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            OnboardView(innerPadding, pages[page])
        }
        // OnboardView(innerPadding, OnBoardingModel.Onboard1)

    }

}

@Preview
@Composable
fun OnboardingPreview() {
    val context = LocalContext.current.applicationContext
    OnBoardingScreen(navController = NavHostController(context))
}

@Composable
fun OnboardView(innerPadding: PaddingValues, onBoardingModel: OnBoardingModel) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(1f)

    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = onBoardingModel.image),
                contentDescription = "onboarding-image",
                modifier = Modifier
                    .height(295.dp)
                    .width(295.dp),
                contentScale = ContentScale.FillWidth
            )
            Box(modifier = Modifier.height(58.dp))
            Text(
                text = onBoardingModel.title,
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight(400),
                lineHeight = 56.sp,
            )
            Text(
                text = onBoardingModel.subtitle,
                fontSize = 40.sp,
                color = Color.White,
                style = TextStyle(
                    gradientBrush
                ),
                lineHeight = 56.sp,
                fontWeight = FontWeight(700)
            )

        }
    }
}