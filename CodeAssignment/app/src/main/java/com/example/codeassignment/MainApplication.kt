package com.example.codeassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * The Application class annotated with @HiltAndroidApp.
 * This triggers Hilt's code generation and makes the app ready for dependency injection.
 */
@HiltAndroidApp
class MainApplication : Application()
