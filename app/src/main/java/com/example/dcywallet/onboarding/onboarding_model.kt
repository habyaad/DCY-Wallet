package com.example.dcywallet.onboarding

import com.example.dcywallet.R

sealed class OnBoardingModel(val image:Int, val title: String, val subtitle:String) {
    object Onboard1: OnBoardingModel(R.drawable.candles, "Property", "Diversity" )
    object Onboard2: OnBoardingModel(R.drawable.trust_logo, "Safe", "Security" )
    object Onboard3: OnBoardingModel(R.drawable.rocket, "Convenient", "Transaction" )
    object Onboard4: OnBoardingModel(R.drawable.wallet, "Wallet Setup", "" )

}