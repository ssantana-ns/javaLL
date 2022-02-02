package com.ns.cavecrawler;

import java.util.HashMap;
import java.util.HashSet;

public class CaveSystem {

    private Cave startCave;
    public HashSet<Path> cavePaths;
    
    public CaveSystem(Cave cave) {
        this.startCave = cave;
        this.cavePaths = new HashSet<Path>();
    }

    private void findPaths(Cave cave, Path path) {
        if (path.caveVisited(cave)) {
            return;
        }

        Path newPath = path.addCave(cave);
        if (cave.isEnd) {
            this.cavePaths.add(newPath);
            return;
        }

        for (Cave connectedCave: cave.adjacentCaves()) {
            this.findPaths(connectedCave, newPath);
        }
    }

    public void explore() {
        this.findPaths(this.startCave, new Path());
    }

    public static CaveSystem generateSystem(String[][] caveArray) {
        HashMap<String, Cave> caveMappings = new HashMap<String, Cave>();
        for (String[] cavePair: caveArray) {
            String fromValue = cavePair[0];
            String toValue = cavePair[1];

            Cave fromCave = caveMappings.get(fromValue);
            if (fromCave == null) {
                fromCave = new Cave(fromValue);
                caveMappings.put(fromValue, fromCave);
            }
            Cave toCave = caveMappings.get(toValue);
            if (toCave == null) {
                toCave = new Cave(toValue);
                caveMappings.put(toValue, toCave);
            }

            fromCave.addCave(toCave);
        }

        return new CaveSystem(caveMappings.get("start"));

    }

}
