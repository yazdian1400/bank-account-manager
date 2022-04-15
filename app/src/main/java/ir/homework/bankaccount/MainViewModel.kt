package ir.homework.bankaccount

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class MainViewModel(app: Application) : AndroidViewModel(app){

    init {
        AccountRepository.initDB(app.applicationContext)
    }

    fun nextInCreate(numAccounts:Int, cardNum: String, balance: Int, type: AccountType): Boolean {
        addAccountToDB(cardNum, balance, type)
        return getCount() == numAccounts
    }

    private fun addAccountToDB(cardNum: String, balance: Int, type: AccountType) {
        AccountRepository.addAccountToDB(cardNum, balance, type)
    }

    fun getCount(): Int {
        return AccountRepository.getCount()
    }

}
