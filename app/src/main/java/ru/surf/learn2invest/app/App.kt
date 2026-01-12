package ru.surf.learn2invest.app

import android.app.Application
import ru.surf.learn2invest.data.database_components.di_module.DaggerDataComponent
import ru.vafeen.core.di.CoreComponent


internal class App : Application(), CoreComponent.Provider {
    override val coreComponent: CoreComponent =
        DaggerDataComponent
            .builder()
            .context(this)
            .build()
}