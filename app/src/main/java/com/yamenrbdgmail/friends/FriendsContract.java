package com.yamenrbdgmail.friends;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by German Center on 15/02/2017.
 */

public class FriendsContract {
    interface FriendsColumns{
        String FRIENDS_NAME = "friends_name";
        String FRIENDS_EMAIL = "friends_email";
        String FRIENDS_PHONE = "friends_phone";
    }
    public static final String CONTENT_AUTHORITY ="org.yamenrbdgmail.android.friends.provider";
    public static final Uri BASE_CONTENT_URI =Uri.parse("content://" +CONTENT_AUTHORITY);
    public static final String PATH_FRIENDS ="friends";

    private static final String [] TOP_LEVEL_PATH={
            PATH_FRIENDS
    };

    public static class Friends implements FriendsColumns , BaseColumns{
        public static final Uri CONTENT_URI=
                BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_FRIENDS).build();
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd."+CONTENT_AUTHORITY+".friends";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."+CONTENT_AUTHORITY+".friends";

        public static Uri buildFriendUri (String friendId){
            return CONTENT_URI.buildUpon().appendEncodedPath(friendId).build();
        }
        public static String getFriendId(Uri uri){
            return uri.getPathSegments().get(1);
        }
    }
}
