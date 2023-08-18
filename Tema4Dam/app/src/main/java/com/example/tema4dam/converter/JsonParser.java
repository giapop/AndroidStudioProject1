package com.example.tema4dam.converter;

import com.example.tema4dam.teste.TestCovid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static List<TestCovid> fromJson(String json){
        if(json==null||json.isEmpty()){
            return new ArrayList<>();
        }
        try {
            JSONArray array=new JSONArray(json);
            List<TestCovid> results=new ArrayList<>();
            for(int i=0;i<array.length();i++){
                JSONObject object=array.getJSONObject(i);
               JSONObject objTestament=object.getJSONObject("tratament");
               JSONObject objTest=objTestament.getJSONObject("testCovid");
               int cod=objTest.getInt("codTest");
               String tip=objTest.getString("tipTest");
               String rezultat=objTest.getString("rezultat");
               String vaccinat=objTest.getString("vaccinat");
               TestCovid testCovid=new TestCovid(cod,tip,rezultat,vaccinat);
               results.add(testCovid);
            }
            return results;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
