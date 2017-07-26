package com.dipakkr.github.weatherlive.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deepak on 7/26/17.
 */

public class WeatherDbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2 ;
    public static String DATABASE_NAME = "weather.db";

    public WeatherDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_WEATHER_TABLE = "CREATE TABLE" + WeatherContract.WeatherEntry.TABLE_NAME + "(" +
                WeatherContract.WeatherEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT ," +

                WeatherContract.WeatherEntry.COLUMN_LOC_KEY + "INTEGER NOT NULL," +
                WeatherContract.WeatherEntry.COLUMN_DATE + "INTEGER NOT NULL," +
                WeatherContract.WeatherEntry.COLUMN_SHORT_DESC + "TEXT NOT NULL," +
                WeatherContract.WeatherEntry.COLUMN_WEATHER_ID + " INTEGER NOT NULL," +

                WeatherContract.WeatherEntry.COLUMN_MIN_TEMP + "REAL NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_MAX_TEMP + "REAL NOT NULL, " +

                WeatherContract.WeatherEntry.COLUMN_HUMIDITY + "REAL NOT NULL," +
                WeatherContract.WeatherEntry.COLUMN_PRESSURE + "REAL NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_WIND_SPEED + "REAL NOT NULL," +
                WeatherContract.WeatherEntry.COLUMN_DEGREES + "REAL NOT NULL," +

        // Set up the location column as a foreign key to location table.

                " FOREIGN KEY (" + WeatherContract.WeatherEntry.COLUMN_LOC_KEY + ") REFERENCES " +

                WeatherContract.LocationEntry.TABLE_NAME + " (" + WeatherContract.LocationEntry._ID + "), " +

                // To assure the application have just one weather entry per day
                // per location, it's created a UNIQUE constraint with REPLACE strategy
                " UNIQUE (" + WeatherContract.WeatherEntry.COLUMN_DATE + ", " +
                WeatherContract.WeatherEntry.COLUMN_LOC_KEY + ") ON CONFLICT REPLACE);";


        final String CREATE_LOCATION_TABLE = "CREATE TABLE" + WeatherContract.LocationEntry.TABLE_NAME + "(" +
                WeatherContract.LocationEntry._ID + "INTEGER PRIMARY KEY," +
                WeatherContract.LocationEntry.COLUMN_LOCATION_SETTING + "TEXT UNIQUE NOT NULL," +
                WeatherContract.LocationEntry.COLUMN_CITY_NAME + "TEXT NOT NULL" +
                WeatherContract.LocationEntry.COLUMN_COORD_LAT + "REAL NOT NULL" +
                WeatherContract.LocationEntry.COLUMN_COORD_LONG + "REAL NOT NULL" +

                ");" ;


        db.execSQL(CREATE_LOCATION_TABLE);
        db.execSQL(CREATE_WEATHER_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + WeatherContract.LocationEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS" + WeatherContract.WeatherEntry.TABLE_NAME);
        onCreate(db);
    }
}
