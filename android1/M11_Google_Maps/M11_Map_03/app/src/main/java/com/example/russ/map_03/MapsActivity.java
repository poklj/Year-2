package com.example.russ.map_03;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnPolygonClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,
        OnPolygonClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;

    private Polygon classRoom = null;
    private Polygon parkingLot = null;

    private final int MY_LOCATION_REQUEST_CODE = 1;

    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Log.v("MapsActivity", "onCreate");
        mapFragment.getMapAsync(this);

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API).build();
        }
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

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

//        // Don't assume permission, but don't ask if not given
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                    MY_LOCATION_REQUEST_CODE);
//            Log.v("MapsActivity", "onMapReady: Location Perm granted");
//        }

        // Don't assume permission
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_LOCATION_REQUEST_CODE);
        Log.v("MapsActivity", "onMapReady: Location Perm requested");


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


        // Add ground Overlay
        LatLng COGS_LatLng = new LatLng(44.885658, -65.168473);

//        GroundOverlayOptions COGSbuilding = new GroundOverlayOptions()
//                .image(BitmapDescriptorFactory.fromResource(R.drawable.cogs_balloon_2011))
//                .position(COGS_LatLng, 100f, 120f)      // bound size in meters
//                .transparency(0.50f);                   // 50% Transparency


        // bounds Defined by opposite corners
        LatLngBounds bounds = new LatLngBounds(
                new LatLng(44.884733921495865, -65.16910243032726),
                new LatLng(44.885317347442566, -65.16780692345492));

        GroundOverlayOptions COGSbuilding = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.cogs_balloon_2011))
                .positionFromBounds(bounds)      // bounds size in meters
                .transparency(0.50f);            // 50% Transparency
        mMap.addGroundOverlay(COGSbuilding);


        Log.v("MapsActivity", "onMapReady: Done");

    }

    @Override
    public void onPolygonClick(Polygon polygon) {
        Log.v("MapsActivity", "onPolygonClick:" + polygon.toString());

        // Do whatever based on what was clicked
        if (polygon.equals(classRoom)) {
            Log.v("MapsActivity", "onPolygonClick: classRoom!");
            int c = polygon.getFillColor();
            if (c == Color.BLUE) {
                polygon.setFillColor(Color.GREEN);
            } else {
                polygon.setFillColor(Color.BLUE);
            }
        }

        if (polygon.equals(parkingLot)) {
            Log.v("MapsActivity", "onPolygonClick: parkingLot!");
            int c = polygon.getFillColor();
            if (c == Color.BLUE) {
                polygon.setFillColor(Color.YELLOW);
            } else {
                polygon.setFillColor(Color.BLUE);
            }
        }

        // Point user's current (er...last) location on the map.
        if (mLastLocation != null) {
            // When either polygon is clicked, update the circle to current location
            Circle circle = mMap.addCircle(new CircleOptions()
                    .center(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()))
                    .radius(5)
                    .strokeColor(Color.DKGRAY)
                    .fillColor(Color.MAGENTA));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.v("MapsActivity", "onRequestPermissionsResult:"
                + " length=" + permissions.length
                + " Perm=" + permissions[0]
                + " results=" + grantResults[0]);

        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if ((permissions.length == 1) &&
                    permissions[0].equals(Manifest.permission.ACCESS_FINE_LOCATION) &&
                    (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                try {
                    mMap.setMyLocationEnabled(true);
                    Log.v("MapsActivity", "onRequestPermissionsResult: Location Enabled");
                } catch (SecurityException se) {
                    Log.v("MapsActivity", "onRequestPermissionsResult: " + se.toString());
                }
            }

        } else {
            // Permission was denied. Display an error message.
            Log.v("MapsActivity", "onRequestPermissionsResult: Location Denied");
        }
    }


    // get current location
    private Location mLastLocation = null;

    @Override
    public void onConnected(Bundle connectionHint) {

        try {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);
            Log.v("MapsActivity", "onConnected: Location retrieved");
        } catch (SecurityException se) {
            Log.v("MapsActivity", "onConnected: " + se.toString());
        }

        if (mLastLocation != null) {
            Log.v("MapsActivity", "onConnected getLatitude: " + String.valueOf(mLastLocation.getLatitude()));
            Log.v("MapsActivity", "onConnected getLongitude: " + String.valueOf(mLastLocation.getLongitude()));
        }
    }

    @Override
    public void onConnectionSuspended(int connectionSuspended) {
        Log.v("MapsActivity", "onConnectionSuspended: ");
    }


    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.v("MapsActivity", "onConnectionFailed: ");
    }

}

