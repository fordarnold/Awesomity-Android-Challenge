package rw.awesomity.androidchallenge;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MarvelAdapter extends RecyclerView.Adapter<MarvelAdapter.MyViewHolder> {

    private String[] myDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView name, location, powers;

        public MyViewHolder(View v) {
            super(v);

            name = (TextView) v.findViewById(R.id.txt_name);
            location = (TextView) v.findViewById(R.id.txt_location);
            powers = (TextView) v.findViewById(R.id.txt_powers);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MarvelAdapter(String[] dataset) {
        myDataset = dataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MarvelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_characters, parent, false);

        return new MyViewHolder(itemView);
    }

    // Bind the view holder to its data (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(myDataset[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return myDataset.length;
    }

}
