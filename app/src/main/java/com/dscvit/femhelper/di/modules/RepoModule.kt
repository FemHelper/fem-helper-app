package com.dscvit.femhelper.di.modules

import com.dscvit.femhelper.repository.AppRepository
import org.koin.dsl.module

val repoModule = module {
    factory { AppRepository(get(), get()) }
}