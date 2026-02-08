package com.mazdak;

import java.util.ArrayList;

public class HistoryService {
    private static ArrayList<String> history = new ArrayList<>();
    public void add(String item){
        history.add(item);
    }
    public void show(){
        if (history.isEmpty())
            throw new InvalidOperationException("History is empty; there is nothing to display.");
        int i=1;
        for (String item:history){
            System.out.printf("%3d) %s%n",i,item);
            i++;
        }
    }
    public void clear(){
        history.clear();
        System.out.println("History completely cleared.");
    }
}
