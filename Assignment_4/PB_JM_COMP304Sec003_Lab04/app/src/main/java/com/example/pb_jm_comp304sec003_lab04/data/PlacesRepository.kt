package com.example.pb_jm_comp304sec003_lab04.data

import com.example.pb_jm_comp304sec003_lab04.R
import com.example.pb_jm_comp304sec003_lab04.models.PlaceData
import com.google.android.gms.maps.model.LatLng

class PlacesRepository {
    private val restaurantList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.784966465512746, -79.23028276052024), "The Local Cafe and Restaurant", R.drawable.restaurant, 4.5f, "https://images.squarespace-cdn.com/content/v1/567d5140841abaa3c9136278/1501264407970-ITCQAZT37RQ8YP3ES1FT/image-asset.jpeg"),
        PlaceData(LatLng(43.77595537594554, -79.23890360054902), "Gwalia Sweets and Restaurant - Scarborough", R.drawable.restaurant, 4.6f, "https://i.ytimg.com/vi/_IuYTw-jv4U/maxresdefault.jpg"),
        PlaceData(LatLng(43.7680856743387, -79.22897957667018), "Govardhan Thal Restaurant", R.drawable.restaurant, 3.8f, "https://b.zmtcdn.com/data/pictures/8/8900298/2fc019a7ad58a05cfcf12469bea41704.jpg"),
        PlaceData(LatLng(43.76872949341648, -79.22757909371747), "Honest Restaurant Scarborough", R.drawable.restaurant, 4.2f, "https://cdn.usarestaurants.info/assets/uploads/9cf83d0a43dd2f1543f524afd3a65e98_-united-states-new-york-queens-county-340541-honesthtm.jpg"),
        PlaceData(LatLng(43.77615190015825, -79.24169665372777), "The Avenue Restaurant and Lounge", R.drawable.restaurant, 4.4f, "https://lh3.googleusercontent.com/p/AF1QipMEdGo_OkABQnO08bSzfbNLktPMoPOJvUnMdRUh=w768-h768-n-o-k-v1"),
        PlaceData(LatLng(43.75897114455102, -79.2341102209206), "Windies Restaurant & Sports Bar", R.drawable.restaurant, 4.2f, "https://media-cdn.tripadvisor.com/media/photo-s/04/ce/3c/91/windies-restaurant-sports.jpg"),
        PlaceData(LatLng(43.79678857710564, -79.26991818353923), "Sushi Legend", R.drawable.restaurant, 4.0f, "https://cdn.usarestaurants.info/assets/uploads/2835066d2de89f05c5bf8aa2a6421d25_-canada-ontario-toronto-division-toronto-sushi-legend-scarborough-%E7%B3%B0%E9%95%B7%E5%A3%BD%E5%8F%B8-%E5%A3%AB%E5%98%89%E5%A0%A1%E5%BA%97-416-293-0118htm.jpg"),
    )

    private val cafeList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.784966465512746, -79.23028276052024), "The Local Cafe and Restaurant", R.drawable.local_cafe, 4.5f, "https://images.squarespace-cdn.com/content/v1/567d5140841abaa3c9136278/1501264407970-ITCQAZT37RQ8YP3ES1FT/image-asset.jpeg"),
        PlaceData(LatLng(43.78482718707051, -79.22730627463008), "Tim Hortons", R.drawable.local_cafe, 3.2f, "https://brandslogos.com/wp-content/uploads/images/large/tim-hortons-logo.png"),
        PlaceData(LatLng(43.77649058319438, -79.23400988589977), "Coffee Culture Cafe & Eatery", R.drawable.local_cafe, 2.9f, "https://cdn.usarestaurants.info/assets/uploads/777b7f26074c4b1f507752cb170d95e1_-canada-ontario-regional-municipality-of-peel-mississauga-coffee-culture-cafe-eatery-905-813-0330htm.jpg"),
        PlaceData(LatLng(43.77743274691391, -79.25232448070142), "Timothy's World Coffee", R.drawable.local_cafe, 4.1f, "https://ssmscdn.yp.ca/image/resize/3eff3425-e830-479b-ba62-6f620a5e9538/ypui-d-mp-pic-gal-lg/timothy-s-world-coffee-storefront-1.jpg"),
        PlaceData(LatLng(43.78415892662018, -79.2530831239116), "Starbucks", R.drawable.local_cafe, 4.0f, "https://www.boston.com/wp-content/uploads/2023/02/Earns__37281-63db07eaafd5e-scaled.jpg"),
        PlaceData(LatLng(43.788408669904925, -79.26637619709561), "Sheppard Espresso Cafe", R.drawable.local_cafe, 0.0f, "https://assets.simpleviewinc.com/simpleview/image/fetch/c_limit,h_1200,q_75,w_1200/https://assets.simpleviewinc.com/simpleview/image/upload/crm/westchesterny/1-3-_08DDCBC3-480F-444D-AAC0B4E063D8B831_93206c56-3c32-4175-8fd15e316810ac10.jpg"),
        PlaceData(LatLng(43.78620900706968, -79.27577465760504), "Unplugged Cafe & Bar - Modern Indian Cuisine", R.drawable.local_cafe, 4.8f, "https://d4t7t8y8xqo0t.cloudfront.net/resized/1080X/restaurant/674123/menu/menu01632458441956.png"),
        PlaceData(LatLng(43.77883489873246, -79.28530186412618), "Renaissance Garden Cafe", R.drawable.local_cafe, 3.8f, "https://images.getbento.com/fdCuBWmuTcKFldHm40jw_the-renaissance-cafe-logo1.png?w=1200&fit=fill&auto=compress,format&h=600&bg=EDEDF1&pad=100"),
    )

    private val hotelList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.783364702650985, -79.23566518788873), "Holiday Inn Express Toronto East - Scarborough, an IHG Hotel", R.drawable.hotel, 3.8f, "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/8e/f8/ac/hotel-exterior.jpg?w=900&h=-1&s=1"),
        PlaceData(LatLng(43.73452045353614, -79.22502668951543), "Super 8 by Wyndham Toronto East ON", R.drawable.hotel, 3.1f, "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/d1/15/d3/undefined.jpg?w=700&h=-1&s=1"),
        PlaceData(LatLng(43.671997472639475, -79.39022774886321), "Four Seasons Hotel Toronto", R.drawable.hotel, 4.7f, "https://www.oyster.com/wp-content/uploads/sites/35/2019/05/exterior-v17919128-1440-1024x683.jpg"),
        PlaceData(LatLng(43.650527846486646, -79.40263092490261), "The Alexandra Hotel", R.drawable.hotel, 3.4f, "https://th.bing.com/th/id/OIP.ybn-z6sOxrOURLhhPUZoIQHaC9?rs=1&pid=ImgDetMain"),
        PlaceData(LatLng(43.66973184960253, -79.39486640097707), "Park Hyatt Toronto", R.drawable.hotel, 4.5f, "https://storeys.com/media-library/park-hyatt-toronto-4.png?id=34032859&width=980"),
        PlaceData(LatLng(43.64354969512783, -79.42442928648761), "The Drake Hotel", R.drawable.hotel, 4.3f, "https://res.cloudinary.com/jll-global-cmg/image/upload/v1630076601/IC/Img/Resized/ordrdd0hikxqgclui9g5.jpg"),
        PlaceData(LatLng(43.85043928417801, -79.32562465270802), "Toronto Marriott Markham", R.drawable.hotel, 4.3f, "https://worldtraveller73.files.wordpress.com/2022/06/img_7941.jpeg?w=1200"),
        PlaceData(LatLng(43.859547017422145, -79.0094211278284), "Homewood Suites by Hilton", R.drawable.hotel, 4.2f, "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/ef/1f/2c/homewood-suites-by-hilton.jpg?w=1400&h=-1&s=1"),
    )

    private val groceryList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.79308915525651, -79.24027464982998), "Food Basics", R.drawable.local_grocery_store, 4.0f, "https://cdn.canada247.info/assets/uploads/b8253e1cab973b3c3705b1f09a9215b5_-ontario-hamilton-division-hamilton-berrisfield-food-basicshtml.jpg"),
        PlaceData(LatLng(43.77779493688872, -79.25880895630233), "Walmart Supercentre", R.drawable.local_grocery_store, 3.7f, "https://imageio.forbes.com/specials-images/imageserve/63e19d0c2b2fa6989a4c9761/0x0.jpg?format=jpg&crop=3175,1447,x0,y21,safe&height=900&width=1600&fit=bounds"),
        PlaceData(LatLng(43.772651023285526, -79.28039537478922), "Foody World", R.drawable.local_grocery_store, 4.1f, "https://s3-media3.fl.yelpcdn.com/bphoto/rjjBQrZOudDjLbSe33XcBw/o.jpg"),
        PlaceData(LatLng(43.73712735643425, -79.25129877127938), "Scarbough Market", R.drawable.local_grocery_store, 1.4f, "https://images.squarespace-cdn.com/content/v1/61a0518f302ea8684a6dd1ae/e0275bbd-daf7-4e41-ac18-a5a1f0880d97/SSM_Winter_Full_RGB.png?format=1500w"),
        PlaceData(LatLng(43.74339827877089, -79.21651589577027), "Metro", R.drawable.local_grocery_store, 4.3f, "https://www.narcity.com/media-library/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpbWFnZSI6Imh0dHBzOi8vYXNzZXRzLnJibC5tcy8yNTkzNDY5OS9vcmlnaW4uanBnIiwiZXhwaXJlc19hdCI6MTY0NDA1NzUzOX0.ItN0IsmEhP09KUUhelLGyYpjzoqohsRAkx9uk_aQpU4/image.jpg?width=1245&quality=85&coordinates=0%2C306%2C0%2C306&height=700"),
        PlaceData(LatLng(43.77454598572515, -79.25135192595538), "FreshCo McCowan & Ellesmere", R.drawable.local_grocery_store, 4.1f, "https://s3-media1.fl.yelpcdn.com/bphoto/onygEmRxLSKbU0hUAz1unw/o.jpg"),
        PlaceData(LatLng(43.796847058077596, -79.27112779874994), "Bestco Fresh Foods Scarborough Store", R.drawable.local_grocery_store, 4.1f, "https://th.bing.com/th/id/OIP.hjO8A7_iTJnIWLRCK0ypqwHaHa?rs=1&pid=ImgDetMain"),
        PlaceData(LatLng(43.81565513266629, -79.29488102603769), "ASIA FOODMART", R.drawable.local_grocery_store, 4.0f, "https://th.bing.com/th/id/R.b150510e33a66bd59e47f7a36720c6fc?rik=ItnH21zJv0Tb9Q&riu=http%3a%2f%2fwww.maangchi.com%2fwp-content%2fuploads%2f2010%2f04%2fstorefront.jpg&ehk=BIkPaC6QvMcPThpnX3vctFPjGG5ltQm%2fa%2fEM75xJgWA%3d&risl=&pid=ImgRaw&r=0"),
    )

    private val gasStationList = mutableListOf<PlaceData>(
        PlaceData(LatLng(43.7776739556713, -79.231464556116), "Shell", R.drawable.local_gas_station, 3.4f, "https://northalsted.com/wp-content/uploads/2023/04/Circle-K-Business-Photo.jpg"),
        PlaceData(LatLng(43.768253421029655, -79.22828882060138), "Pioneer - Gas Station", R.drawable.local_gas_station, 4.2f, "https://cdn.canada247.info/assets/uploads/539f23915375704bdc2d4fe9bf496821_-ontario-regional-municipality-of-niagara-welland-pioneer-gas-station-905-735-4935html.jpg"),
        PlaceData(LatLng(43.772406076311405, -79.2518922601135), "Esso", R.drawable.local_gas_station, 4.0f, "https://static.bangkokpost.com/media/content/dcx/2023/09/20/4897427.jpg"),
        PlaceData(LatLng(43.76018255698963, -79.27801698421415), "Kennedy Gas Bar", R.drawable.local_gas_station, 4.0f, "https://s3-media0.fl.yelpcdn.com/bphoto/-0_-2T8Xk1HFdV4_c9aSrQ/o.jpg"),
        PlaceData(LatLng(43.73666216679621, -79.25222876165103), "Ultramar - Gas Station", R.drawable.local_gas_station, 4.1f, "https://thumbs.dreamstime.com/b/ultramar-gas-station-montreal-cst-canada-co-headquartered-includes-cardlock-home-heating-motorist-sales-sectors-78901955.jpg"),
        PlaceData(LatLng(43.78563462626393, -79.19518049182292), "Petro-Canada & Car Wash", R.drawable.local_gas_station, 3.7f, "https://www.petro-canada.ca/-/media/project/petrocanada/shared/navigation-cards/our-story.jpg?la=en&mw=1144&modified=20181116231339&hash=2C74F5C910D2D08EECB9E7AF39A68E72BE779107"),
        PlaceData(LatLng(43.732851319948175, -79.28865897699582), "Mobil Gas Station and Convenience", R.drawable.local_gas_station, 4.6f, "https://www.mobilfuel.ca/-/media/project/wep/mobil/mobil-ca/homepage/en-ca/homebanner/bdca_3631_essohomepage_mobilstation_1200x630.jpg"),
        PlaceData(LatLng(43.796235151919134, -79.23007285316386 ), "MiFuel", R.drawable.local_gas_station, 4.1f, "https://th.bing.com/th/id/OIP.G8VAKxnFH1-JQRy6bzFciwHaCv?rs=1&pid=ImgDetMain"),
    )

    fun getRestaurants() : List<PlaceData> { return restaurantList }
    fun getCafes() : List<PlaceData> { return cafeList }
    fun getHotels() : List<PlaceData> { return hotelList }
    fun getGroceries() : List<PlaceData> { return groceryList }
    fun getGasStations() : List<PlaceData> { return gasStationList }
}