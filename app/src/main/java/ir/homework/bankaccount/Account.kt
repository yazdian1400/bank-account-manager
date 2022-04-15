package ir.homework.bankaccount

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    //@PrimaryKey val id: Int,    //(autoGenerate = true)
    @PrimaryKey val cardNumber: String,
    val type: AccountType,
    val balance: Int
)