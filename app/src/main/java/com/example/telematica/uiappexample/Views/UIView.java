package com.example.telematica.uiappexample.Views;

import com.example.telematica.uiappexample.Activities.UIAdapter;
import com.example.telematica.uiappexample.models.Libro;

import org.json.JSONObject;

/**
 * Created by nicole on 15-01-2016.
 */
public interface UIView {

    public Libro manageUIObject(JSONObject objeto);

    public void manageUIItem(UIAdapter.ViewHolder holder, Libro libro);


}
