package com.example.appdao.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

class User {
    @Entity(tableName=  "users")

    data class User (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int? = null,

        @ColumnInfo(name = "name")
        var  name : String,

        @ColumnInfo(name = "email")
        var email : String,

        @ColumnInfo(name = "password")
        var password : String,

        @ColumnInfo(name = "update")
        var update: Date,

        )
}