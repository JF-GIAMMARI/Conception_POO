package tp2_collections.exercice_2;

import java.util.*;
import java.io.*;

/**
 * Class name : AnagrammeDetector
 * Description : Classe l'exercice 2
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class AnagrammeDetector {
    private int limit;
    private ArrayList<String> list = new ArrayList<String>();
    private Map<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();

    public AnagrammeDetector(String filename, int limit) {
        this.readFile(filename);
        this.limit = limit;
    }

    private void readFile(String filename) {
        try {
            // Open the file
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            do {
                // Add all the file in a Arraylist
                String currentLine = scanner.nextLine();
                list.add(currentLine);
            } while (scanner.hasNext());
            // For eah word, we test if is anagram for all other
            for (int i = 0; i < list.size(); i++) {
                ArrayList<String> anagram = new ArrayList<String>();
                for (int j = 0; j < list.size(); j++) {
                    if(i != j){
                        Boolean currentTest = isAnagramme(list.get(i), list.get(j));
                        if(currentTest){ // If word is an anagram we add to arraylist
                            anagram.add(list.get(j));
                        }
                    }
                }
                if(anagram.size() > limit){ // If the anagram number is mor than he limit, we ut the list in the map.
                    anagram.add(list.get(i));
                    map.put(i,anagram);
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println(filename + " not found");
        }
    }

    public Map<Integer, ArrayList<String>> getAnagram() {
        return this.map;
    }

    public static boolean isAnagramme(final String WordToTest1,final String WordToTest2) {
        String w1 = WordToTest1.replaceAll("\\s", "");
        String w2 = WordToTest2.replaceAll("\\s", "");
        boolean result = true;
        if (w1.length() != w2.length()) {
            result = false;
        } else {
            // Trie du mot pour comparer la chaine.
            char[] ArrayS1 = w1.toLowerCase().toCharArray();
            char[] ArrayS2 = w2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            result = Arrays.equals(ArrayS1, ArrayS2);
        }
        return result;
    }
}
