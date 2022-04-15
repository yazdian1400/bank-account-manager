package ir.homework.bankaccount

import android.content.Context

object AccountRepository {
    var db : AppDatabase? = null
    var accountDao  : AccountDao? = null

    fun initDB(context : Context){
        db = AppDatabase.getAppDataBase(context)

        accountDao = db?.accountDao()

        //addTestData()
    }

    fun addAccountToDB(cardNum: String, balance: Int){
        db!!.accountDao().insert(Account(cardNum,AccountType.GHARZOLHASANE, balance))
    }

    fun getCount(): Int {
        return db!!.accountDao().getCount()
    }
}
