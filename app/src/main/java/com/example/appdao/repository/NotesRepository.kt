package com.example.appdao.repository

import androidx.lifecycle.LiveData
import com.example.appdao.db.NotesDAO
import com.example.appdao.db.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesRepository (private val notesDAO: NotesDAO) {
    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun insert (note: Note){
        coroutine.launch(Dispatchers.IO) {
            notesDAO.insert(note)
        }
    }

    fun update (note: Note){
        coroutine.launch(Dispatchers.IO) {
            notesDAO.update(note)
        }
    }
    fun getNotes (): LiveData<List<Note>> {
        return notesDAO.getNotes()
    }
    fun delete (id: Int){
        coroutine.launch(Dispatchers.IO) {
            notesDAO.delete(id)
        }
    }
    suspend fun findById (id: Int): Note{
       return notesDAO.getById(id)
    }
}

