package com.example.pb_jm_comp304sec003_lab04.data

import com.example.pb_jm_comp304sec003_lab04.R
import com.example.pb_jm_comp304sec003_lab04.models.PlaceData
import com.google.android.gms.maps.model.LatLng

class PlacesRepository {
    private val restaurantList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.784966465512746, -79.23028276052024), "The Local Cafe and Restaurant", R.drawable.restaurant, 4.5f),
        PlaceData(LatLng(43.77595537594554, -79.23890360054902), "Gwalia Sweets and Restaurant - Scarborough", R.drawable.restaurant, 4.6f),
        PlaceData(LatLng(43.7680856743387, -79.22897957667018), "Govardhan Thal Restaurant", R.drawable.restaurant, 3.8f),
        PlaceData(LatLng(43.76872949341648, -79.22757909371747), "Honest Restaurant Scarborough", R.drawable.restaurant, 4.2f),
        PlaceData(LatLng(43.77595537594554, -79.23890360054902), "Gwalia Sweets and Restaurant - Scarborough", R.drawable.restaurant, 4.6f),
        PlaceData(LatLng(43.77615190015825, -79.24169665372777), "The Avenue Restaurant and Lounge", R.drawable.restaurant, 4.4f),
        PlaceData(LatLng(43.75897114455102, -79.2341102209206), "Windies Restaurant & Sports Bar", R.drawable.restaurant, 4.2f),
        PlaceData(LatLng(43.79678857710564, -79.26991818353923), "Sushi Legend", R.drawable.restaurant, 4.0f),
    )

    private val cafeList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.784966465512746, -79.23028276052024), "The Local Cafe and Restaurant", R.drawable.local_cafe, 4.5f),
        PlaceData(LatLng(43.78482718707051, -79.22730627463008), "Tim Hortons", R.drawable.local_cafe, 3.2f),
        PlaceData(LatLng(43.77649058319438, -79.23400988589977), "Coffee Culture Cafe & Eatery", R.drawable.local_cafe, 2.9f),
        PlaceData(LatLng(43.77743274691391, -79.25232448070142), "Timothy's World Coffee", R.drawable.local_cafe, 4.1f),
        PlaceData(LatLng(43.78415892662018, -79.2530831239116), "Starbucks", R.drawable.local_cafe, 4.0f),
        PlaceData(LatLng(43.788408669904925, -79.26637619709561), "Sheppard Espresso Cafe", R.drawable.local_cafe, 0.0f),
        PlaceData(LatLng(43.78620900706968, -79.27577465760504), "Unplugged Cafe & Bar - Modern Indian Cuisine", R.drawable.local_cafe, 4.8f),
        PlaceData(LatLng(43.77883489873246, -79.28530186412618), "Renaissance Garden Cafe", R.drawable.local_cafe, 3.8f),
    )

    private val hotelList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.783364702650985, -79.23566518788873), "Holiday Inn Express Toronto East - Scarborough, an IHG Hotel", R.drawable.hotel, 3.8f),
        PlaceData(LatLng(43.73452045353614, -79.22502668951543), "Super 8 by Wyndham Toronto East ON", R.drawable.hotel, 3.1f),
        PlaceData(LatLng(43.671997472639475, -79.39022774886321), "Four Seasons Hotel Toronto", R.drawable.hotel, 4.7f),
        PlaceData(LatLng(43.650527846486646, -79.40263092490261), "The Alexandra Hotel", R.drawable.hotel, 3.4f),
        PlaceData(LatLng(43.66973184960253, -79.39486640097707), "Park Hyatt Toronto", R.drawable.hotel, 4.5f),
        PlaceData(LatLng(43.64354969512783, -79.42442928648761), "The Drake Hotel", R.drawable.hotel, 4.3f),
        PlaceData(LatLng(43.85043928417801, -79.32562465270802), "Toronto Marriott Markham", R.drawable.hotel, 4.3f),
        PlaceData(LatLng(43.859547017422145, -79.0094211278284), "Homewood Suites by Hilton Ajax, Ontario, Canada", R.drawable.hotel, 4.2f),
    )

    private val groceryList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.79308915525651, -79.24027464982998), "Food Basics", R.drawable.local_grocery_store, 4.0f),
        PlaceData(LatLng(43.77779493688872, -79.25880895630233), "Walmart Supercentre", R.drawable.local_grocery_store, 3.7f),
        PlaceData(LatLng(43.772651023285526, -79.28039537478922), "Foody World", R.drawable.local_grocery_store, 4.1f),
        PlaceData(LatLng(43.73712735643425, -79.25129877127938), "Scarbough Market", R.drawable.local_grocery_store, 1.4f),
        PlaceData(LatLng(43.74339827877089, -79.21651589577027), "Metro", R.drawable.local_grocery_store, 4.3f),
        PlaceData(LatLng(43.77454598572515, -79.25135192595538), "FreshCo McCowan & Ellesmere", R.drawable.local_grocery_store, 4.1f),
        PlaceData(LatLng(43.796847058077596, -79.27112779874994), "Bestco Fresh Foods Scarborough Store", R.drawable.local_grocery_store, 4.1f),
        PlaceData(LatLng(43.81565513266629, -79.29488102603769), "ASIA FOODMART", R.drawable.local_grocery_store, 4.0f),
    )

    private val gasStationList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.7776739556713, -79.231464556116), "Shell", R.drawable.local_gas_station, 3.4f),
        PlaceData(LatLng(43.768253421029655, -79.22828882060138), "Pioneer - Gas Station", R.drawable.local_gas_station, 4.2f),
        PlaceData(LatLng(43.772406076311405, -79.2518922601135), "Esso", R.drawable.local_gas_station, 4.0f),
        PlaceData(LatLng(43.76018255698963, -79.27801698421415), "Kennedy Gas Bar", R.drawable.local_gas_station, 4.0f),
        PlaceData(LatLng(43.73666216679621, -79.25222876165103), "Ultramar - Gas Station", R.drawable.local_gas_station, 4.1f),
        PlaceData(LatLng(43.78563462626393, -79.19518049182292), "Petro-Canada & Car Wash", R.drawable.local_gas_station, 3.7f),
        PlaceData(LatLng(43.732851319948175, -79.28865897699582), "Mobil Gas Station and Convenience", R.drawable.local_gas_station, 4.6f),
        PlaceData(LatLng(43.796235151919134, -79.23007285316386 ), "MiFuel", R.drawable.local_gas_station, 4.1f),
    )

    fun getRestaurants() : List<PlaceData> { return restaurantList }
    fun getCafes() : List<PlaceData> { return cafeList }
    fun getHotels() : List<PlaceData> { return hotelList }
    fun getGroceries() : List<PlaceData> { return groceryList }
    fun getGasStations() : List<PlaceData> { return gasStationList }
}