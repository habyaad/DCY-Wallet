package com.example.dcywallet.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dcywallet.onboarding.OnBoardingScreen
import com.example.dcywallet.onboarding.WalletSetupScreen

@Composable
fun AppNavHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.Onboarding.route){
        composable(Screens.Onboarding.route){ OnBoardingScreen(navController) }
        composable(Screens.WalletSetup.route){ WalletSetupScreen(navController) }
        composable(Screens.ImportWallet.route){ OnBoardingScreen(navController) }
    }
}