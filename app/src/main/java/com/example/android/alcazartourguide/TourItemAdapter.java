package com.example.android.alcazartourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

/**
 * {@link TourItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link TourItem} objects.
 */
public class TourItemAdapter extends ArrayAdapter<TourItem>  {

    /** Resource ID for the background color for this list of tour items */
    private int mColorResourceId;

    /**
     * Create a new {@link TourItemAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param tourItems is the list of {@link TourItem}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of tour items.
     */
    public TourItemAdapter(Context context, ArrayList<TourItem> tourItems, int colorResourceId) {
        super(context, 0, tourItems);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link TourItem} object located at this position in the list
        TourItem currentTourItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        // Get the name from the currentTourItem object and set this text on
        // the name TextView.
        nameTextView.setText(currentTourItem.getNameResource());

        // Find the TextView in the list_item.xml layout with the ID description_text_view.
        TextView descriptionTextView = listItemView.findViewById(R.id.description_text_view);
        // Check if an description is provided for this tour item or not
        if (currentTourItem.hasDescription()) {
            // If a description is available, display the provided description
            descriptionTextView.setText(currentTourItem.getDescriptionResource());
            // Make sure the view is visible
            descriptionTextView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            descriptionTextView.setVisibility(View.GONE);
        }

        // Find the ImageView in the list_item.xml layout with the ID stars.
        ImageView imageView = listItemView.findViewById(R.id.stars);
        // Get the image from the currentTourItem object and set it on the image View.
        imageView.setImageResource(currentTourItem.getImageResourceId());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}