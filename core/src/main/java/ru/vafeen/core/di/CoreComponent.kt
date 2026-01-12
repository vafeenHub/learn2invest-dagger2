package ru.vafeen.core.di

import android.content.Context
import ru.surf.learn2invest.domain.animator.CustomAnimator
import ru.surf.learn2invest.domain.cryptography.FingerprintAuthenticator
import ru.surf.learn2invest.domain.cryptography.PasswordHasher
import ru.surf.learn2invest.domain.database.repository.AppDatabaseRepository
import ru.surf.learn2invest.domain.database.repository.AssetBalanceHistoryRepository
import ru.surf.learn2invest.domain.database.repository.AssetInvestRepository
import ru.surf.learn2invest.domain.database.repository.TransactionRepository
import ru.surf.learn2invest.domain.network.NetworkPagedRepository
import ru.surf.learn2invest.domain.network.NetworkRepository
import ru.surf.learn2invest.domain.services.coin_icon_loader.CoinIconLoader
import ru.surf.learn2invest.domain.services.settings_manager.SettingsManager

interface CoreComponent {
    interface Provider {
        val coreComponent: CoreComponent
    }

    fun CustomAnimator(): CustomAnimator
    fun FingerprintAuthenticator(): FingerprintAuthenticator
    fun PasswordHasher(): PasswordHasher
    fun AppDatabaseRepository(): AppDatabaseRepository
    fun AssetBalanceHistoryRepository(): AssetBalanceHistoryRepository
    fun AssetInvestRepository(): AssetInvestRepository
    fun TransactionRepository(): TransactionRepository
    fun NetworkPagedRepository(): NetworkPagedRepository
    fun NetworkRepository(): NetworkRepository
    fun CoinIconLoader(): CoinIconLoader
    fun SettingsManager(): SettingsManager
    fun Context(): Context
}

val Context.coreComponent
    get() = (this.applicationContext as CoreComponent.Provider).coreComponent