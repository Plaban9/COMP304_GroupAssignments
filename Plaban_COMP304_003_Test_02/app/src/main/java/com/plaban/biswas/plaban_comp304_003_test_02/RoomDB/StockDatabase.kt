package com.plaban.biswas.plaban_comp304_003_test_02.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StockInfo::class], version = 1)
abstract public class StockDatabase : RoomDatabase()
{
    abstract fun roomCityDao(): StockDao

    // Multi - Threading / ASYNC
    companion object
    {
        @Volatile // Thread Safe
        private var INSTANCE: StockDatabase? = null // Singleton

        fun getInstance(context: Context): StockDatabase
        {
            // Prevent Race conditions
            synchronized(this)
            {
                var instance = INSTANCE

                if (instance == null)
                {
                    instance = Room.databaseBuilder(
                            context = context,
                            StockDatabase::class.java,
                            "cities_DB"
                    ).build()
                }

                INSTANCE = instance

                return instance
            }
        }
    }
}