package com.example.dcywallet.utils.navigation

sealed class Screens(val route:String) {
    object Onboarding: Screens("onboarding-screen")

    object WalletSetup: Screens("wallet-setup-screen")

    object ImportWallet: Screens("import-wallet-screen")
}