package com.example.dcywallet.utils.common.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dcywallet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    labelText: String = "",
    visibleText: Boolean = true,
    singleLine: Boolean = true,
    onValueChanged: (String) -> Unit
) {
    var showText by remember {
        mutableStateOf(visibleText)
    }
    TextField(
        value = value,
        modifier = modifier
            .border(
                BorderStroke(
                    width = 1.dp, color = colorResource(
                        id = R.color.gray22,
                    )
                ),
                shape = RoundedCornerShape(16.dp),
            )
            .background(color = Color.Unspecified),
        label = {
            Text(
                text = labelText,
                color = colorResource(id = R.color.gray12)
            )
        },
        onValueChange = onValueChanged,
        textStyle = TextStyle(
            color =
            Color.White
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.eye_visble),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.clickable { showText = !showText }
            )
        },
        shape = RoundedCornerShape(16.dp),
        maxLines = 4,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Unspecified,
            focusedBorderColor = Color.Unspecified,
            focusedLabelColor = Color.DarkGray,
        ),
        singleLine = singleLine,
        visualTransformation = if (showText) PasswordVisualTransformation() else VisualTransformation.None,
    )

}

@Preview
@Composable
fun CTFPreview() {
    CustomTextField(value = "") {}
}