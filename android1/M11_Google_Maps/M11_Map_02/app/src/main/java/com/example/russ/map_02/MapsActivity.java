package com.example.russ.map_02;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnPolygonClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnPolygonClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Log.v("MapsActivity", "onCreate");
        mapFragment.getMapAsync(this);
    }


    Polygon classRoom = null;
    Polygon parkingLot = null;

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng cogs = new LatLng(44.885, -65.168);
        mMap.addMarker(new MarkerOptions().position(cogs).title("Marker at COGS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cogs));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));

        // Sets the map type to be "hybrid"
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Big classroom
        classRoom = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(44.885122, -65.168781),
                        new LatLng(44.885061, -65.168346),
                        new LatLng(44.884932, -65.168454),
                        new LatLng(44.884975, -65.168907))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));
        classRoom.setClickable(true);

        // Back parking
        parkingLot = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(44.885434, -65.169113),
                        new LatLng(44.885856, -65.169357),
                        new LatLng(44.885997, -65.168761),
                        new LatLng(44.885658, -65.168473))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));
        parkingLot.setClickable(true);

        // Set Listener
        mMap.setOnPolygonClickListener(this);

        // Instantiates a new CircleOptions object and defines the center and radius
        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(44.885658, -65.168473))
                .radius(5); // In meters

        // Get back the mutable Circle
        Circle circle = mMap.addCircle(circleOptions);

        Log.v("MapsActivity", "onMapReady:" + cogs.toString());

    }

    @Override
    public void onPolygonClick(Polygon polygon) {
        Log.v("MapsActivity", "onPolygonClick:" + polygon.toString());

        // Do whatever based on what was clicked
        if (polygon.equals(classRoom)) {
            Log.v("MapsActivity", "onPolygonClick: classRoom!");
        }

        if (polygon.equals(parkingLot)) {
            Log.v("MapsActivity", "onPolygonClick: parkingLot!");
        }

    }
}

















