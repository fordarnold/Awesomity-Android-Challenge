package rw.awesomity.androidchallenge;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    // Once you have added a RecyclerView widget to your layout,
    // obtain a handle to the object, connect it to a layout manager,
    // and attach an adapter for the data to be displayed

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

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

        // Set an adapter to pull data for the RecyclerView
//        recyclerViewAdapter = new MarvelAdapter(dataset);
//        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
