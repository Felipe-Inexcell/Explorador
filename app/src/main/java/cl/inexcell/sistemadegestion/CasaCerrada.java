package cl.inexcell.sistemadegestion;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import cl.inexcell.sistemadegestion.daemon.MyLocationListener;


public class CasaCerrada extends FragmentActivity implements GoogleMap.OnMapLoadedCallback, GoogleMap.OnMyLocationChangeListener, View.OnClickListener {
    private GoogleMap mapa;
    private final String TAG = "Plantas_Externas";
    Context mContext;
    LinearLayout mapStatus;
    TextView mapStatusText;

    Button tomarFoto, verFoto, enviar;

    boolean gpsOk = false;

    private Bitmap b = null;
    private static int TAKE_PICTURE = 1;
    private String name = Environment.getExternalStorageDirectory() + "/casacerrada.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_casa_cerrada);
        mContext = this;

        tomarFoto = (Button)findViewById(R.id.tomarfoto);
        verFoto = (Button)findViewById(R.id.verfoto);
        enviar = (Button)findViewById(R.id.enviar);
        tomarFoto.setOnClickListener(this);
        verFoto.setOnClickListener(this);
        enviar.setOnClickListener(this);
        verFoto.setEnabled(false);
        mapStatus = (LinearLayout) findViewById(R.id.mapStatus);

        mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment)).getMap();
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapa.setMyLocationEnabled(true);
        mapa.getUiSettings().setMyLocationButtonEnabled(true);
        mapa.getUiSettings().setCompassEnabled(true);
        mapa.getUiSettings().setZoomControlsEnabled(true);

        mapa.setOnMapLoadedCallback(this);

    }


    @Override
    public void onMyLocationChange(Location location) {
        if (location != null && !gpsOk) {
            mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mapa.getMyLocation().getLatitude(), mapa.getMyLocation().getLongitude()), 15));
            mapStatus.setVisibility(View.GONE);
            gpsOk = true;
        }
    }

    @Override
    public void onMapLoaded() {
        if (mapa.getMyLocation() != null) {
            mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mapa.getMyLocation().getLatitude(), mapa.getMyLocation().getLongitude()), 15));
            mapStatus.setVisibility(View.GONE);
            gpsOk = true;
        }

    }

    public void shutdown(View v) {
        if (Principal.p != null) Principal.p.finish();
        if (FactActivity.p != null) FactActivity.p.finish();
        if (VistaTopologica.topo != null) VistaTopologica.topo.finish();
        finish();
    }

    public void volver(View view) {
        this.finish();
    }

    /**
     * Boton Camara *
     */
    public void capturarImagen() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Uri output = Uri.fromFile(new File(name));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
        startActivityForResult(intent, TAKE_PICTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_PICTURE) {
            if (data != null) {
                if (data.hasExtra("data")) {
                    b = (Bitmap) data.getParcelableExtra("data");
                }
            } else {
                b = BitmapFactory.decodeFile(name);

            }
        }
        try {
            b = Bitmap.createScaledBitmap(b, 640, 480, true);
        } catch (Exception ex) {
        }

        verFoto.setEnabled(true);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tomarfoto){
            capturarImagen();
        }
        if(v.getId() == R.id.verfoto){
            AlertDialog.Builder bi = new AlertDialog.Builder(this);
            bi.setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            ImageView iv = new ImageView(this);
            iv.setImageBitmap(b);

            bi.setView(iv);
            bi.show();
        }
        if(v.getId() == R.id.enviar){

        }
    }
}