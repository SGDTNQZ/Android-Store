package com.projects.androidsneakerstore.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
    val usernameFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding(),
        ){
            Header()
            UsernameTextField(
                username,
                usernameFocusRequester,
                passwordFocusRequester
            )
            PasswordTextField(
                password,
                passwordFocusRequester,
                onLoginClick
            )
            Spacer(Modifier.weight(1f))
            LoginButton(onLoginClick = onLoginClick)
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
fun PasswordTextField(
    password: MutableState<String>,
    passwordFocusRequester: FocusRequester,
    onLoginClick: () -> Unit
) {
    val showPassword = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .focusRequester(passwordFocusRequester),
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {onLoginClick()}
            ),
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
fun UsernameTextField(
    username : MutableState<String>,
    usernameFocusRequester : FocusRequester,
    passwordFocusRequester : FocusRequester
){
    Row (
        modifier = Modifier
            .padding(top = 52.dp, start = 16.dp, end = 16.dp)

    ){
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .focusRequester(usernameFocusRequester),
            value = username.value,
            onValueChange = {
                username.value = it
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onGo = { passwordFocusRequester.requestFocus() }
            ),
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
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
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
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 10.dp),

        )
    }
}
