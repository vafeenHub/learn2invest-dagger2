package ru.surf.learn2invest.data.database_components.di_module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.surf.learn2invest.data.services.coin_icon_loader.CoinIconLoaderImpl
import ru.surf.learn2invest.data.services.settings_manager.SettingsManagerImpl
import ru.surf.learn2invest.data.services.settings_manager.SharedPreferencesValue
import ru.surf.learn2invest.domain.services.coin_icon_loader.CoinIconLoader
import ru.surf.learn2invest.domain.services.settings_manager.SettingsManager
import javax.inject.Singleton

@Module
internal class ServicesModule {
    @Provides
    fun provideCoinIconLoaderImpl(impl: CoinIconLoaderImpl): CoinIconLoader = impl
}

@Module
internal class SingletonServices {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context
            .getSharedPreferences(SharedPreferencesValue.NAME, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSettingsManager(impl: SettingsManagerImpl): SettingsManager = impl
}