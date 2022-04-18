package ir.homework.bankaccount

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations


class MainViewModel(app: Application) : AndroidViewModel(app){

    var numInShowAccount = MutableLiveData<Int>(0)

    var nextEnabledLiveData = MutableLiveData<Boolean>(true)
    var prevEnabledLiveData = MutableLiveData<Boolean>(false)

    lateinit var accountList: List<Account>
    var account: LiveData<Account> = Transformations.map(numInShowAccount) { num ->
        accountList[num]
    }

    var foundAccountLiveData = MutableLiveData<Account>(null)

    init {
        AccountRepository.initDB(app.applicationContext)
        accountList = AccountRepository.getAllQuestions()
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

    fun getAllQuestions(): List<Account> {
        return AccountRepository.getAllQuestions()
    }

    //show accounts fragment
    fun nextClicked() {
        val count = getCount()

        if (numInShowAccount.value!! < (count - 1)) {
            numInShowAccount.value = numInShowAccount.value!!.plus(1)
        }

        prevEnabledLiveData.value = numInShowAccount.value!! != 0
        nextEnabledLiveData.value = numInShowAccount.value!! != (count - 1)
    }

    fun prevClicked() {
        val count = getCount()

        if (numInShowAccount.value!! > 0) {
            numInShowAccount.value = numInShowAccount.value!!.minus(1)
        }

        prevEnabledLiveData.value = numInShowAccount.value!! != 0
        nextEnabledLiveData.value = numInShowAccount.value!! != (count - 1)
    }

    // select account fragment
    fun getAccountByCardNumber(cardNum: String): Account? {
        return AccountRepository.getAccountByCardNumber(cardNum)
    }

    fun findAccount(cardNum: String){
        foundAccountLiveData.value = getAccountByCardNumber(cardNum)
    }
}
