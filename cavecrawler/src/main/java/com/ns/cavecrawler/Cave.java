package com.ns.cavecrawler;

import java.util.ArrayList;
import java.util.HashMap;

public class Cave {
   
    private HashMap<String, Cave> connectedCaves;
    public String value;
    public Boolean isStart;
    public Boolean isEnd;

    public Cave(String value) {
        this.connectedCaves = new HashMap<String, Cave>();
        this.value = value;
        this.isStart = value == "start";
        this.isEnd = value == "end";
    }

    protected void addCave(Cave cave) {
        this.connectedCaves.put(cave.value, cave);
    }

    public void connect(Cave cave) {
        this.addCave(cave);
        cave.addCave(cave);
    }

    public Boolean isConnected(Cave cave) {
        if (this.connectedCaves.get(cave.value) != null) {
            return true;
        }
        return false;
    }

    public ArrayList<Cave> adjacentCaves() {
        return new ArrayList<Cave>(this.connectedCaves.values());
    }

}
