package rw.awesomity.androidchallenge;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        /**
         * Send http request using Volley
         */

        requestQueue = Volley.newRequestQueue(this);

        characterList = new ArrayList<>();

        sendRequest();

        // Set an adapter to pull data for the RecyclerView
//        recyclerViewAdapter = new MarvelAdapter(dataset);
//        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void sendRequest(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    Character ch = new Character();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        ch.setName(jsonObject.getString("name"));
                        ch.setLocation(jsonObject.getString("location"));
                        ch.setPowers(jsonObject.getString("powers"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    characterList.add(ch);

                }

                recyclerViewAdapter = new MarvelAdapter(MainActivity.this, characterList);

                recyclerView.setAdapter(recyclerViewAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}
