package com.yamenrbdgmail.friends;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by German Center on 15/02/2017.
 */

public class FriendsDatabase extends SQLiteOpenHelper {
    private static final String TAG = FriendsDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "friends.db";
    private static final int DATABASE_VERSION = 2;
    private Context mContext;

    interface Tables {
        String FRIENDS ="friends";
    }

    public FriendsDatabase(Context context){
        super(context ,DATABASE_NAME,null,DATABASE_VERSION);
        mContext = context ;
    }
}
