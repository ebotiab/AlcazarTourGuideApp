package com.example.android.alcazartourguide;

import android.content.Intent;
import android.net.Uri;

public class TourItem {

    /** Int resource ID for the name of the tour item */
    private int mNameResource;

    /** Int resource ID for a short description of the item */
    private int mDescriptionResource = NO_PROVIDED;

    /** Int resource ID for the number of stars of the item */
    private float mStars = NO_PROVIDED;

    /** Constant value that represents no description resource or no punctuation was provided for this tour item */
    private static final int NO_PROVIDED = -1;

    /** Image resource ID for the Tour App */
    private int mImageResourceId;

    /** String resource ID for the localization in maps of the item */
    private int mMapsResourceId;

    /**
     * Create a new TourItem object.
     *
     * @param nameResource is the string resource ID for the name of the item
     * @param descriptionResource is the string resource Id for the description of the item
     * @param imageResourceId is the drawable resource ID for the image associated with the tour item
     * @param mapsResourceId is the resource ID for the localization in maps associated with this item
     */
    public TourItem(int nameResource, int descriptionResource, int imageResourceId, int mapsResourceId) {
        mNameResource = nameResource;
        mDescriptionResource = descriptionResource;
        mImageResourceId = imageResourceId;
        mMapsResourceId = mapsResourceId;
    }

    /**
     * Create a new TourItem object.
     *
     * @param nameResource is the string resource ID for the name of the item
     * @param stars is the resource ID for the number of stars of the item
     * @param imageResourceId is the drawable resource ID for the image associated with the tour item     *
     * @param mapsResourceId is the resource ID for the localization in maps associated with this item
     */
    public TourItem(int nameResource, float stars, int imageResourceId,int mapsResourceId) {
        mNameResource = nameResource;
        mStars = stars;
        mImageResourceId = imageResourceId;
        mMapsResourceId = mapsResourceId;
    }

    /**
     * Get the resource ID for the name of the tour item.
     */
    public int getNameResource() {
        return mNameResource;
    }

    /**
     * Get the resource ID for the description of the tour item.
     */
    public int getDescriptionResource() {
        return mDescriptionResource;
    }

    /**
     * Returns whether or not there is a description for the tour item.
     */
    public boolean hasDescription() {
        return mDescriptionResource != NO_PROVIDED;
    }

    /**
     * Get the resource ID for the description of the tour item.
     */
    public float getStars() {
        return mStars;
    }

    /**
     * Returns whether or not there is a punctuation for the tour item.
     */
    public boolean hasStars() {
        return mStars != NO_PROVIDED;
    }

    /**
     * Return the image resource ID of the tour item.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the maps resource ID of the tour item.
     */
    public int getMapsResourceId() {
        return mMapsResourceId;
    }
}
