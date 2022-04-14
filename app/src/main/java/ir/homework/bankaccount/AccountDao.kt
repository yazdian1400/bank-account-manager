package ir.homework.bankaccount

import androidx.room.*

@Dao
interface AccountDao {
    @Query("SELECT * FROM Account")
    fun getAll(): List<Account>

//    @Query("UPDATE Account SET userAnswer = :userAnswer WHERE number = :id")
//    fun updateUserAnswer(id: Int, userAnswer: UserAnswer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg accounts: Account)

    @Delete
    fun delete(account : Account)

}