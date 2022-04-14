package ir.homework.bankaccount

import android.content.Context

object AccountRepository {
    var db : AppDatabase? = null
    var accountDao  : AccountDao? = null

    fun initDB(context : Context){
        db = AppDatabase.getAppDataBase(context)

        accountDao = db?.questionDao()

        //addTestData()
    }
}
