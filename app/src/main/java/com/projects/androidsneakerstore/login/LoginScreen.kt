package com.projects.androidsneakerstore.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLoginClick : () -> Unit){
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding(),
            contentPadding = PaddingValues(vertical = 16.dp)
        ){
            item (key = "Header"){ Header() }
            item (key = "Username TextField"){
                UsernameTextField(username)
            }
            item (key = "Password TextField"){
                PasswordTextField(password)
            }
            item { LoginButton(onLoginClick = onLoginClick) }
        }
}

@Composable
fun LoginButton(onLoginClick: () -> Unit){
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .padding(vertical = 8.dp)
                .clip(RoundedCornerShape(32.dp))
            ,
            onClick = onLoginClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Sign in",
                fontSize = 17.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(600)
            )
        }
}

@Composable
fun PasswordTextField(password: MutableState<String>) {
    val showPassword = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp)),
            value = password.value,
            onValueChange = {
                password.value = it
            },
            maxLines = 1,
            placeholder = {
                Text(
                    text = "Password",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 21.sp,
                    color = Color(0xFF8E8E93),
                    overflow = TextOverflow.Ellipsis

                )
            },
            visualTransformation = if (showPassword.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(onClick = { showPassword.value = !showPassword.value }) {
                    Icon(
                        imageVector = if (showPassword.value) Icons.Outlined.Info
                        else Icons.Filled.Info,
                        contentDescription =
                        if (showPassword.value) "Hide password" else "Show password"
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF6F6F6),
                unfocusedContainerColor = Color(0xFFF6F6F6),
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun UsernameTextField(username : MutableState<String>){
    Row (
        modifier = Modifier.padding(top = 52.dp, start = 16.dp, end = 16.dp)

    ){
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(4.dp)),
            value = username.value,
            onValueChange = {
                username.value = it
            },
            maxLines = 1,

            placeholder = {
                Text(
                    text = "Username",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 21.sp,
                    color = Color(0xFF8E8E93),
                    overflow = TextOverflow.Ellipsis
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF6F6F6),
                unfocusedContainerColor = Color(0xFFF6F6F6),
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent

            )
        )
    }
}

@Composable
fun Header(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(24.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back"
            )
        }
        Text(
            text = "Welcome Back!",
            fontSize = 17.sp,
            fontWeight = FontWeight(600),
            lineHeight = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
    }
}
