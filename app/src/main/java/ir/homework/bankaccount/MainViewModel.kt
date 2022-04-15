package ir.homework.bankaccount

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class MainViewModel(app: Application) : AndroidViewModel(app){

    init {
        AccountRepository.initDB(app.applicationContext)
    }

    fun nextInCreate(numAccounts:Int, cardNum: String, balance: Int): Boolean {
        addAccountToDB(cardNum, balance)
        return getCount() == numAccounts
    }

    private fun addAccountToDB(cardNum: String, balance: Int) {
        AccountRepository.addAccountToDB(cardNum, balance)
    }

    fun getCount(): Int {
        return AccountRepository.getCount()
    }

}
