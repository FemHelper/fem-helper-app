package com.dscvit.femhelper.di.modules

import com.dscvit.femhelper.network.ApiClient
import com.dscvit.femhelper.network.PostAuthApiService
import com.dscvit.femhelper.network.PreAuthApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val apiModule = module {
    factory(named("PRE_AUTH")){ PreAuthApiService.createRetrofit(get()) }
    factory(named("POST_AUTH")) { PostAuthApiService.createRetrofit(get()) }
    factory { ApiClient(get(named("PRE_AUTH")), get(named("POST_AUTH"))) }
}