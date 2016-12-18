package com.bolnizar.notfollowingback.base;

/**
 * Created by Musafir on 12/18/2016.
 */

public abstract class Presenter<T> {
    private T mView;

    protected T getView() {
        return mView;
    }

    public Presenter(T view) {
        mView = view;
    }
}

