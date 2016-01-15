package com.example.telematica.uiappexample.Presenters;

import android.app.Activity;
import android.location.LocationManager;

import com.example.telematica.uiappexample.Presenters.contract.IUPresenter;
import com.example.telematica.uiappexample.Activities.UIAdapter;
import com.example.telematica.uiappexample.Views.UIView;
import com.example.telematica.uiappexample.models.Libro;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicole on 15-01-2016.
 */
public class UIPresenterImpl implements IUPresenter, UIView {

    private Activity mContext;
    private UIView mLocationView;


    // private final String GPS = LocationManager.GPS_PROVIDER;
    //private final String NET = LocationManager.NETWORK_PROVIDER;
    //private static final long minTime = 10000;
    //private static final float minDistance = 200;

    public UIPresenterImpl(Activity mContext) {
        // public UIPresenterImpl(Activity mContext, UIView mLocationView) {
        this.mContext = mContext;
        //this.mLocationView = mLocationView;
    }

    @Override
    public List<Libro> getLista(String result) {
        List<Libro> listaLibros = new ArrayList<Libro>();
        try {
            JSONArray lista = new JSONArray(result);

            int size = lista.length();
            for (int i = 0; i < size; i++) {
                Libro libro = new Libro();
                JSONObject objeto = lista.getJSONObject(i);
                libro = manageUIObject(objeto);
                listaLibros.add(libro);
            }
            return listaLibros;
        } catch (JSONException e) {
            e.printStackTrace();
            return listaLibros;
        }
    }


    @Override
    public Libro manageUIObject(JSONObject objeto) {
        Libro libro = new Libro();
        try {
            libro.setId(objeto.getInt("id"));
            libro.setNombre(objeto.getString("nombre"));
            libro.setEditorial(objeto.getString("editorial"));
            libro.setGenero(objeto.getString("genero"));
            libro.setAutor(objeto.getInt("autor"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return libro;
    }

    @Override
    public void manageUIItem(UIAdapter.ViewHolder holder, Libro libro) {

        holder.mGeneroView.setText(libro.getGenero());
        holder.mTextView.setText(libro.getGenero());

    }


}
