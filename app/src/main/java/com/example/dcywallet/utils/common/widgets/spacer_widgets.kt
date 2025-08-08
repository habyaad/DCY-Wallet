package com.example.dcywallet.utils.common.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun VerticalSpace(height: Int,) {
    Box(modifier = Modifier.height(height = height.dp))
}

@Composable
fun HorizontalSpace(width: Int,) {
    Box(modifier = Modifier.width(width = width.dp))
}
@Preview
@Composable
fun VSPreview(){
    VerticalSpace(10)
}

@Preview
@Composable
fun HSPreview(){
    HorizontalSpace(10)
}