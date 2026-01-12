package ru.surf.learn2invest.presentation.di

import dagger.Component
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.buy_dialog.BuyDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.delete_profile.DeleteProfileDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.refill_account_dialog.RefillAccountDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.reset_stats.ResetStatsDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.sell_dialog.SellDialog
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.asset_overview.AssetOverviewFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.asset_review.AssetReviewActivity
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.history.HistoryFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.marketreview.MarketReviewFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.portfolio.PortfolioFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.profile.ProfileFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.subhistory.SubHistoryFragment
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.changing_pin.AuthChangingPinActivity
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.sign_in.AuthSignInActivity
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.sign_up.AuthSignUpActivity
import ru.surf.learn2invest.presentation.ui.components.screens.sign_up.SignUpActivity
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.change.TradingPasswordChangeActivity
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.create.TradingPasswordCreateActivity
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.remove.TradingPasswordRemoveActivity
import ru.surf.learn2invest.presentation.ui.main.MainActivity
import ru.vafeen.core.di.CoreComponent

@Component(dependencies = [CoreComponent::class])
internal interface PresentationComponent {
    fun inject(authSignUpActivity: AuthSignUpActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(signUpActivity: SignUpActivity)
    fun inject(authSignInActivity: AuthSignInActivity)
    fun inject(authChangingPinActivity: AuthChangingPinActivity)
    fun inject(tradingPasswordCreateActivity: TradingPasswordCreateActivity)
    fun inject(tradingPasswordChangeActivity: TradingPasswordChangeActivity)
    fun inject(tradingPasswordRemoveActivity: TradingPasswordRemoveActivity)
    fun inject(buyDialog: BuyDialog)
    fun inject(sellDialog: SellDialog)
    fun inject(deleteProfileDialog: DeleteProfileDialog)
    fun inject(resetStatsDialog: ResetStatsDialog)
    fun inject(refillAccountDialog: RefillAccountDialog)
    fun inject(assetOverviewFragment: AssetOverviewFragment)
    fun inject(assetReviewActivity: AssetReviewActivity)
    fun inject(historyFragment: HistoryFragment)
    fun inject(marketReviewFragment: MarketReviewFragment)
    fun inject(portfolioFragment: PortfolioFragment)
    fun inject(profileFragment: ProfileFragment)
    fun inject(subHistoryFragment: SubHistoryFragment)
}