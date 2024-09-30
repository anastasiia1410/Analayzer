package com.example.analayzer.di

import androidx.room.Room
import com.example.analayzer.core.App
import com.example.analayzer.data.db.AppDatabase
import com.example.analayzer.data.db.DatabaseRepository
import com.example.analayzer.data.db.DatabaseRepositoryImpl
import com.example.analayzer.data.network.Api
import com.example.analayzer.data.network.NetworkRepository
import com.example.analayzer.data.network.NetworkRepositoryImpl
import com.example.analayzer.screens.message.MessageViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val dataModule = module {
    single { GsonBuilder().serializeNulls().create() }
    single {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://api.telegram.org/bot6437271270:AAHlpwBiLeHznUXBOVd6q5Z0-WDYmjVzpiY/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
    single { get<Retrofit>().create(Api::class.java) }
    single {
        val db = Room.databaseBuilder(get(), AppDatabase::class.java, "my_table.sqlite").build()
        db.messageDao()
    }
    single<NetworkRepository> { NetworkRepositoryImpl(get()) }
    single<DatabaseRepository> { DatabaseRepositoryImpl(get()) }
}

private val useCaseModule = module {

}

private val viewModelModule = module {
    viewModel { MessageViewModel(get(), get()) }

}

fun App.initKoin() {
    startKoin {
        androidContext(this@initKoin)
        modules(dataModule, useCaseModule, viewModelModule)
    }
}