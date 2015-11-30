package com.example.henrik.handimap;

import android.content.Intent;
import android.media.Rating;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HandiMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<ReviewedBuilding> reviwedBuildings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handi_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),NewReviewActivity.class);
                startActivity(intent);
            }
        });


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
    static final LatLng ikdc = new LatLng(55.71499564, 13.21251869);
    static final LatLng nr1 = new LatLng(55.71149016, 13.2094717);
    static final LatLng nr2 = new LatLng(55.71106706, 13.21039438);
    static final LatLng nr3 = new LatLng(55.71214293, 13.21153164);
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter()  {
            // Use default InfoWindow frame
            @Override
            public View getInfoWindow(Marker Marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.rating_info_card,null);
                if (marker.getPosition().equals(ikdc)){
                    TextView byggnadsNamn = (TextView)v.findViewById(R.id.byggnadsnamn);
                    byggnadsNamn.setText("IKDC");

                    TextView address = (TextView)v.findViewById(R.id.address);
                    address.setText("Sölvegatan 26, 223 62 Lund");
                    RatingBar r = (RatingBar)v.findViewById(R.id.stars);
                    r.setRating(5);
                }
                else if(marker.getPosition().equals(nr1)){
                    TextView byggnadsNamn = (TextView)v.findViewById(R.id.byggnadsnamn);
                    byggnadsNamn.setText("Byggnad 1");
                    TextView address = (TextView)v.findViewById(R.id.address);
                    address.setText("Sölvegatan 18, 223 62 Lund");
                    RatingBar r = (RatingBar)v.findViewById(R.id.stars);
                    r.setRating(2);

                }
                else if(marker.getPosition().equals(nr2)){
                    TextView byggnadsNamn = (TextView)v.findViewById(R.id.byggnadsnamn);
                    byggnadsNamn.setText("Byggnad 2");
                    TextView address = (TextView)v.findViewById(R.id.address);
                    address.setText("Sölvegatan 8, 223 62 Lund");
                    RatingBar r = (RatingBar)v.findViewById(R.id.stars);
                    r.setRating(2);

                }
                else if(marker.getPosition().equals(nr3)){
                    TextView byggnadsNamn = (TextView)v.findViewById(R.id.byggnadsnamn);
                    byggnadsNamn.setText("Byggnad 3");
                    TextView address = (TextView)v.findViewById(R.id.address);
                    address.setText("Sölvegatan 2, 223 62 Lund");
                    RatingBar r = (RatingBar)v.findViewById(R.id.stars);
                    r.setRating(3);

                }
                return v;
            }


        });
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().position(nr1));
        mMap.addMarker(new MarkerOptions().position(nr2));
        mMap.addMarker(new MarkerOptions().position(nr3));
        mMap.addMarker(new MarkerOptions().position(ikdc).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                startActivity(new Intent(getBaseContext(),ReviewList.class));
            }
        });
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(55.71214293, 13.21153164)));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15f));

    }
    public void showStep2(View v){
        v.setVisibility(View.GONE);
        findViewById(R.id.frame2).setVisibility(View.VISIBLE);
    }
    public void showStep3(View v){
        v.setVisibility(View.GONE);
        findViewById(R.id.frame3).setVisibility(View.VISIBLE);
    }
    public void finalStep(View v){
        v.setVisibility(View.GONE);
    }
}
