package ru.surf.learn2invest.data.database_components.di_module

import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.surf.learn2invest.data.network_components.NetworkRepositoryImpl
import ru.surf.learn2invest.data.network_components.paging.NetworkPagedRepositoryImpl
import ru.surf.learn2invest.data.services.coin_api_service.CoinAPIService
import ru.surf.learn2invest.data.services.coin_api_service.RetrofitLinks
import ru.surf.learn2invest.domain.network.NetworkPagedRepository
import ru.surf.learn2invest.domain.network.NetworkRepository

@Module
internal class NetworkDIModule {
    @Provides
    fun provideNetworkPagedRepository(impl: NetworkPagedRepositoryImpl): NetworkPagedRepository =
        impl

    @Provides
    fun provideImageLoader(context: Context): ImageLoader =
        ImageLoader.Builder(context = context).components {
            add(SvgDecoder.Factory())
        }.build()

    @Provides
    fun provideNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository =
        networkRepositoryImpl

    @Provides
    fun provideCoinAPIService(): CoinAPIService = Retrofit.Builder().baseUrl(RetrofitLinks.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BASIC)
                )
                .build()
        )
        .build()
        .create(CoinAPIService::class.java)
}