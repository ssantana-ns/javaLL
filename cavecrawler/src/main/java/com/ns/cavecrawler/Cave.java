package com.ns.cavecrawler;

import java.util.Collection;
import java.util.HashMap;

public class Cave {
   
    private HashMap<String, Cave> connected_caves;
    public String value;
    public Boolean isStart;
    public Boolean isEnd;

    public Cave(String value) {
        this.connected_caves = new HashMap<String, Cave>();
        this.value = value;
        this.isStart = value == "start";
        this.isEnd = value == "end";
    }

    protected void addCave(Cave cave) {
        this.connected_caves.put(cave.value, cave);
    }

    public void connect(Cave cave) {
        this.addCave(cave);
        cave.addCave(cave);
    }

    public Boolean isConnected(Cave cave) {
        if (this.connected_caves.get(cave.value) != null) {
            return true;
        }
        return false;
    }

    public Collection<Cave> connectedCaves() {
        return this.connected_caves.values();
    }

}
