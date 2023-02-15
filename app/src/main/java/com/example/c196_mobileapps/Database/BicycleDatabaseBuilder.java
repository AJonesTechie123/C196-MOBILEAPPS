package com.example.c196_mobileapps.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.c196_mobileapps.DAO.PartDAO;
import com.example.c196_mobileapps.DAO.ProductDAO;
import com.example.c196_mobileapps.Entities.Part;
import com.example.c196_mobileapps.Entities.Product;

@Database(entities = {Product.class, Part.class}, version = 1, exportSchema = false)
public abstract class BicycleDatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();

    public abstract PartDAO partDAO();

    private static volatile BicycleDatabaseBuilder INSTANCE;

    static BicycleDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BicycleDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BicycleDatabaseBuilder.class, "MyBicycleDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
            return INSTANCE;
        }
        return null;
    }
}

