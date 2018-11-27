package com.example.russ.gis_v01b;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.esri.android.map.MapView;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;

/**
 * This activity starts zoomed out from Halifax, then as the user selects
 * the floating button, it toggles from Halifax to COGS.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // The MapView object
    private MapView mMapView = null;

    // Some predetermined points
    Point p1 = new Point(-65.168, 44.885);  // COGS
    Point p2 = new Point(-63.7443, 44.6820); // Halifax

    // Current center point for map
    Point pCurrent = p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Access to map via mMapView object

        // Retrieve the map and initial extent from XML layout
        mMapView = (MapView) findViewById(R.id.map);

        // Set the Esri logo to be visible, and enable map to wrap around date line.
        mMapView.setEsriLogoVisible(true);
        mMapView.enableWrapAround(true);

        // Set listener to method in this object
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Toggle map center
        if (pCurrent == p1) {
            pCurrent = p2;
        } else {
            pCurrent = p1;
        }

        // log current location
        Log.v("onClick", "center=" + pCurrent.toString());

        //Point and zoom to new center
        Point esri102100 = (Point) GeometryEngine.project(pCurrent, SpatialReference.create(4326), SpatialReference.create(102100));
        mMapView.zoomToResolution(esri102100, 13);

    }

    protected void onPause() {
        super.onPause();
        mMapView.pause();
    }

    protected void onResume() {
        super.onResume();
        mMapView.unpause();
    }

}
