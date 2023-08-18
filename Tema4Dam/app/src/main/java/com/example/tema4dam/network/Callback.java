package com.example.tema4dam.network;

public interface Callback<R> {

    void runResultOnUiThread(R result);
}
