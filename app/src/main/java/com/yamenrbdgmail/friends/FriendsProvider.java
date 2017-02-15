package com.yamenrbdgmail.friends;

import android.content.ContentProvider;
import android.content.UriMatcher;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by German Center on 15/02/2017.
 */

public class FriendsProvider extends ContentProvider{

    private FriendsDatabase mOpenHelper;

    private static String TAG = FriendsProvider.class.getSimpleName();
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private final static int FRIENDS=100;
    private final static int FRIENDS_ID=101;

    public static UriMatcher buildUriMatcher(){
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = FriendsContract.CONTENT_AUTHORITY;
        matcher.addURI(authority,"friends",FRIENDS);
        matcher.addURI(authority,"friends",FRIENDS_ID);
        return matcher
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new FriendsDatabase(getContext());
        return true;
    }

    public void deleteDatabase(){
        mOpenHelper.close();
        FriendsDatabase.deleteDatabase(getContext());
        mOpenHelper = new FriendsDatabase(getContext());

    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case FRIENDS:
                return FriendsContract.Friends.CONTENT_TYPE;
            case FRIENDS_ID:
                return FriendsContract.Friends.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("unknown uri "+ uri);

        }

    }
}
