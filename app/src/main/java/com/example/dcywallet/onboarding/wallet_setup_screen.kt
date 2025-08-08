package com.example.dcywallet.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dcywallet.R
import com.example.dcywallet.auth.ImportAuthViewModel
import com.example.dcywallet.auth.ImportWalletScreen
import com.example.dcywallet.utils.common.styles.gradientBrush
import com.example.dcywallet.utils.common.widgets.CustomGeneralButton
import com.example.dcywallet.utils.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletSetupScreen(navController: NavHostController) {

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
                    CustomGeneralButton(text = "Import Using Seed Phrase") {
                        navController.navigate(route = Screens.WalletSetup.route) {
                            popUpTo(0)
                        }
                    }
                    Box(modifier = Modifier.height(16.dp))

                    CustomGeneralButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(gradientBrush, shape = RoundedCornerShape(80.dp)),
                        text = "Create a new wallet",
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                    ) {

                    }
                }

            }

        }) { innerPadding ->


        OnboardView(innerPadding, OnBoardingModel.Onboard4)

        // OnboardView(innerPadding, OnBoardingModel.Onboard1)

    }

}

@Preview
@Composable
fun NewPreview() {
    val context = LocalContext.current.applicationContext
    WalletSetupScreen(navController = NavHostController(context))
}