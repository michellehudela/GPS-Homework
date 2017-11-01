package com.example.joela.myapplication;

        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Context;
        import android.util.Log;
        import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            Location mylocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            onLocationChanged(mylocation);
        }
        catch (SecurityException e) {



        }

    }




    @Override
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub

        //This prevents the app from crashing. Found at the same URL as below.
        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            Log.i("Geo_Location", "Latitude: " + latitude + ", Longitude: " + longitude);

            //Inspired by:
            // https://stackoverflow.com/questions/33415033/getting-current-location-in-android-studio-app
            TextView txtView;
            txtView = (TextView) findViewById(R.id.textView1);
            String display = "Latitude: " + latitude + ",\n"
                    + "Longitude: " + longitude + ".";
            txtView.setText(display);
        }



    }


    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

}