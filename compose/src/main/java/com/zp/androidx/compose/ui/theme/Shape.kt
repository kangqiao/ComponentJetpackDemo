package com.zp.androidx.compose.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
//    small = RoundedCornerShape(4.dp),
//    medium = RoundedCornerShape(4.dp),
//    large = RoundedCornerShape(0.dp),
    small = RoundedCornerShape(percent = 50),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(0.dp)
)