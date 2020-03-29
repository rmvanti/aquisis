package br.com.rmvanti.aquisis.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rmvanti
 */
public class Context {

    private static Context instance;
    private final Map values;
    
    private Context(){
        this.values = new HashMap();
    }
    
    public static final Context getInstance(){
        if(instance == null){
            instance = new Context();
        }
        return instance;
    }
    
    public void add(Object obj, String key){
        values.put(key, obj);
    }
    
    public Object getValue(String key){
        return values.get(key);
    }
    
    public String[] getKeys(){
        return (String[])this.values.keySet().toArray();
    }
    
}//end class
