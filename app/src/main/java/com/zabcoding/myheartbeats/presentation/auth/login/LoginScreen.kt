package com.zabcoding.myheartbeats.presentation.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.zabcoding.myheartbeats.presentation.auth.login.components.LoginBottomComponent
import com.zabcoding.myheartbeats.presentation.auth.login.components.LoginComponent
import com.zabcoding.myheartbeats.presentation.auth.login.components.LoginTopComponent

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
    navigateToForgotPassword: () -> Unit,
    navigateToRegister: () -> Unit
) {
    val state = loginViewModel.state.collectAsState()
    val event = loginViewModel::onEvent

    /*if (state.value.isLoginSuccess) {
        navigateToHome()
    }*/

    if (state.value.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp)
        ) {
            val (header, body, footer) = createRefs()

            LoginTopComponent(
                modifier = Modifier
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            LoginComponent(
                modifier = Modifier
                    .constrainAs(body) {
                        top.linkTo(parent.top, margin = 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                email = state.value.email,
                onEmailChange = { newEmailValue ->
                    event(LoginEvent.EmailChanged(newEmailValue))
                },
                password = state.value.password,
                onPasswordChange = { newPasswordValue ->
                    event(LoginEvent.PasswordChanged(newPasswordValue))
                },
                onForgotPasswordClick = navigateToForgotPassword,
                onLoginButtonClick = {
                    //event(LoginEvent.LoginButtonClicked)
                    navigateToHome()
                }
            )

            LoginBottomComponent(
                modifier = Modifier
                    .constrainAs(footer) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                text = "Registrarse",
                onButtonClick = navigateToRegister
            )
        }
    }
}