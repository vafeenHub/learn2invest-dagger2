package ru.surf.learn2invest.presentation.ui.components.screens.sign_in.changing_pin

import android.os.Bundle
import ru.surf.learn2invest.presentation.di.DaggerPresentationComponent
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.common.AuthActivity
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import ru.vafeen.core.di.coreComponent
import javax.inject.Inject
import javax.inject.Provider

/**
 * Активность для изменения PIN-кода.
 *
 * Наследует базовую функциональность аутентификации от [AuthActivity]
 * и использует специализированную ViewModel [AuthChangingPinActivityViewModel]
 */

internal class AuthChangingPinActivity() : AuthActivity() {
    @Inject
    lateinit var viewModelProvider: Provider<AuthChangingPinActivityViewModel>
    override val viewModel: AuthChangingPinActivityViewModel by viewModelCreator {
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