package com.hilmansyafei.lihatjadwal;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hilman Syafei on 24/03/2015.
 */
public class List_ujian extends ListActivity {

    private ProgressDialog pDialog;
    String menu;
    String kelas;
    // URL to get contacts JSON
    String tambahan = "contacts/";
    //private String url = "http://api.androidhive.info/"+tambahan;
    //private String  url = "http://hilanproject.com/data_jadwal/";
    private String url;

    // JSON Node names
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_HARI = "hari";
    private static final String TAG_MATKUL = "matkul";
    private static final String TAG_TANGGAL = "dosen";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_GENDER = "gender";
    private static final String TAG_RUANG = "ruang";
    private static final String TAG_WAKTU = "waktu";
    private static final String TAG_PHONE_HOME = "home";
    private static final String TAG_PHONE_OFFICE = "office";

    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_data_ujian);
        Intent i = this.getIntent();
        String get_pesan = i.getStringExtra("kelas");
        //menu = i.getStringExtra("menu");
        url = "http://hilanproject.com/data_jadwal/jad_uts.php?kelas="+get_pesan;
        contactList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();

        // Listview on item click listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String name = ((TextView) view.findViewById(R.id.hari))
                        .getText().toString();
                String cost = ((TextView) view.findViewById(R.id.matkul))
                        .getText().toString();
                String description = ((TextView) view.findViewById(R.id.ruang))
                        .getText().toString();

                // Starting single contact activity
//                Intent in = new Intent(getApplicationContext(),
//                        SingleContactActivity.class);
//                in.putExtra(TAG_NAME, name);
//                in.putExtra(TAG_EMAIL, cost);
//                in.putExtra(TAG_PHONE_MOBILE, description);
//                startActivity(in);

            }
        });

        // Calling async task to get json
        new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(List_ujian.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    //contacts = jsonObj.getJSONArray(TAG_CONTACTS);

                        contacts = jsonObj.getJSONArray("data_jadwal_ujian");


                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

//                        String id = c.getString(TAG_ID);
//                        String name = c.getString(TAG_NAME);
//                        String email = c.getString(TAG_EMAIL);
//                        String address = c.getString(TAG_ADDRESS);
//                        String gender = c.getString(TAG_GENDER);

                        String hari = c.getString("hari");
                        String tangal = c.getString("tanggal");
                        String waktu = c.getString("waktu");
                        String matkul = c.getString("mata_kuliah");
                        String ruang = c.getString("ruang");


                        // Phone node is JSON Object
//                        JSONObject phone = c.getJSONObject(TAG_PHONE);
//                        String mobile = phone.getString(TAG_PHONE_MOBILE);
//                        String home = phone.getString(TAG_PHONE_HOME);
//                        String office = phone.getString(TAG_PHONE_OFFICE);

                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value

                        contact.put(TAG_HARI, hari+" "+tangal);
                        contact.put(TAG_MATKUL, matkul);
                        contact.put(TAG_WAKTU,waktu);
                        contact.put(TAG_RUANG, ruang);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    List_ujian.this, contactList,
                    R.layout.list_item_ujian, new String[]{TAG_HARI, TAG_MATKUL,TAG_WAKTU,
                    TAG_RUANG}, new int[]{R.id.hari,
                    R.id.matkul,R.id.waktu, R.id.ruang});

            setListAdapter(adapter);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splahscreen, menu);
        return true;
    }
}

