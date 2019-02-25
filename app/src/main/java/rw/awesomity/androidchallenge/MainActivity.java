package rw.awesomity.androidchallenge;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends Activity {

    // Once you have added a RecyclerView widget to your layout,
    // obtain a handle to the object, connect it to a layout manager,
    // and attach an adapter for the data to be displayed

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    List<Character> characterList;

    // Setup a Request Queue
    RequestQueue requestQueue;

    // Set the URL string where data is retrieved from
    String url = "https://awesomity.rw/api/sample/challenge/data/json";

    // Specify what happens on creation of the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Send http request using Volley
         */

        // Initialise the Request Queue from Volley
        requestQueue = Volley.newRequestQueue(this);

        /**
         * Activating the RecyclerView
         */

        // Get the RecyclerView resource
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_characters);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // Set a linear layout manager for the RecyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        characterList = new ArrayList<>();

        // send request to populate character list
        sendRequest();

        // Set an adapter to pull data for the RecyclerView (already done in sendRequest())
//        recyclerViewAdapter = new MarvelAdapter(this, characterList);
//        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * Make an HTTP request to the server
     */
    public void sendRequest(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    // Solved: https://stackoverflow.com/questions/12722468/org-json-jsonobject-cannot-be-converted-to-jsonarray-in-android
//                    JSONObject obj = new JSONObject();
//                    JSONArray data = new JSONArray(response);

                    JSONArray jsonArray = response.getJSONArray("data");

                    for(int i = 0; i < jsonArray.length(); i++){

                        Character ch = new Character();

                        JSONObject obj = jsonArray.getJSONObject(i);

                        ch.setName(obj.getString("name"));
                        ch.setLocation(obj.getString("location"));
                        ch.setPowers(obj.getString("powers"));
                        ch.setPhoto(Uri.parse(obj.getString("avatar")));

                        characterList.add(ch);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                recyclerViewAdapter = new MarvelAdapter(MainActivity.this, characterList);

                recyclerView.setAdapter(recyclerViewAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ~~~ ", error.toString());
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
