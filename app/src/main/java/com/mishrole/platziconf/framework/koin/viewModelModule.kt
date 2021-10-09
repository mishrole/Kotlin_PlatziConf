package com.mishrole.platziconf.framework.koin

import com.mishrole.platziconf.presentation.viewmodel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ConferenceViewModel() }
    viewModel { SpeakerViewModel() }
}