package ir.homework.bankaccount

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    @PrimaryKey val id: Int,    //(autoGenerate = true)
    val type: AccountType,
    val cardNumber: String,
    val balance: Int
)