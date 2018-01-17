package com.example.angela.starwars.data.models;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by Angela on 16/01/2018.
 */

public class ResultList implements Serializable{
    public int count;
    public String next;
    public String previous;
    public ArrayList<People> results;

    public boolean hasMore() {
        return !TextUtils.isEmpty(next);
    }
}
