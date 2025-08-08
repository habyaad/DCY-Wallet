package com.example.dcywallet.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dcywallet.R
import com.example.dcywallet.ui.theme.Gray9
import com.example.dcywallet.utils.common.styles.gradientBrush
import com.example.dcywallet.utils.common.widgets.CustomGeneralButton
import com.example.dcywallet.utils.common.widgets.CustomTextField
import com.example.dcywallet.utils.common.widgets.HorizontalSpace
import com.example.dcywallet.utils.common.widgets.VerticalSpace

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportWalletScreen(
    navHostController: NavHostController,
    viewModel: ImportAuthViewModel = viewModel()
) {
    val seedPhrase by viewModel.seedPhrase.collectAsState()
    val newPassword by viewModel.newPassword.collectAsState()
    val confirmNewPassword by viewModel.confirmNewPassword.collectAsState()
    var faceIDBool by remember {
        mutableStateOf(true)
    }
    val formValidated by viewModel.formValidated.collectAsState()

    Scaffold(
        containerColor = colorResource(id = R.color.gray24),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Import From Seed",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable { navHostController.popBackStack() }

                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = colorResource(id = R.color.gray24))
            )
        }, bottomBar = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 8.dp, bottom = 42.dp)
            ) {
                CustomGeneralButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(gradientBrush, shape = RoundedCornerShape(80.dp)),
                    disabled = !formValidated,
                    text = "Create a new wallet",
                ) {

                }
            }

        }) { insetPadding ->
        Column(
            Modifier
                .padding(insetPadding)
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            VerticalSpace(height = 40)
            Row(verticalAlignment = Alignment.CenterVertically) {
                CustomTextField(value = seedPhrase, labelText = "SeedPhrase", singleLine = false) {
                    viewModel.onChangedSeedPhrase(it)
                }

                HorizontalSpace(width = 16)
                Icon(
                    painter = painterResource(id = R.drawable.scan),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(start = 16.dp)

                )
            }
            VerticalSpace(height = 24)
            CustomTextField(
                value = newPassword,
                modifier = Modifier.fillMaxWidth(),
                labelText = "New Password"
            ) {
                viewModel.onChangedNewPassword(it)
            }
            VerticalSpace(height = 4)
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Must be at least 8 characters",
                color = colorResource(id = R.color.gray12)
            )
            VerticalSpace(height = 24)
            CustomTextField(
                value = confirmNewPassword,
                modifier = Modifier.fillMaxWidth(),
                labelText = "Confirm Password"
            ) {
                viewModel.onChangedConfirmNewPassword(it)
            }
            VerticalSpace(height = 24)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 12.dp, bottom = 12.dp),
                    text = "Sign in with Face ID?",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Switch(
                    checked = faceIDBool,
                    onCheckedChange = { faceIDBool = it },
                    colors = SwitchDefaults.colors(checkedTrackColor = colorResource(id = R.color.primary5))
                )
            }
            VerticalSpace(height = 24)
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "By proceeding, you agree to these Term and Conditions.",
                color = Gray9
            )
        }
    }
}

@Preview
@Composable
fun NewPreview() {
    val context = LocalContext.current.applicationContext
    ImportWalletScreen(navHostController = NavHostController(context), ImportAuthViewModel())
}