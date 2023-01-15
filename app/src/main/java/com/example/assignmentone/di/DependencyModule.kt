package com.example.assignmentone.di


import com.example.assignmentone.common.Constants
import com.example.assignmentone.data.Api.DynaconApi
import com.example.assignmentone.data.Api.LobbyApi
import com.example.assignmentone.data.Api.SiteCoreApi
import com.example.assignmentone.data.repository.DynaconRepositoryImpl
import com.example.assignmentone.data.repository.SiteCoreRepositoryImpl
import com.example.assignmentone.data.repository.SportsLobbyRepositoryImpl
import com.example.assignmentone.domain.repository.DynaconRepository
import com.example.assignmentone.domain.repository.SiteCoreRepository
import com.example.assignmentone.domain.repository.SportsLobbyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DependencyModule {

    @Provides
    @Singleton
    fun provideDynaconApi():DynaconApi{
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_OF_DYNACON)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DynaconApi::class.java)
    }
    @Provides
    @Singleton
    fun provideSiteCoreApi():SiteCoreApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_OF_SITECORE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SiteCoreApi::class.java)
    }
    @Provides
    @Singleton
    fun providesLobbyApi():LobbyApi{
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_OF_SPORTSLOBBY)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LobbyApi::class.java)
    }


    @Provides
    @Singleton
    fun provideDynaconRepository(api:DynaconApi):DynaconRepository{
        return DynaconRepositoryImpl(api)
    }
    @Provides
    @Singleton
    fun provideSportsLobbyRprepository(api:LobbyApi):SportsLobbyRepository{
        return SportsLobbyRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideSiteCoreRepository(api:SiteCoreApi):SiteCoreRepository{
        return SiteCoreRepositoryImpl(api)
    }

}