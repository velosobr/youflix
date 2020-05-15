package com.cursoandroid.youflix.navigationBar.favoriteVideos.repository

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cursoandroid.youflix.R

abstract class VideoRoomDatabase : RoomDatabase() {

    abstract fun videoDao(): VideoDao

    companion object {
        private var INSTANCE: VideoRoomDatabase? = null

        fun getInstance(): VideoRoomDatabase {
            return INSTANCE ?: throw IllegalStateException("Must Initialize Room on Application")
        }

        fun init(aplicationContext: Context) {
            INSTANCE = Room.databaseBuilder(
                aplicationContext,
                VideoRoomDatabase::class.java,
                aplicationContext.getString(R.string.room_database_name)
            ).fallbackToDestructiveMigration().build()
        }
    }

}