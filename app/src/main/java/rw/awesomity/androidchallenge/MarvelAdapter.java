package rw.awesomity.androidchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * This adapter is used to transport and manipulate data
 * for the RecyclerView.
 *
 */
public class MarvelAdapter extends RecyclerView.Adapter<MarvelAdapter.MyViewHolder> {

    private Context context;
    private List<Character> characterList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MarvelAdapter(Context context, List characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_character, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    // Bind the view holder to its data (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {

        // - get element from your dataset at this position
        viewHolder.itemView.setTag(characterList.get(position));

        Character ch = characterList.get(position);

        // - replace the contents of the view with that element
        viewHolder.name.setText(ch.getName());
        viewHolder.location.setText(ch.getLocation());
        viewHolder.powers.setText(ch.getPowers());
        viewHolder.photo.setImageURI(ch.getPhoto());

    }

    // Provide a reference to the views for each data item.
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView name;
        public TextView location;
        public TextView powers;
        public ImageView photo;

        // instantiate the view item
        public MyViewHolder(View item) {
            super(item);

            name = (TextView) item.findViewById(R.id.txt_name);
            location = (TextView) item.findViewById(R.id.txt_location);
            powers = (TextView) item.findViewById(R.id.txt_powers);
            photo = (ImageView) item.findViewById(R.id.img_photo);

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



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return characterList.size();
    }

}
