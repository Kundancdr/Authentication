package com.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AuthOption(
    modifier: Modifier = Modifier,
    image: Int,
    tint: Color? = null,
    contentDescription: String? = null,
    text : String
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.2f),
                shape = RoundedCornerShape(14.dp)
            )
            .clip(RoundedCornerShape(14.dp))
            .clickable { }
            .padding(horizontal = 35.dp, vertical = 8.dp),
             contentAlignment = Alignment.Center
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            if (tint != null) {
                Icon(
                    painter = painterResource(image),
                    contentDescription = contentDescription,
                    tint = tint,
                    modifier = Modifier.size(20.dp)
                )
            } else {
                Image(
                    painter = painterResource(image),
                    contentDescription = contentDescription,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = text, modifier = Modifier, fontSize = 12.sp , fontWeight = FontWeight.SemiBold)
        }

    }
}