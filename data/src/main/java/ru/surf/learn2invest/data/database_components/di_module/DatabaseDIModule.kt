package ru.surf.learn2invest.data.database_components.di_module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.surf.learn2invest.data.database_components.L2IDatabase
import ru.vafeen.core.di.CoreScope

@Module
internal class DatabaseDIModule {
    @Provides
    @CoreScope
    internal fun injectDatabase(context: Context): L2IDatabase =
        Room.databaseBuilder(
            context = context, klass = L2IDatabase::class.java, name = L2IDatabase.Companion.NAME
        ).build()
}