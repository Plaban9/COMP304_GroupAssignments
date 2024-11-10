package com.example.pb_jm_comp304sec003_lab03.models

/*

Response JSON

{
"location": {
    "name": "Toronto",
    "region": "Ontario",
    "country": "Canada",
    "lat": 43.6667,
    "lon": -79.4167,
    "tz_id": "America/Toronto",
    "localtime_epoch": 1731279352,
    "localtime": "2024-11-10 17:55"
},
"current": {
    "last_updated_epoch": 1731278700,
    "last_updated": "2024-11-10 17:45",
    "temp_c": 10.2,
    "temp_f": 50.4,
    "is_day": 0,
    "condition": {
        "text": "Light rain",
        "icon": "//cdn.weatherapi.com/weather/64x64/night/296.png",
        "code": 1183
    },
    "wind_mph": 10.1,
    "wind_kph": 16.2,
    "wind_degree": 122,
    "wind_dir": "ESE",
    "pressure_mb": 1008.0,
    "pressure_in": 29.75,
    "precip_mm": 5.21,
    "precip_in": 0.21,
    "humidity": 100,
    "cloud": 100,
    "feelslike_c": 8.0,
    "feelslike_f": 46.4,
    "windchill_c": 7.3,
    "windchill_f": 45.1,
    "heatindex_c": 9.6,
    "heatindex_f": 49.2,
    "dewpoint_c": 9.1,
    "dewpoint_f": 48.3,
    "vis_km": 2.8,
    "vis_miles": 1.0,
    "uv": 0.0,
    "gust_mph": 14.4,
    "gust_kph": 23.1
}
}
 */

data class WeatherData(
    val location: LocationData,
    val current: Current,
)

data class LocationData(
    val name: String,
    val region: String,
    val country: String
)

data class Current(
    val temp_c: Double,
)
