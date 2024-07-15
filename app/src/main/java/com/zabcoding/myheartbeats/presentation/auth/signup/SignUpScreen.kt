package com.zabcoding.myheartbeats.presentation.auth.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.zabcoding.myheartbeats.presentation.auth.signup.components.EmailComponent
import com.zabcoding.myheartbeats.presentation.auth.signup.components.NameComponent
import com.zabcoding.myheartbeats.presentation.auth.signup.components.PasswordComponent
import com.zabcoding.myheartbeats.presentation.auth.signup.components.PhoneNumberComponent
import com.zabcoding.myheartbeats.presentation.auth.signup.components.SignUpBottomComponent
import com.zabcoding.myheartbeats.presentation.auth.signup.components.SignUpButtonComponent

@Composable
fun SignUpScreen(
    popBackStack: () -> Unit,
    navigateToHome: () -> Unit,
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {

    val state = signUpViewModel.state.collectAsState()
    val event = signUpViewModel::onEvent

    /*if (state.value.isSignUpSuccess) {
        navigateToHome()
    }*/

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
            contentDescription = "logo heartbeats",
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
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
                    text = "Registrarse",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray
                )

                NameComponent(
                    name = state.value.name,
                    onNameChange = { newNameValue ->
                        event(SignUpEvent.SetName(newNameValue))
                    }
                )
                PhoneNumberComponent(
                    phoneNumber = state.value.phoneNumber,
                    onPhoneNumberChange = { newPhoneValue ->
                        event(SignUpEvent.SetPhoneNumber(newPhoneValue))
                    }
                )
                EmailComponent(
                    email = state.value.email,
                    onEmailChange = { newEmailValue ->
                        event(SignUpEvent.SetEmail(newEmailValue))
                    }
                )
                PasswordComponent(
                    password = state.value.password,
                    onPasswordChange = { newPasswordValue ->
                        event(SignUpEvent.SetPassword(newPasswordValue))
                    }
                )
                SignUpButtonComponent(
                    text = "Registrarse",
                    onClick = {
                        //event(SignUpEvent.ButtonClicked)
                        navigateToHome()
                    }
                )
            }
        }
        SignUpBottomComponent(
            text = "Inicia Sesion",
            onButtonClick = { popBackStack() }
        )
    }
}