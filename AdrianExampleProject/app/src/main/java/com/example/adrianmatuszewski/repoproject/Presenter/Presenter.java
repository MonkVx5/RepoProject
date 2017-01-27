package com.example.adrianmatuszewski.repoproject.Presenter;


import com.example.adrianmatuszewski.repoproject.View.BaseView;

/**
 * @author: Adrian Matuszewski
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
public abstract class Presenter<T extends BaseView> {

    protected T mView;

    public void setView(T view) {
        mView = view;
    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    abstract void resume();
    
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    abstract void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    abstract void destroy();

    abstract void finish();

}
