package org.tensorflow.lite.examples.classification;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Marker currentUserLocationMarker;
    private static final int Request_User_Location_Code=99;
    private double latitude,longitude;
    private int ProximityRadius=10000;

    ArrayList<LatLng>arrayList=new ArrayList<LatLng>();

    LatLng katraj = new LatLng(18.4509815, 73.8771897);
    LatLng sukhsagarnagar = new LatLng(18.493003, 73.827800);
    LatLng a  = new LatLng(18.450741, 73.857592);
    LatLng b = new LatLng(18.461716, 73.865601);
    LatLng c = new LatLng(18.474254, 73.854010);
    LatLng d = new LatLng(18.503094, 73.874821);
    LatLng e = new LatLng(18.476981, 73.894478);
    LatLng f = new LatLng(18.516554, 73.877093);
    LatLng h = new LatLng(18.4564385,73.884598);
    LatLng z = new LatLng(18.460404, 73.823813);

    //
    //ArrayList namesArrayList=new NamesArrayList();
    //ArrayList<String>namesArrayList=new ArrayList<>();



    //   namesArrayList.add("sd");
    //String List1[]={"a","2","c","4","3","f"};
//List<Integer>names=new ArrayList<>();
//Resources res=getResources();
//String[] names=res.getStringArray(R.array.names);
    String s1[]={"Swapnil","Arjun","Aditya","Gaurav",
            "Hrushikesh","Amogh","Saurabh","Vilin","Vinay","Mayur"};
    String s2[]={"9921498922","02025441211","08087020340","9850352519","9762125115"
            ,"8745963210","8007786205","7845129856","9860016110","9975245933"};






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            checkUserLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        arrayList.add(katraj);
        arrayList.add(sukhsagarnagar);
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        arrayList.add(d);
        arrayList.add(e);
        arrayList.add(f);
        arrayList.add(h);
        arrayList.add(z);
    }

    public  void  onClick(View v)
    {

        String snake_rescuer = "snake rescuer";
        Object transferData[]=new Object[2];
        animalcare getsnake_rescuer=new animalcare();


        switch(v.getId())
        {
            case R.id.search_address:
                EditText addressField=(EditText)findViewById(R.id.location_search);
                String address=addressField.getText().toString();
                List<Address> addressList=null;
                MarkerOptions userMarkerOptions=new MarkerOptions();
                if(!TextUtils.isEmpty(address))
                {
                    Geocoder geocoder=new Geocoder(this);
                    try
                    {
                        addressList=geocoder.getFromLocationName(address,6);
                        if(addressList!=null)
                        {
                            for(int i=0;i<addressList.size();i++)
                            {
                                Address userAddress=addressList.get(i);
                                LatLng latLng=new LatLng(userAddress.getLatitude(),userAddress.getLongitude());

                                userMarkerOptions.position(latLng);
                                userMarkerOptions.title(address);
                                userMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                                mMap.addMarker(userMarkerOptions);
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                            }
                        }
                        else
                        {
                            Toast.makeText(this, "Location not found...", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                }
                else
                {
                    Toast.makeText(this, "Enter any location name...", Toast.LENGTH_SHORT).show();
                }
                break;

            case  R.id.snakeinfo:
                mMap.clear();
                String url=getUrl(latitude,longitude,snake_rescuer);
                transferData[0]=mMap;
                transferData[1]=url;

                animalcare.execute(transferData);
                Toast.makeText(this, "Searching for Nearby hospitals...", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Showing Nearby hospitals..", Toast.LENGTH_SHORT).show();
                break;


        }
    }

    private String getUrl(double latitude,double longitude,String myapplication)

    {
        StringBuilder googleURL = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googleURL.append("location=" + latitude + "," + longitude);
        googleURL.append("&radius=" + ProximityRadius);
        googleURL.append("&type=" + "nearbyPlace");
        googleURL.append("&sensor=true");
        googleURL.append("&key=" + "AIzaSyDjtQEttcEsQpJMlLUqmKMQSjtCOvShX_I");

        Log.d("GoogleMapsActivity","url="+ googleURL.toString());
        return googleURL.toString();

    }

    @RequiresApi(api=Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
        {
            buildGoogleApiClient();

            mMap.setMyLocationEnabled(true);


        }
        for(int i=0;i<9;i++){
            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(s1[i]).snippet(s2[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.snake_rescue1)));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));




        }

    }

    public boolean  checkUserLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {


            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION))
            {

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_User_Location_Code);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_User_Location_Code);
            }
            return  false;
        }
        else
        {
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case Request_User_Location_Code:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (googleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "Permission Denied...", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    protected synchronized void buildGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        googleApiClient.connect();
    }


    @Override
    public void onLocationChanged(Location location)
    {

        latitude=location.getLatitude();
        longitude=location.getLongitude();
        if(currentUserLocationMarker!=null)
        {
            currentUserLocationMarker.remove();
        }

        LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());

        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("current location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        currentUserLocationMarker=mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(14));

        if(googleApiClient!=null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient,this);
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1100);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }



    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private static class animalcare {
        public static void execute(Object[] transferData) {
        }
    }
}