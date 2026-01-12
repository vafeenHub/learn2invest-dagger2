package ru.surf.learn2invest.presentation.ui.components.screens.trading_password.create

import android.os.Bundle
import ru.surf.learn2invest.presentation.R
import ru.surf.learn2invest.presentation.di.DaggerPresentationComponent
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.common.TradingPasswordActivity
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.common.TradingPasswordActivityState
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.common.TradingPasswordActivityViewModel
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import ru.vafeen.core.di.coreComponent
import javax.inject.Inject
import javax.inject.Provider

/**
 * Активити для создания торгового пароля.
 *
 * Инициализирует ViewModel с начальными данными и отображает UI для создания пароля.
 */

internal class TradingPasswordCreateActivity : TradingPasswordActivity() {
    @Inject
    lateinit var viewModelProvider: Provider<TradingPasswordChangeActivityViewModel.Factory>

    override val viewModel: TradingPasswordActivityViewModel by viewModelCreator {
        viewModelProvider.get().create(
            TradingPasswordActivityState(
                mainText = this.getString(R.string.create_trpas),
                mainButtonText = this.getString(R.string.create),
                minLenTradingPasswordTV = false,
                notMoreThan2TV = false,
                noSeqMoreThan3TV = false,
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
