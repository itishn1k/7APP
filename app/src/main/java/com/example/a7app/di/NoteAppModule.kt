package com.example.a7app.di

import android.content.Context
import androidx.room.Room
import com.example.a7app.data.local.NoteDao
import com.example.a7app.data.local.NoteDataBase
import com.example.a7app.data.repositoty.NoteRepositoryImpl
import com.example.a7app.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteAppModule {

    @Singleton
    @Provides
    fun provideNoteDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NoteDataBase::class.java, "note_db").allowMainThreadQueries().build()

    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) = noteDataBase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)
}