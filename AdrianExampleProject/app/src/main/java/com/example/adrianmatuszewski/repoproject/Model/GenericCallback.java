package com.example.adrianmatuszewski.repoproject.Model;

/**
 * @author: Adrian Matuszewski
 */
public interface GenericCallback<T> {

    void onSuccess(T data);

    void onFailure(Exception error);
}
