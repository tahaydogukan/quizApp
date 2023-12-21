package com.tahayasindogukan.quizapp.dependincyInjection

import android.app.Application
import com.tahayasindogukan.quizapp.datasource.WordDataSource
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication():Application() {
}