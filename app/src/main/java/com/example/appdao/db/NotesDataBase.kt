package com.example.appdao.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appdao.db.model.Note



@Database(entities = [(Note::class)],
version =1,
exportSchema = false)


@TypeConverters(Converters::class)

abstract class NotesDataBase: RoomDatabase() {
    abstract fun notesDao(): NotesDAO

    companion object {
        @Volatile
        private var INSTANCE: NotesDataBase? = null

        /* //tira los datos a la basura*** para instancia unica */
        fun getInstance(context: Context): NotesDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDataBase::class.java,
                        "notes_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }


    }
}