package CW2014;

import java.util.*;

public class LibraryData {

    private static class Item {

        Item(String n, String a, int r) {
            name = n;
            artist = a;
            rating = r;
        }
        
        private String name;
        private String artist;
        private int rating;
        private int playCount;

        public String toString() {
            return name + " - " + artist;
        }
    }

    private static Map<String, Item> library = new TreeMap<String, Item>();
    

    static {
        library.put("01", new Item("Seven", "David Fincher", 4));
        library.put("02", new Item("Pulp Fiction", "Quentin Tarintino", 4));
        library.put("03", new Item("The Conversation", "Francis Ford Coppola", 4));
        library.put("04", new Item("The Godfather", "Francis Ford Coppola", 5));
        library.put("05", new Item("The Matrix", "Andy Wachowski", 4));
        library.put("06", new Item("The Usual Suspects", "Bryan Singer", 4));
        library.put("07", new Item("Run Lola Run", "Tom Tykwer", 4));
        library.put("08", new Item("Snatch", "Guy Ritchie", 4));
        library.put("09", new Item("Lock, stock and two smoking barrels", "Guy Ritchie", 4));
        library.put("10", new Item("Fight Club", "David Fincher", 4));
        library.put("11", new Item("Goodfellas", "Martin Scorsese", 4));
        library.put("12", new Item("Leon", "Luc Besson", 4));
        library.put("13", new Item("Reservoir Dogs", "Quentin Tarantino", 4));
    }

    public static String listAll() {
        String output = "";
        Iterator iterator = library.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Item item = library.get(key);
            output += key + " " + item.name + " - " + item.artist + "\n";
        }
        return output;
    }
    
    public static void close() {
    }
}
