package com.ns.cavecrawler;

import java.util.HashSet;
import java.util.LinkedList;

public class Path {

    private LinkedList<Cave> cavePath;
    private HashSet<String> caveValues;

    public Path () {
        this.cavePath = new LinkedList<Cave>();
        this.caveValues = new HashSet<String>();
    }

    @SuppressWarnings({"unchecked"})
    public Path(Path path) {
        this.cavePath = (LinkedList<Cave>) path.cavePath.clone();
        this.caveValues = new HashSet<String>();
        for (Cave cave: this.cavePath) {
            this.caveValues.add(cave.value);
        }
    }

    public Path addCave(Cave cave) {
        Path newPath = new Path(this);
        newPath.cavePath.add(cave);
        newPath.caveValues.add(cave.value);
        return newPath;
    }

    public Boolean caveVisited(Cave cave) {
        if (this.caveValues.contains(cave.value)) {
            return true;
        }
        return false;
    } 
    
}
