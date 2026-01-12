package ru.surf.learn2invest.presentation.ui.components.screens.sign_in.sign_in

import android.os.Bundle
import androidx.activity.viewModels
import ru.surf.learn2invest.presentation.di.DaggerPresentationComponent
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.common.AuthActivity
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.sign_up.AuthSignUpActivityViewModel
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import ru.vafeen.core.di.coreComponent
import javax.inject.Inject
import javax.inject.Provider
import kotlin.getValue

/**
 * Активность для входа по PIN-коду.
 *
 * Наследует базовую функциональность от [AuthActivity]
 * и использует [AuthSignInActivityViewModel] для управления логикой входа
 */

internal class AuthSignInActivity : AuthActivity() {
    @Inject
    lateinit var viewModelProvider: Provider<AuthSignInActivityViewModel>
    override val viewModel: AuthSignInActivityViewModel by viewModelCreator {
        viewModelProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerPresentationComponent
            .builder()
            .coreComponent(applicationContext.coreComponent)
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }
}