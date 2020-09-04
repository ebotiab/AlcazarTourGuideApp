package com.example.android.alcazartourguide;

public class TourItem {

    /** String resource ID for the name of the tour item */
    private String mName;

    /** String resource ID for a short description of the item */
    private String mDescription = NO_DESCRIPTION_PROVIDED;

    /** Constant value that represents no image was provided for this tour item */
    private static final String NO_DESCRIPTION_PROVIDED = "";

    /** Int resource ID for the number of stars of the item */
    private int mStars = NO_STARS_PROVIDED;

    /** Constant value that represents no punctuation was provided for this tour item */
    private static final int NO_STARS_PROVIDED = -1;

    /** Image resource ID for the Tour App */
    private int mImageResourceId;

    /** String resource ID for the localization in maps of the item */
    private String mMapsResourceId;

    /**
     * Create a new TourItem object.
     *
     * @param name is the string resource ID for the name of the item
     * @param description is the string resource Id for the description of the item
     * @param imageResourceId is the drawable resource ID for the image associated with the tour item
     * @param mapsResourceId is the resource ID for the localization in maps associated with this item
     */
    public TourItem(String name, String description, int imageResourceId, String mapsResourceId) {
        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
        mMapsResourceId = mapsResourceId;
    }

    /**
     * Create a new TourItem object.
     *
     * @param name is the string resource ID for the name of the item
     * @param stars is the resource ID for the number of stars of the item
     * @param imageResourceId is the drawable resource ID for the image associated with the tour item     *
     * @param mapsResourceId is the resource ID for the localization in maps associated with this item
     */
    public TourItem(String name, int stars, int imageResourceId,String mapsResourceId) {
        mName = name;
        mStars = stars;
        mImageResourceId = imageResourceId;
        mMapsResourceId = mapsResourceId;
    }

    /**
     * Get the string resource ID for the name of the tour item.
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the string resource ID for the description of the tour item.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Returns whether or not there is a description for the tour item.
     */
    public boolean hasDescription() {
        return mDescription != NO_DESCRIPTION_PROVIDED;
    }

    /**
     * Get the string resource ID for the description of the tour item.
     */
    public int getStars() {
        return mStars;
    }

    /**
     * Returns whether or not there is a punctuation for the tour item.
     */
    public boolean hasStars() {
        return mStars != NO_STARS_PROVIDED;
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
    public String getMapsResourceId() {
        return mMapsResourceId;
    }
}
