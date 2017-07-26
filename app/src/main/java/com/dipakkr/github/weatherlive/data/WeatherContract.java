package com.dipakkr.github.weatherlive.data;

import android.provider.BaseColumns;

/**
 * Created by root on 7/26/17.
 */

public class WeatherContract {

    public static final class LocationEntry implements BaseColumns{
        public static final String TABLE_NAME = "location";

        public static final String COLUMN_LOCATION_SETTING = "setting";

        public static final String COLUMN_CITY_NAME = "city";

        public static final String COLUMN_COORD_LAT = "lat";

        public static final String COLUMN_COORD_LONG = "long";


    }

    public static final class WeatherEntry implements BaseColumns{

        public static final String TABLE_NAME = "weather";

        public static final String COLUMN_LOC_KEY = "location_id";

        public static final String COLUMN_DATE = "date";

        public static final String COLUMN_WEATHER_ID = "weather_id";

        public static final String COLUMN_SHORT_DESC = "short_desc";

        public static final String COLUMN_MIN_TEMP = "min";

        public static final String COLUMN_MAX_TEMP = "max";

        public static final String COLUMN_HUMIDITY = "humidity";

        public static final String COLUMN_PRESSURE = "pressure";

        public static final String COLUMN_WIND_SPEED = "wind";

        public static final String COLUMN_DEGREES = "degrees";

    }

}
