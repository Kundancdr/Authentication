package com.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authenticationdemo.R



@Preview(showSystemUi = true)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var isLoginWithMobile by remember { mutableStateOf(true) }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .size(50.dp)
                    .padding(top = 10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Welcome Back! Glad To \n        See You, Again",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )
        }


        ToggleLoginOption(isLoginWithMobile) {
            isLoginWithMobile = it
        }


        if (isLoginWithMobile) {
            InputField(
                label = "Mobile Number",
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                leadingText = "+91"
            )
        } else {
            InputField(
                label = "Email",
                value = email,
                onValueChange = { email = it }
            )
        }


        InputField(
            label = "Password",
            value = password,
            onValueChange = { password = it },
            isPassword = true
        )


        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small
        ) {
            Text(
                text = "Login",
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }


        DividerSection()


        AuthenticationOptions()

                Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Don't have an account? ",
                fontSize = 16.sp,
            )
            Text(
                text = "Register",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {  }
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Divider(
                modifier = Modifier
                    .width(80.dp),
                color = Color.Black,
                thickness = 4.dp
            )
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    leadingText: String? = null
) {
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            modifier = Modifier.padding(bottom = 3.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Enter $label") },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            leadingIcon = leadingText?.let {
                { Text(text = it, fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(end = 3.dp)) }
            },
            shape = MaterialTheme.shapes.small
        )
    }
}

@Composable
fun ToggleLoginOption(isLoginWithMobile: Boolean, onToggle: (Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .background(Color.White, shape = MaterialTheme.shapes.large)
            .border(1.dp, color = Color.LightGray)
            .clip(MaterialTheme.shapes.large)
            .padding(1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { onToggle(true) },
                modifier = Modifier
                    .weight(1f)
                    .height(38.dp)
                    .background(if (isLoginWithMobile) Color.LightGray else Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(text = "Phone number", color = Color.Black)
            }
            Button(
                onClick = { onToggle(false) },
                modifier = Modifier
                    .weight(1f)
                    .height(38.dp)
                    .background(if (!isLoginWithMobile) Color.LightGray else Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(text = "Email", color = Color.Black)
            }
        }
    }
}

@Composable
fun DividerSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier.weight(1f), color = Color.Gray.copy(alpha = 0.5f), thickness = 1.dp)
        Text(
            text = "Or",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 8.dp).alpha(0.5f)
        )
        Divider(modifier = Modifier.weight(1f), color = Color.Gray.copy(alpha = 0.5f), thickness = 1.dp)
    }
}

@Composable
fun AuthenticationOptions() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        AuthOption(image = R.drawable.google, text = "Login With Google")
        Spacer(modifier = Modifier.height(10.dp))
        AuthOption(image = R.drawable.facebook, text = "Login With Facebook")
        Spacer(modifier = Modifier.height(10.dp))
        AuthOption(image = R.drawable.apple, tint = MaterialTheme.colorScheme.onBackground, text = "Login With Apple")
    }
}



