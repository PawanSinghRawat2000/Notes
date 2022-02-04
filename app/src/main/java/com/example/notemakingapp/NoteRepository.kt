package com.example.notemakingapp

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
    class NoteRepository(private val NoteDao: NoteDao) {

        // Room executes all queries on a separate thread.
        // Observed Flow will notify the observer when the data has changed.
        val allNotes: LiveData<List<Note>> =NoteDao.getAllNotes()


        suspend fun insert(note: Note) {
            NoteDao.insert(note)
        }
        suspend fun delete(note: Note) {
            NoteDao.delete(note)
        }
    }
