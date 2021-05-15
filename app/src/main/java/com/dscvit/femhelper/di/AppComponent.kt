package com.dscvit.femhelper.di

import com.dscvit.femhelper.di.modules.*

val appComponent =
    listOf(apiModule, repoModule, viewModelModule, roomModule, wsModule)