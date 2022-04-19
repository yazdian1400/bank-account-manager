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

    fun addAccountToDB(cardNum: String, balance: Int, type: AccountType){
        db!!.accountDao().insert(Account(cardNum,type, balance))
    }

    fun getCount(): Int {
        return db!!.accountDao().getCount()
    }

    fun getAllQuestions(): List<Account> {
        return db!!.accountDao().getAll()
    }

    fun getAccountByCardNumber(cardNum: String): Account? {
        return db!!.accountDao().getAccountByCardNumber(cardNum)
    }

    fun deleteAll() {
        return db!!.accountDao().deleteAll()
    }
}
