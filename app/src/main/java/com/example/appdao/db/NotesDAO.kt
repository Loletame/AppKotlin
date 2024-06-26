package com.example.appdao.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appdao.db.model.Note

@Dao
interface NotesDAO {

    @Insert
    fun insert(note: Note)

    @Update
    fun update (note: Note)

    @Query("DELETE FROM notes WHERE id= id")
    fun delete(id: Int)

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Note>> //LiveData es un observable,meaning esta escuchando osea digamos listening

    @Query("SELECT * FROM notes WHERE id = id")
    fun getById(id: Int): Note
}