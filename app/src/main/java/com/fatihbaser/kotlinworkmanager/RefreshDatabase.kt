package com.fatihbaser.kotlinworkmanager

import android.content.Context
import androidx.core.content.contentValuesOf
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDatabase(context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams
) {
    override fun doWork(): Result {
        val getData=inputData
        refreshDatabase()
        return Result.success()
    }
    private fun refreshDatabase(){
        val sharedPreferences= context.getSharedPreferences("com.fatihbaser.kotlinworkmanager",Compiler.MODE_PRIVATE)
        val mySavedNumber=sharedPreferences.getInt("myNumber",0)
        mySavedNumber=mySavedNumber+1
        println(mySavedNumber)
        sharedPreferences.edit().putInt("myNumber",mySavedNumber)
    }
}