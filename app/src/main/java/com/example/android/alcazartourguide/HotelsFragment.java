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
 * {@link Fragment} that displays a list of hotels tour items.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        // Create a list of tour items
        final ArrayList<TourItem> tourItems = new ArrayList<TourItem>();
        tourItems.add(new TourItem(R.string.intur, (float) 4.3, R.drawable.intur, R.string.loc_intur));
        tourItems.add(new TourItem(R.string.insula_barataria, (float) 3.9, R.drawable.insula_barataria, R.string.loc_insula_barataria));
        tourItems.add(new TourItem(R.string.santa_clara, (float) 3.9, R.drawable.convento_santa_clara, R.string.loc_santa_clara));
        tourItems.add(new TourItem(R.string.hidalgo_quijada, (float) 4.2, R.drawable.hidalgo_quijada, R.string.loc_hidalgo_quijada));
        tourItems.add(new TourItem(R.string.welcome2, (float) 3.7, R.drawable.welcome2_alcazar, R.string.loc_welcome2));
        tourItems.add(new TourItem(R.string.dulcinea, (float) 4.3, R.drawable.dulcinea_el_toboso, R.string.loc_dulcinea));
        tourItems.add(new TourItem(R.string.bachiller, (float) 4.4, R.drawable.la_casa_del_bachiller, R.string.loc_bachiller));

        // Create an {@link TourItemAdapter}, whose data source is a list of {@link TourItem}s. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category);

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
