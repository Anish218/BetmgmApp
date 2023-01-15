package com.example.assignmentone.presentation.ComposeView

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PromotionScreenView() {
    Box(
        modifier = Modifier
            .size(64.dp)
            .wrapContentSize()

            .shimmerBackground(RoundedCornerShape(4.dp))
    ){
        Text(text = "Promotion screen",fontSize = 25.sp)}
}