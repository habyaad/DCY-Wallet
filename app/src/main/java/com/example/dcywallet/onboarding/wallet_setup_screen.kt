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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dcywallet.R
import com.example.dcywallet.utils.common.styles.gradientBrush

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
                    Button(
                        onClick = { /*TODO*/ },
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(
                                id = R.color.gray21
                            )
                        ),
                        shape = RoundedCornerShape(corner = CornerSize(80.dp))
                    ) {
                        Text(
                            text = "Import Using Seed Phrase",
                            //Modifier.padding(vertical = 12.dp),
                            fontSize = 16.sp
                        )
                    }
                    Box(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(gradientBrush, shape = RoundedCornerShape(80.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(corner = CornerSize(80.dp))
                    ) {
                        Text(
                            text = "Create a new wallet",
                            Modifier.padding(vertical = 12.dp),
                            fontSize = 16.sp
                        )
                    }
                }

            }

        }) { innerPadding ->


        OnboardView(innerPadding, OnBoardingModel.Onboard4)

        // OnboardView(innerPadding, OnBoardingModel.Onboard1)

    }

}