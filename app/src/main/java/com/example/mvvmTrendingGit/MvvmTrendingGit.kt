package com.example.mvvmTrendingGit

import android.app.Application

class MvvmTrendingGit: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MvvmTrendingGit
    }
}