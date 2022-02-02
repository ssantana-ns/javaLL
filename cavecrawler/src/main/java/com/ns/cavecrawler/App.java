package com.ns.cavecrawler;


public class App 
{

    public static CaveSystem generateCaveSystem() {
        /*
        Generate a cave that looks like the following
                   start
                  /  |
                 b - a - c - d
                 |       |  /
                 e       f
                 \      /
                    end
        */
        String[][] cavePairings = new String[][] {
            {"start", "a"},
            {"start", "b"},
            {"a", "b"}, 
            {"a", "c"},
            {"c", "d"},
            {"c", "f"},
            {"d", "f"},
            {"b", "e"},
            {"e", "end"},
            {"f", "end"}
        };

        return CaveSystem.generateSystem(cavePairings);
    }
    public static void main( String[] args )
    {
        /*
        We have a cave system that needs exploring!

        The CaveSystem program should be able to find all paths from
        start to end for a given cave system while only visiting each cave once,
        however program is acting up. Can you help diagnose what is wrong?
       
        The rules of exploring are simple, the program finds the number of paths
        from "start" to "end" for the given system. Each cave (labeled with a letter)
        can only be visted once. For the sample cave system we expect X paths but we are not
        getting that number back!
        */
        CaveSystem caveSystem = App.generateCaveSystem();
        caveSystem.explore();
        System.out.println("There are " + caveSystem.cavePaths.size() + " paths in the cave system and there should be 6!" );
    }
}
