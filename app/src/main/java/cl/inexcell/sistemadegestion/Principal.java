package cl.inexcell.sistemadegestion;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.ArrayList;

public class Principal extends Activity {
    public static Activity p;

    private static final String TAG = "Principal Activity";
    LocationManager locationManager;
    private EditText phone;

    private String asd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "INICIANDO APLICACION");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_principal);
        p = this;


        phone = (EditText) findViewById(R.id.etPpal_telefono);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        /** Se inicia el DEMONIO **/

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            try {
                Intent service = new Intent(this, Demonio_Certificar_3G.class);
                startService(service);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "START SERVICE ERROR", Toast.LENGTH_LONG).show();
            }

        } else {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("GPS está desactivado!")
                    .setMessage("Active GPS e reinicie la aplicación.")
                    .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Salir
                            Principal.this.finish();
                        }
                    }).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_principal, menu);
        return true;
    }


    public void show_notificar_averias(View view) {

        ConnectivityManager conMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        State senal3g = conMan.getNetworkInfo(0).getState();
        State wifi = conMan.getNetworkInfo(1).getState();

        if (senal3g == State.CONNECTED || wifi == State.CONNECTED) {
            Intent i = new Intent(this, Notificar_Averias.class);
            startActivityForResult(i, 0);

        } else {
            Toast.makeText(getApplicationContext(), "No existe conexión a internet para utilizar el Programa", Toast.LENGTH_LONG).show();
        }
    }

    public void buscar_cliente(View view) {
        ConnectivityManager conMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        State senal3g = conMan.getNetworkInfo(0).getState();
        State wifi = conMan.getNetworkInfo(1).getState();
        if (senal3g == State.CONNECTED || wifi == State.CONNECTED) {
            if (phone.getText().length() == 0 || phone.getText() == null) {
                Toast.makeText(getApplicationContext(), "Ingrese télefono del cliente", Toast.LENGTH_SHORT).show();
                return;
            }

            Consulta_Resources c = new Consulta_Resources();
            c.execute();
        } else {
            Toast.makeText(getApplicationContext(), "No existe conexión a internet para utilizar el Programa", Toast.LENGTH_LONG).show();
        }
    }


    public void show_plantas_externas(View view) {
        ConnectivityManager conMan = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        State senal3g = conMan.getNetworkInfo(0).getState();
        State wifi = conMan.getNetworkInfo(1).getState();

        if (senal3g == State.CONNECTED || wifi == State.CONNECTED) {
            Intent i = new Intent(this, Plantas_Externas.class);
            startActivityForResult(i, 0);

        } else {
            Toast.makeText(getApplicationContext(), "No existe conexión a internet para utilizar el Programa", Toast.LENGTH_LONG).show();
        }
    }

    public void shutdown(View view) {
        this.finish();
    }

    public void openFAQ(View view) {
        startActivity(new Intent(this, FAQActivity.class));
    }


    private class Consulta_Resources extends AsyncTask<String, Integer, String> {

        private final ProgressDialog dialog = new ProgressDialog(Principal.this);
        private int code;
        String errorMessage ="";

        protected void onPreExecute() {
            this.dialog.setMessage("Buscando Cliente...");
            this.dialog.setCanceledOnTouchOutside(false);
            this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    // TODO Auto-generated method stub
                    Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_SHORT).show();

                }
            });
            this.dialog.show();
            //super.onPreExecute();
        }

        protected String doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            String respuesta = null;

            try {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String IMEI = telephonyManager.getDeviceId();
                String IMSI = telephonyManager.getSimSerialNumber();
                String consulta;
                if (phone.getText().toString().equals("2")) {
                    consulta = URLs.RESOURCE;
                } else
                    consulta = SoapRequestMovistar.getResource(IMEI, IMSI, phone.getText().toString());

                ArrayList<String> retorno = XMLParser.getReturnCode(consulta);

                code = Integer.valueOf(retorno.get(0));

                if (code == 0) {
                    respuesta = consulta;
                    Log.i(TAG, retorno.get(1));
                } else
                    respuesta = retorno.get(1);
                return respuesta;

            }catch (HttpHostConnectException e2) {
                errorMessage = "Se agotó el tiempo de espera. Por favor reintente";
                return null;
            }catch (HttpResponseException e3) {
                e3.printStackTrace();
                errorMessage = "Se agotó el tiempo de espera. Por favor reintente";
                return null;
            }catch (ParseException p) {
                p.printStackTrace();
                errorMessage = "Error en la recepción de los datos. Por favor reintente";
                return null;
            }catch(SocketTimeoutException s1){
                s1.printStackTrace();
                errorMessage = "Se agotó el tiempo de espera. Por favor reintente";
                return null;
            }catch (ConnectTimeoutException et) {
                et.printStackTrace();
                errorMessage = "Se agotó el tiempo de espera. Por favor reintente";
                return null;
            }catch (Exception e1) {
                e1.printStackTrace();
                errorMessage = "Ha ocurrido un error con la respuesta del servidor.";
                return null;
            }
        }


        protected void onPostExecute(String result) {
            if (result != null) {
                if (code == 0) {
                    Intent topologica = new Intent(getApplicationContext(), VistaTopologica.class);
                    topologica.putExtra("PHONE", phone.getText().toString());
                    topologica.putExtra("RESULT", result);
                    startActivityForResult(topologica, 0);
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(50);
                } else {
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
            }

            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }

        }
    }


}
