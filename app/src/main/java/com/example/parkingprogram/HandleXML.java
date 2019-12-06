package com.example.parkingprogram;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class HandleXML {
    private String carParkIdentity = "name";
    private String carParkOccupancy = "full";
    private String occupiedSpaces = "spaces_taken";
    private String totalCapacity = "total_spaces";
    private boolean selected;
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    public HandleXML(String url) {
        this.urlString = url;

    }


    public String getCarParkIdentity() {
        return carParkIdentity;
    }

    public String getCarParkOccupancy() {
        return carParkOccupancy;
    }

    public String getOccupiedSpaces() {
        return occupiedSpaces;
    }

    public String getTotalCapacity() {
        return totalCapacity;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text = null;
        try {
            event = myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                String name = myParser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (myParser.getName().equals("d2lm:situation")) {
                            carParkIdentity = "";

                            carParkOccupancy = "";

                            occupiedSpaces = "";

                            totalCapacity = "";

                            //lat
                            //long
                        }

                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (myParser.getName().equals("d2lm:situation")) {

                            Log.d("test", carParkIdentity + ":" + carParkOccupancy);


                            //occupiedSpaces = "";

                            //totalCapacity = "";

                            //lat
                            //long
                        } else if (myParser.getName().equals("d2lm:carParkIdentity")) {
                            carParkIdentity = text;
                        } else if (myParser.getName().equals("d2lm:carParkOccupancy")) {
                            carParkOccupancy = text;
                        } else if (name.equals("spaces_taken")) {
                            //occupiedSpaces = myParser.getAttributeValue(null, "value");
                        } else if (name.equals("total_spaces")) {
                            //totalCapacity = myParser.getAttributeValue(null, "value");
                        } else {
                        }
                        break;
                }
                event = myParser.next();
            }
            parsingComplete = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchXML(String response) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                    String userpass = "mon1611872datex2:f13P76Scrtv240u";
                    //String basicAuth = "Basic " + javax.xml.bind.DataTypeConverter.printBase64Binary(userpass.getBytes());
                    String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
                    connect.setRequestProperty("Authorization", basicAuth);
                    connect.setReadTimeout(10000);
                    connect.setConnectTimeout(15000);
                    connect.setRequestMethod("GET");
                    connect.setDoInput(true);
                    connect.connect();
                    InputStream stream = connect.getInputStream();
                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();
                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null);
                    parseXMLAndStoreIt(myparser);
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


}
