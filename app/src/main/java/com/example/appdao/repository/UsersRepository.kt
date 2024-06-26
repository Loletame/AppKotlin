package com.example.appdao.repository

import androidx.lifecycle.LiveData
import com.example.appdao.db.UsersDAO
import com.example.appdao.db.model.Note
import com.example.appdao.db.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersRepository (private val usersDAO: UsersDAO) {
    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun insert (user: User){
        coroutine.launch(Dispatchers.IO) {
            usersDAO.insert(user)
        }
    }

    fun update (user: User){
        coroutine.launch(Dispatchers.IO) {
            usersDAO.update(user)
        }
    }
    fun getUsers (): LiveData<List<User>> {
        return usersDAO.getUsers()
    }
    fun delete (id: Int){
        coroutine.launch(Dispatchers.IO) {
            usersDAO.delete(id)
        }
    }
    suspend fun findById (id: Int): User{
       return usersDAO.getById(id)
    }
}

