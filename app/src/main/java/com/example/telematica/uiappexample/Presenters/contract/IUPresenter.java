package com.example.telematica.uiappexample.Presenters.contract;

import com.example.telematica.uiappexample.models.Libro;

import java.util.List;

/**
 * Created by nicole on 15-01-2016.
 */
public interface IUPresenter {


    public List<Libro> getLista(String resultado);

}
