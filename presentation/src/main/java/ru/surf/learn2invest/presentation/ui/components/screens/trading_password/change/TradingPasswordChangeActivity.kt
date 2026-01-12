package ru.surf.learn2invest.presentation.ui.components.screens.trading_password.change

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
 * Активити для смены торгового пароля.
 *
 * Инициализирует ViewModel с начальными значениями и отображает UI для смены пароля.
 */

internal class TradingPasswordChangeActivity : TradingPasswordActivity() {

    @Inject
    lateinit var viewModelProvider: Provider<TradingPasswordChangeActivityViewModel.Factory>
    override val viewModel: TradingPasswordActivityViewModel by viewModelCreator {
        viewModelProvider.get().create(
            TradingPasswordActivityState(
                mainText = this.getString(R.string.change_trpas),
                mainButtonText = this.getString(R.string.change),
                minLenTradingPasswordTV = false,
                notMoreThan2TV = false,
                noSeqMoreThan3TV = false,
                passMatchTV = false,
                oldPasCorrectTV = false,
                passwordLastEditText = "",
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
