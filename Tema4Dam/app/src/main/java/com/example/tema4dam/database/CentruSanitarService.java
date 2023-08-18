package com.example.tema4dam.database;

import android.content.Context;

import com.example.tema4dam.centre.CentruSanitar;

import com.example.tema4dam.network.AsyncTaskRunner;
import com.example.tema4dam.network.Callback;

import java.util.concurrent.Callable;

public class CentruSanitarService {

    private final AsyncTaskRunner asyncTask;
    private final CentruSanitarDao centruSanitarDao;

    public CentruSanitarService(Context context){
        asyncTask=new AsyncTaskRunner();
        centruSanitarDao=DataBaseManager.getInstance(context).getCentruDao();
    }

    public void insert(CentruSanitar centruSanitar, Callback<CentruSanitar> insertActThread){
        Callable<CentruSanitar> insertOp=new Callable<CentruSanitar>() {
            @Override
            public CentruSanitar call() throws Exception {
                if(centruSanitar==null||centruSanitar.getId()<0){
                    return null;
                }
                long id=centruSanitarDao.insert(centruSanitar);
                if(id<0){
                    return null;
                }
                centruSanitar.setId(id);
                return centruSanitar;
            }
        };
        asyncTask.executeAsync(insertOp,insertActThread);
    }
}
