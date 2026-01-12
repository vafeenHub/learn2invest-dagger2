package ru.surf.learn2invest.presentation.ui.components.screens.trading_password.remove

import android.os.Bundle
import ru.surf.learn2invest.presentation.R
import ru.surf.learn2invest.presentation.di.DaggerPresentationComponent
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.common.TradingPasswordActivity
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.common.TradingPasswordActivityState
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.common.TradingPasswordActivityViewModel
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.create.TradingPasswordChangeActivityViewModel
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import ru.vafeen.core.di.coreComponent
import javax.inject.Inject
import javax.inject.Provider

/**
 * Активити для удаления торгового пароля.
 *
 * Инициализирует ViewModel с начальными данными и отображает UI для удаления пароля.
 */

internal class TradingPasswordRemoveActivity : TradingPasswordActivity() {
    @Inject
    lateinit var viewModelProvider: Provider<TradingPasswordChangeActivityViewModel.Factory>

    override val viewModel: TradingPasswordActivityViewModel by viewModelCreator {
        viewModelProvider.get().create(
            TradingPasswordActivityState(
                mainText = this.getString(R.string.remove_trpas),
                mainButtonText = this.getString(R.string.remove),
                passMatchTV = false,
                passwordEditEditText = "",
                passwordConfirmEditText = ""
            )
        )
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
