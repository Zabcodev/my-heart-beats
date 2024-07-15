package com.zabcoding.myheartbeats.presentation.auth.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zabcoding.myheartbeats.R
import com.zabcoding.myheartbeats.presentation.auth.forgotpassword.components.ForgotBottomComponent
import com.zabcoding.myheartbeats.presentation.auth.forgotpassword.components.ForgotButtonComponent
import com.zabcoding.myheartbeats.presentation.auth.login.components.EmailComponent

@Composable
fun ForgotPasswordScreen(
    popBackStack: () -> Unit,
    forgotPasswordViewModel: ForgotPasswordViewModel = hiltViewModel()
) {

    val state = forgotPasswordViewModel.state.collectAsState()
    val event = forgotPasswordViewModel::onEvent

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_heart_beats_app),
            contentDescription = "logo-heartbeats",
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray,
                contentColor = Color.DarkGray
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Recuperar contraseña",
                    fontSize = 22.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold
                )
                EmailComponent(
                    email = state.value.email,
                    onEmailChange = { newEmailValue ->
                        event(ForgotPasswordEvent.SetEmail(newEmailValue))
                    }
                )
                ForgotButtonComponent(
                    text = "Enviar correo",
                    onClick = {
                        forgotPasswordViewModel.sendEmail(navigateToLogin = popBackStack)
                    }
                )
            }
        }
        ForgotBottomComponent(
            text = "Volver",
            onButtonClick = { popBackStack() }
        )
    }
}
