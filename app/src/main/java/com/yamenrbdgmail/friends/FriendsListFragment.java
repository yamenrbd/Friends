package com.yamenrbdgmail.friends;

import android.content.ContentResolver;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;

import java.util.List;

/**
 * Created by yamen on 2/17/2017.
 */

public class FriendsListFragment extends ListFragment
    implements LoaderManager.LoaderCallbacks<List<Friend>>{

    private static final String LOG_TAG = FriendsListFragment.class.getSimpleName();
    private FriendCustomAdapter mAdapter;
    private static final int LOADER_ID = 1;
    private ContentResolver mResolver ;
    private List<Friend> mFriends ;



    }
