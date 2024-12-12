package com.plaban.biswas.pb_comp_304_mocktest.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CompanyStock::class], version = 1)
abstract public class CompanyDatabase : RoomDatabase()
{
    abstract fun roomCityDao(): CompanyDAO

    // Multi - Threading / ASYNC
    companion object
    {
        @Volatile // Thread Safe
        private var INSTANCE: CompanyDatabase? = null // Singleton

        fun getInstance(context: Context): CompanyDatabase
        {
            // Prevent Race conditions
            synchronized(this)
            {
                var instance = INSTANCE

                if (instance == null)
                {
                    instance = Room.databaseBuilder(
                            context = context,
                            CompanyDatabase::class.java,
                            "cities_DB"
                    ).build()
                }

                INSTANCE = instance

                return instance
            }
        }
    }
}

