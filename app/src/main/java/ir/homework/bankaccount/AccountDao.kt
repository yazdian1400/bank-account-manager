package ir.homework.bankaccount

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AccountDao {
    @Query("SELECT * FROM Account")
    fun getAll(): List<Account>


    @Query("SELECT COUNT(cardNumber) FROM Account")
    fun getCount(): Int

//    @Query("UPDATE Account SET userAnswer = :userAnswer WHERE number = :id")
//    fun updateUserAnswer(id: Int, userAnswer: UserAnswer)

    @Insert         //(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: Account)

    @Delete
    fun delete(account : Account)

}