package com.example.com.hola.testapp.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;

import com.example.com.hola.testapp.ShareIntentActivity;
import com.example.com.hola.testapp.SplashActivity;
import com.example.com.hola.testapp.ToastActivity;

public class DummyContent {

    public static class DummyItem {

        public String id;
        public String content;
        public Class<?> activity_class;
        
        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;            
        }
        public DummyItem(String id, String content, Class<?> act_class) {
            this.id = id;
            this.content = content;            
            this.activity_class = act_class;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        addItem(new DummyItem("1", "Item 1"));
        addItem(new DummyItem("4", "Toast/Dialog Example", ToastActivity.class));
        addItem(new DummyItem("5", "Share Intent Example", ShareIntentActivity.class));
        addItem(new DummyItem("6", "SplashScreen Example", SplashActivity.class));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
}
