package ru.surf.learn2invest.presentation.ui.components.screens.sign_in.sign_up

import androidx.activity.viewModels
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.common.AuthActivity


internal class AuthSignUpActivity : AuthActivity() {
    override val viewModel: AuthSignUpActivityViewModel by viewModels()
}