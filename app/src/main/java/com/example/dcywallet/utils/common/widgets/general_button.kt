package com.example.dcywallet.utils.common.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dcywallet.R
import com.example.dcywallet.ui.theme.Gray18
import com.example.dcywallet.utils.navigation.Screens

@Composable
fun CustomGeneralButton(
    modifier: Modifier = Modifier,
    disabled: Boolean = false,
    text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent
    ),
    onclick: () -> Unit,
) {
    Button(
        onClick = onclick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = if (disabled) ButtonDefaults.buttonColors(


            containerColor = colorResource(
                id = R.color.gray21
            ),
        ) else colors,
        shape = RoundedCornerShape(corner = CornerSize(80.dp))
    ) {
        Text(
            text = text,
            //Modifier.padding(vertical = 12.dp),
            color = if (disabled) Gray18 else Color.White,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun CGBPreview() {
    CustomGeneralButton(text = "sample") {}
}