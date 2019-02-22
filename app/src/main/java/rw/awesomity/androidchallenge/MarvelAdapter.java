package rw.awesomity.androidchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MarvelAdapter extends RecyclerView.Adapter<MarvelAdapter.MyViewHolder> {

    private Context context;
    private List<Character> characterList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView name;
        public TextView location;
        public TextView powers;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.txt_name);
            location = (TextView) itemView.findViewById(R.id.txt_location);
            powers = (TextView) itemView.findViewById(R.id.txt_powers);

            // Define what happens when you click on a single list item
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Character character = (Character) view.getTag();

                    Toast.makeText(view.getContext(), character.getName()+" "+character.getLocation()+" is "+ character.getPowers(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MarvelAdapter(Context context, List characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MarvelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_characters, parent, false);

        return new MyViewHolder(v);
    }

    // Bind the view holder to its data (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.itemView.setTag(characterList.get(position));

        Character ch = characterList.get(position);

        holder.name.setText(ch.getName());
        holder.location.setText(ch.getLocation());
        holder.powers.setText(ch.getPowers());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return characterList.size();
    }

}
