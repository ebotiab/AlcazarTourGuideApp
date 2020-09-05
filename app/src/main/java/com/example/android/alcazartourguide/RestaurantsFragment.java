package com.example.android.alcazartourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * {@link Fragment} that displays a list of restaurants tour items.
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        // Create a list of tour items
        final ArrayList<TourItem> tourItems = new ArrayList<TourItem>();
        tourItems.add(new TourItem(R.string.vicente, (float) 4.5, R.drawable.intur, R.string.loc_vicente));
        tourItems.add(new TourItem(R.string.puente, (float) 4.4, R.drawable.intur, R.string.loc_puente));
        tourItems.add(new TourItem(R.string.cayetana, (float) 4.3, R.drawable.intur, R.string.loc_cayetana));
        tourItems.add(new TourItem(R.string.cancelas, (float) 4.6, R.drawable.intur, R.string.loc_cancelas));
        tourItems.add(new TourItem(R.string.mancha, (float) 4.3, R.drawable.intur, R.string.loc_mancha));
        tourItems.add(new TourItem(R.string.chata, (float) 4.4, R.drawable.intur, R.string.loc_chata));
        tourItems.add(new TourItem(R.string.santina, (float) 3.8, R.drawable.intur, R.string.loc_santina));

        // Create an {@link TourItemAdapter}, whose data source is a list of {@link TourItem}s. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_item_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link TourItemAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link TourItem} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link TourItem} object at the given position the user clicked on
                TourItem tourItem = tourItems.get(position);

                // Get the maps resource of that {@link TourItem}
                int mapsResourceId = tourItem.getMapsResourceId();

                // Create an intent and set its date to the coordinates written in the resource
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(mapsResourceId)));

                // Starts the intent ensuring that the intent is catch
                if (intent.resolveActivity(getContext().getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
