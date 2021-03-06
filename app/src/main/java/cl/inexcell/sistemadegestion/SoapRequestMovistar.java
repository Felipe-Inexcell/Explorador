package cl.inexcell.sistemadegestion;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.KeyStore;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import cl.inexcell.sistemadegestion.objetos.FACT.MATERIAL_;
import cl.inexcell.sistemadegestion.objetos.FormularioEnvio;
import cl.inexcell.sistemadegestion.objetos.ParametrosEnvioForm;

@SuppressLint("SimpleDateFormat")
public class SoapRequestMovistar {

    //private static final String URL = "https://pcba.telefonicachile.cl/smartphone/ws/sca_dev.php";
    //final String URL="https://pcba.telefonicachile.cl:443/smartphone/ws/shark.php";
    //final String URL="http://cmn81.gratishosting.cl:80/shark_fijo.php";
    //private static final String URL = "https://pcba.telefonicachile.cl/smartphone/ws/sca_dev_copiaOP.php";
    private static final String URL = "https://pcba.telefonicachile.cl/smartphone/ws/sca_dev_TodoPruebas.php";
    //private static final String URL = "https://pcba.telefonicachile.cl/smartphone/ws/sca_dev_produccion.php";

	/*
     * Clase Principal de Conexion SSL a WDSL
	 */

    private static HttpClient getNewHttpClient() {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            SSLSocketFactory sf = new MySSLSocketFactory(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
            HttpConnectionParams.setConnectionTimeout(params, 10000);
            HttpConnectionParams.setSoTimeout(params, 20000);

            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));

            ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

            return new DefaultHttpClient(ccm, params);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }


    /*
     * XML-007: Certificacion DSL
     */
    //TODO: en revision
    public static String getCertifyDSL(String Phone, String Type, String Value, String IMEI, String IMSI) throws Exception {
        final String SOAP_ACTION = "urn:Demo#CertifyDSL";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:CertifyDSL soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestCertifyDSL xsi:type=\"urn:RequestCertifyDSL\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceCertifyDSLIn\">" +
                        "<CertifyDSL xsi:type=\"urn:CertifyDSLIn\">" +
                        "<Input xsi:type=\"urn:CertifyDSLInData\">" +
                        "<Phone xsi:type=\"xsd:string\">" + Phone + "</Phone>" +
                        "<!--Optional:-->" +
                        "<Type xsi:type=\"xsd:string\">" + Type + "</Type>" +
                        "<!--Optional:-->" +
                        "<Value xsi:type=\"xsd:string\">" + Value + "</Value>" +
                        "</Input>" +
                        "</CertifyDSL>" +
                        "</Service>" +
                        "</RequestCertifyDSL>" +
                        "</urn:CertifyDSL>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }

    //TODO: XML-008: Notificacion de 3G Funcionando
    public static String setNotification3G(String Lat, String Lng, String Provider,
                                           String Intensidad, String TipoRed, String Fecha, String IMEI, String IMSI) throws Exception {
        final String SOAP_ACTION = "urn:Demo#Notification3g";
        String response = null;
        String xml = null;

        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:Notification3g soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestNotification3g xsi:type=\"urn:RequestNotification3g\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">XML-008</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + Fecha + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + Fecha + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">" + 1 + "</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceNotification3gIn\">" +
                        "<Notification3g xsi:type=\"urn:Notification3gIn\">" +
                        "<Input xsi:type=\"urn:Notification3gInData\">" +
                        "<Gps xsi:type=\"urn:GPSType\">" +
                        "<Lat xsi:type=\"xsd:string\">" + Lat + "</Lat>" +
                        "<Lng xsi:type=\"xsd:string\">" + Lng + "</Lng>" +
                        "</Gps>" +
                        "<Provider xsi:type=\"xsd:string\">" + Provider + "</Provider>" +
                        "<!--Zero or more repetitions:-->" +
                        "<Parameter xsi:type=\"urn:CertifyParameterType\">" +
                        "<!--Zero or more repetitions:-->" +
                        "<Name xsi:type=\"xsd:string\">INTENSIDAD</Name>" +
                        "<!--Zero or more repetitions:-->" +
                        "<Value xsi:type=\"xsd:string\">" + Intensidad + "</Value>" +
                        "<!--Zero or more repetitions:-->" +
                        "<Code xsi:type=\"xsd:string\">INTENSIDAD</Code>" +
                        "<!--Zero or more repetitions:-->" +
                        "<Description xsi:type=\"xsd:string\">test</Description>" +
                        "</Parameter>" +


                        //TIPO RED
                        "<Parameter xsi:type=\"urn:CertifyParameterType\">" +
                               /*
                                *               operaciones de 3G
                                */

                        "<!--Zero or more repetitions:-->" +
                        "<Name xsi:type=\"xsd:string\">TIPO</Name>" +
                        "<!--Zero or more repetitions:-->" +
                        "<Value xsi:type=\"xsd:string\">" + TipoRed + "</Value>" +
                        "<!--Zero or more repetitions:-->" +
                        "<Code xsi:type=\"xsd:string\">TIPO</Code>" +
                        "<!--Zero or more repetitions:-->" +
                        "<Description xsi:type=\"xsd:string\">test</Description>" +
                        "</Parameter>" +
                        "</Input>" +
                        "</Notification3g>" +
                        "</Service>" +
                        "</RequestNotification3g>" +
                        "</urn:Notification3g>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }

    /*
     * XML-009: Localizacion de Averia
     */
    // TODO: Funcionando
    public static String setLocation(String Pict, String Element, String TypeDamage,
                                     String Classification,
                                     String Affectation,
                                     String Address,
                                     String Observation,
                                     String Lat, String Lng,
                                     String IMEI, String IMSI) throws Exception {
        final String SOAP_ACTION = "urn:Demo#Location";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();

        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:Location soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestLocation xsi:type=\"urn:RequestLocation\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">XML-009</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + fecha + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">1</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceLocationIn\">" +
                        "<Location xsi:type=\"urn:LocationIn\">" +
                        "<Input xsi:type=\"urn:LocationInData\">" +
                        "<Type xsi:type=\"xsd:string\">?</Type>" +
                        "<TypeDamage xsi:type=\"xsd:string\">" + TypeDamage + "</TypeDamage>" +
                        "<Classification xsi:type=\"xsd:string\">" + Classification + "</Classification>" +
                        "<Affectation xsi:type=\"xsd:string\">" + Affectation + "</Affectation>" +
                        "<FullAddress xsi:type=\"xsd:string\">" + Address + "</FullAddress>" +
                        "<Element xsi:type=\"xsd:string\">" + Element + "</Element>" +
                        "<Gps xsi:type=\"urn:GPSType\">" +
                        "<Lat xsi:type=\"xsd:string\">" + Lat + "</Lat>" +
                        "<Lng xsi:type=\"xsd:string\">" + Lng + "</Lng>" +
                        "</Gps>" +
                        "<Picture xsi:type=\"xsd:string\">" + Pict + "</Picture>" +
                        "<Coment xsi:type=\"xsd:string\">" + Observation + "</Coment>" +
                        "</Input>" +
                        "</Location>" +
                        "</Service>" +
                        "</RequestLocation>" +
                        "</urn:Location>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }

    /**
     * TODO: getDamage funcionando
     */
    public static String getDamage(String IMEI, String IMSI, String Operation, String Type) throws Exception {

        final String SOAP_ACTION = "urn:Demo#Damage";
        String response;
        String xml;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        String dato;
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        if (Type == null) {
            dato = "";
        } else
            dato = Type;

        String bodyOut =
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                        "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:Damage soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestDamage xsi:type=\"urn:RequestDamage\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + dato + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceDamageIn\">" +
                        "<Damage xsi:type=\"urn:DamageIn\">" +
                        "<Input xsi:type=\"urn:DamageInData\">" +
                        "<!--Optional:-->" +
                        "<Type xsi:type=\"xsd:string\">" + Operation + "</Type>" +
                        "</Input>" +
                        "</Damage>" +
                        "</Service>" +
                        "</RequestDamage>" +
                        "</urn:Damage>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }


    //TODO: Get Resources funcionando
    public static String getResource(String IMEI, String IMSI, String Phone) throws Exception, HttpHostConnectException, HttpResponseException, SocketException, SocketTimeoutException {

        final String SOAP_ACTION = "urn:Demo#Resource";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();

        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                        "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:Resource soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestResource xsi:type=\"urn:RequestResource\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceResourceIn\">" +
                        "<Resource xsi:type=\"urn:ResourceIn\">" +
                        "<Input xsi:type=\"urn:ResourceInData\">" +
                        "<Phone xsi:type=\"xsd:string\">" + Phone + "</Phone>" +
                        "</Input>" +
                        "</Resource>" +
                        "</Service>" +
                        "</RequestResource>" +
                        "</urn:Resource>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);

        HttpParams httpParameters = new BasicHttpParams();
// Set the timeout in milliseconds until a connection is established.
// The default value is zero, that means the timeout is not used.
        int timeoutConnection = 20000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
// Set the default socket timeout (SO_TIMEOUT)
// in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 40000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        httpPost.setParams(httpParameters);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }

    //TODO: Get ActionButton funcionando
    public static String getActionButton(String IMEI, String IMSI, String Phone, String Type, String Action) throws Exception {

        final String SOAP_ACTION = "urn:Demo#ActionButton";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();

        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:ActionButton soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestActionButton xsi:type=\"urn:RequestActionButton\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceActionButtonIn\">" +
                        "<ActionButton xsi:type=\"urn:ActionButtonIn\">" +
                        "<Input xsi:type=\"urn:ActionButtonInData\">" +
                        "<Phone xsi:type=\"xsd:string\">" + Phone + "</Phone>" +
                        "<!--Optional:-->" +
                        "<Type xsi:type=\"xsd:string\">" + Type + "</Type>" +
                        "<!--Optional:-->" +
                        "<Action xsi:type=\"xsd:string\">" + Action + "</Action>" +
                        "</Input>" +
                        "</ActionButton>" +
                        "</Service>" +
                        "</RequestActionButton>" +
                        "</urn:ActionButton>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }

    //TODO: Get Puntos
    public static String getMapMarkers(String IMEI, String IMSI, String Comuna, String Region) throws IOException {

        final String SOAP_ACTION = "urn:Demo#NeighborNode";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();

        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:NeighborNode soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestNeighborNode xsi:type=\"urn:RequestNeighborNode\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha).toString() + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceNeighborNodeIn\">" +
                        "<NeighborNode xsi:type=\"urn:NeighborNodeIn\">" +
                        "<Input xsi:type=\"urn:NeighborNodeInData\">" +
                        "<GetFrom xsi:type=\"urn:GetFromType\">" +
                        "<Comuna xsi:type=\"xsd:string\">" + Comuna + "</Comuna>" +
                        "<Region xsi:type=\"xsd:string\">" + Region + "</Region>" +
                        "</GetFrom>" +
                        "</Input>" +
                        "</NeighborNode>" +
                        "</Service>" +
                        "</RequestNeighborNode>" +
                        "</urn:NeighborNode>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);

        HttpParams httpParameters = new BasicHttpParams();
// Set the timeout in milliseconds until a connection is established.
// The default value is zero, that means the timeout is not used.
        int timeoutConnection = 10000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
// Set the default socket timeout (SO_TIMEOUT)
// in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 25000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        httpPost.setParams(httpParameters);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }

    public static String postCertifyDSL(String Phone, String IMEI, String IMSI, String OperationCode, String OperationId) throws Exception {
        final String SOAP_ACTION = "urn:Demo#PostCertifyDSL";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:PostCertifyDSL soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestPostCertifyDSL xsi:type=\"urn:RequestPostCertifyDSL\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">" + OperationCode + "</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + OperationId + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha) + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServicePostCertifyDSLIn\">" +
                        "<PostCertifyDSL xsi:type=\"urn:PostCertifyDSLIn\">" +
                        "<Input xsi:type=\"urn:PostCertifyDSLInData\">" +
                        "<Phone xsi:type=\"xsd:string\">" + Phone + "</Phone>" +
                        "</Input>" +
                        "</PostCertifyDSL>" +
                        "</Service>" +
                        "</RequestPostCertifyDSL>" +
                        "</urn:PostCertifyDSL>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }

    public static String guardarFact(String Phone, String IMEI, String IMSI, String OperationCode, String OperationId, ArrayList<FormularioEnvio> formulario, ArrayList<MATERIAL_> series) throws Exception {
        final String SOAP_ACTION = "urn:Demo#GuardarFact";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:GuardarFact soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestGuardarFact xsi:type=\"urn:RequestGuardarFact\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">" + OperationCode + "</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">" + OperationId + "</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha) + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceGuardarFactIn\">" +
                        "<GuardarFact xsi:type=\"urn:GuardarFactIn\">" +
                        "<Input xsi:type=\"urn:GuardarFactInData\">" +
                        "<Phone xsi:type=\"xsd:string\">" + Phone + "</Phone>";

        for (FormularioEnvio fe : formulario) {
            Log.w("XML", "*" + fe.getType());
            bodyOut += "<Element xsi:type=\"urn:ElementData\">" +
                    "<type xsi:type=\"xsd:string\">" + fe.getType() + "</type>" +
                    "<Identification xsi:type=\"urn:IdentificationData\">";
            for (ParametrosEnvioForm pef : fe.getParametros()) {
                if (pef.getAttribute().compareTo("Carnet") != 0 && pef.getAttribute().compareTo("Firma") != 0) {
                    Log.w("XML", "***" + pef.getAttribute() + " - " + pef.getValue());
                    bodyOut +=
                            "<Parameter xsi:type=\"urn:ParameterData\">" +
                                    "<Attribute xsi:type=\"xsd:string\">" + pef.getAttribute() + "</Attribute>" +
                                    "<Value xsi:type=\"xsd:string\">" + pef.getValue() + "</Value>" +
                                    "</Parameter>";
                }

            }
            bodyOut += "</Identification>" +
                    "</Element>";
        }

        String xmlSeries="";
        if(series != null && series.size() > 0){
            bodyOut += "<IngresarSerial xsi:type=\"urn:IngresarSerialData\">";

            //BROADBAND
            for(MATERIAL_ m: series){
                if(m.getType().equals("Broadband") && m.getSeries() != null && m.getSeries().size() > 0) {
                    xmlSeries += "<Serial xsi:type=\"urn:SerialesData\">" +
                            "<TypeNodo xsi:type=\"xsd:string\">FactBandaAnchaSeriales</TypeNodo>";
                    for (String s : m.getSeries()) {
                        xmlSeries += "<IdentificationSeriales xsi:type=\"urn:IdentificationSerialesData\">" +
                                "<type xsi:type=\"xsd:string\">"+m.getName()+"</type>" +
                                "<Serial xsi:type=\"xsd:string\">" + s.replace("¬¬",";") + "</Serial>" +
                                "</IdentificationSeriales>";
                    }
                    xmlSeries+="</Serial>";
                }
            }
            //Telephony
            for(MATERIAL_ m: series){
                if(m.getType().equals("Telephony") && m.getSeries() != null && m.getSeries().size() > 0) {
                    xmlSeries += "<Serial xsi:type=\"urn:SerialesData\">" +
                            "<TypeNodo xsi:type=\"xsd:string\">FactTelefoniaSeriales</TypeNodo>";
                    for (String s : m.getSeries()) {
                        xmlSeries += "<IdentificationSeriales xsi:type=\"urn:IdentificationSerialesData\">" +
                                "<type xsi:type=\"xsd:string\">"+m.getName()+"</type>" +
                                "<Serial xsi:type=\"xsd:string\">" + s.replace("¬¬",";") + "</Serial>" +
                                "</IdentificationSeriales>";
                    }
                    xmlSeries+="</Serial>";
                }
            }
            //DigitalTelevisio
            for(MATERIAL_ m: series){
                if(m.getType().equals("DigitalTelevision") && m.getSeries() != null && m.getSeries().size() > 0) {
                    xmlSeries += "<Serial xsi:type=\"urn:SerialesData\">" +
                            "<TypeNodo xsi:type=\"xsd:string\">FactTelevisionSeriales</TypeNodo>";
                    for (String s : m.getSeries()) {
                        xmlSeries += "<IdentificationSeriales xsi:type=\"urn:IdentificationSerialesData\">" +
                                "<type xsi:type=\"xsd:string\">"+m.getName()+"</type>" +
                                "<Serial xsi:type=\"xsd:string\">" + s.replace("¬¬",";") + "</Serial>" +
                                "</IdentificationSeriales>";
                    }
                    xmlSeries+="</Serial>";
                }
            }

            xmlSeries +="</IngresarSerial>";
        }
        bodyOut+=xmlSeries;

                bodyOut +="</Input>" +
                "</GuardarFact>" +
                "</Service>" +
                "</RequestGuardarFact>" +
                "</urn:GuardarFact>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        xml = bodyOut;
        Log.d("XML", bodyOut);

        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }

    public static String subirFoto(String id, String imagen, int Type, String IMEI, String IMSI) throws IOException {

        final String SOAP_ACTION = "urn:Demo#GuardarFotosFact";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:GuardarFotosFact soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestGuardarFotosFact xsi:type=\"urn:RequestGuardarFotosFact\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">?</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha) + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceGuardarFotosFactIn\">" +
                        "<GuardarFotosFact xsi:type=\"urn:GuardarFotosFactIn\">" +
                        "<Input xsi:type=\"urn:GuardarFotosFactInData\">" +
                        "<IdFact xsi:type=\"xsd:string\">" + id + "</IdFact>" +
                        "<Type xsi:type=\"xsd:string\">" + Type + "</Type>" +
                        "<Foto xsi:type=\"xsd:string\">" + imagen + "</Foto>" +
                        "</Input>" +
                        "</GuardarFotosFact>" +
                        "</Service>" +
                        "</RequestGuardarFotosFact>" +
                        "</urn:GuardarFotosFact>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;

    }

    public static String getDCTOnDemand(String IMEI, String IMSI, String PHONE) throws IOException {

        final String SOAP_ACTION = "urn:Demo#DCTOnDemand";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:DCTOnDemand soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestDCTOnDemand xsi:type=\"urn:RequestDCTOnDemand\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">?</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha) + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">" + IMEI + "</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceDCTOnDemandIn\">" +
                        "<DCTOnDemand xsi:type=\"urn:DCTOnDemandIn\">" +
                        "<Input xsi:type=\"urn:DCTOnDemandInData\">" +
                        "<Phone xsi:type=\"xsd:string\">" + PHONE + "</Phone>" +
                        "</Input>" +
                        "</DCTOnDemand>" +
                        "</Service>" +
                        "</RequestDCTOnDemand>" +
                        "</urn:DCTOnDemand>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);

        HttpParams httpParameters = new BasicHttpParams();
// Set the timeout in milliseconds until a connection is established.
// The default value is zero, that means the timeout is not used.
        int timeoutConnection = 20000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
// Set the default socket timeout (SO_TIMEOUT)
// in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 60000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        httpPost.setParams(httpParameters);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;

    }

    public static String getParaElectri(String IMEI, String IMSI, String PHONE) throws IOException {

        final String SOAP_ACTION = "urn:Demo#ParaElectri";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:ParaElectri soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestParaElectri xsi:type=\"urn:RequestParaElectri\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">?</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha) + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">" + IMEI + "</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceParaElectriIn\">" +
                        "<ParaElectri xsi:type=\"urn:ParaElectriIn\">" +
                        "<Input xsi:type=\"urn:ParaElectriInData\">" +
                        "<Phone xsi:type=\"xsd:string\">" + PHONE + "</Phone>" +
                        "</Input>" +
                        "</ParaElectri>" +
                        "</Service>" +
                        "</RequestParaElectri>" +
                        "</urn:ParaElectri>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);

        HttpParams httpParameters = new BasicHttpParams();
// Set the timeout in milliseconds until a connection is established.
// The default value is zero, that means the timeout is not used.
        int timeoutConnection = 20000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
// Set the default socket timeout (SO_TIMEOUT)
// in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 60000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        httpPost.setParams(httpParameters);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;

    }


    public static String sendClosedHouse(String IMEI, String IMSI, String DESC, String IMG, String LAT, String LNG, String FONO) throws IOException {

        final String SOAP_ACTION = "urn:Demo#CasaCerrada";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:CasaCerrada soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestCasaCerrada xsi:type=\"urn:RequestCasaCerrada\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">?</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha) + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">" + IMEI + "</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServiceCasaCerradaIn\">" +
                        "<CasaCerrada xsi:type=\"urn:CasaCerradaIn\">" +
                        "<Input xsi:type=\"urn:CasaCerradaInData\">" +
                        "<Phone xsi:type=\"xsd:string\">" + FONO + "</Phone>" +
                        "<description xsi:type=\"xsd:string\">" + DESC + "</description>" +
                        "<Foto xsi:type=\"xsd:string\">" + IMG + "</Foto>" +
                        "<GPSLat xsi:type=\"xsd:string\">" + LAT + "</GPSLat>" +
                        "<GPSLng xsi:type=\"xsd:string\">" + LNG + "</GPSLng>" +
                        "</Input>" +
                        "</CasaCerrada>" +
                        "</Service>" +
                        "</RequestCasaCerrada>" +
                        "</urn:CasaCerrada>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;

    }

    /*
     * XML-007: Certificacion DSL
     */
    //TODO: en revision
    public static String getButtonBlock(String IMEI, String IMSI) throws Exception {
        final String SOAP_ACTION = "urn:Demo#bloqueoBotones";
        String response = null;
        String xml = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fecha = new Date();
        HttpClient httpClient = getNewHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        String bodyOut =
                "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:bloqueoBotones soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
                        "<RequestbloqueoBotones xsi:type=\"urn:RequestbloqueoBotones\">" +
                        "<Operation xsi:type=\"urn:OperationType\">" +
                        "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                        "<OperationId xsi:type=\"xsd:string\">?</OperationId>" +
                        "<!--Optional:-->" +
                        "<DateTime xsi:type=\"xsd:string\">" + formatter.format(fecha) + "</DateTime>" +
                        "<!--Optional:-->" +
                        "<IdUser xsi:type=\"xsd:string\">" + IMEI + "</IdUser>" +
                        "<IMEI xsi:type=\"xsd:string\">" + IMEI + "</IMEI>" +
                        "<IMSI xsi:type=\"xsd:string\">" + IMSI + "</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"urn:ServicebloqueoBotonesIn\">" +
                        "<bloqueoBotones xsi:type=\"urn:bloqueoBotonesIn\">" +
                        "<Input xsi:type=\"urn:bloqueoBotonesInData\">" +
                        "<IMEI xsi:type=\"xsd:string\">?</IMEI>" +
                        "</Input>" +
                        "</bloqueoBotones>" +
                        "</Service>" +
                        "</RequestbloqueoBotones>" +
                        "</urn:bloqueoBotones>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        xml = bodyOut;
        StringEntity se = new StringEntity(xml, HTTP.UTF_8);
        se.setContentType("text/xml");
        httpPost.addHeader(SOAP_ACTION, URL);

        httpPost.setEntity(se);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity resEntity = httpResponse.getEntity();
        response = EntityUtils.toString(resEntity);
        return response;
    }


}

