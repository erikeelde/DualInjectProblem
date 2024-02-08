package com.example.dualinjectproblem

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import dagger.hilt.android.testing.OnComponentReadyRunner
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

// https://stackoverflow.com/questions/75605297/hilt-singleton-components-instantiated-multiple-times
class ApplicationInjectionExecutionRule() : TestRule {
    private val targetApplication: Application
        get() = ApplicationProvider.getApplicationContext()

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                OnComponentReadyRunner.addListener(
                    targetApplication, InitializerEntryPoint::class.java
                ) { entryPoint: InitializerEntryPoint ->
                    runOnUiThread {
//                        targetApplication.excecuteInjection()
                    }
                }
                base.evaluate()
            }
        }
    }
}