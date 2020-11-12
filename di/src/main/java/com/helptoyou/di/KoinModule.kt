package com.helptoyou.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Cicerone.Companion.create
import com.github.terrakok.cicerone.Router
import com.helptoyou.core.network.ApiFactory
import com.helptoyou.core.repository.CardsRepositoryImpl
import com.helptoyou.core.repository.CreditsRepositoryImpl
import com.helptoyou.core.repository.NewsRepositoryImpl
import com.helptoyou.domain.repository.CardsRepository
import com.helptoyou.domain.repository.CreditsRepository
import com.helptoyou.domain.repository.NewsRepository
import com.helptoyou.domain.usecase.*
import org.koin.dsl.module

val apiModule = module {
    single { ApiFactory.getApi() }
}

val repositoriesModule = module {
    single<CreditsRepository> { CreditsRepositoryImpl(get()) }
    single<CardsRepository> { CardsRepositoryImpl(get()) }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
}

val navigationModule = module {
    val cicerone: Cicerone<Router> = create()
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
}


val useCasesModule = module {
    single<GetCreditsUseCase> { GetCreditsUseCaseImpl(get()) }
    single<GetCardsUseCase> { GetCardsUseCaseImpl(get()) }
    single<GetAllNewsUseCase> { GetAllNewsUseCaseImpl(get()) }
}