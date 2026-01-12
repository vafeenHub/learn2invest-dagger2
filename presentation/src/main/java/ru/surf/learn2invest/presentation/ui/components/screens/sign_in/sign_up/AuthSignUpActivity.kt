package ru.surf.learn2invest.presentation.ui.components.screens.sign_in.sign_up

import android.os.Bundle
import ru.surf.learn2invest.presentation.di.DaggerPresentationComponent
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.common.AuthActivity
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import ru.vafeen.core.di.coreComponent
import javax.inject.Inject
import javax.inject.Provider


internal class AuthSignUpActivity : AuthActivity() {

    @Inject
    lateinit var viewModelProvider: Provider<AuthSignUpActivityViewModel>
    override val viewModel: AuthSignUpActivityViewModel by viewModelCreator {
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