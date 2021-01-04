package tp2_collections.exercice_3;

import java.util.*;

/**
 * Class name : RList
 * Description : Classe l'exercice 3
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class RList {
    private static final int MAX = 1000;

    private static Random random = new Random();
    private java.util.List<Integer> collection = new ArrayList<Integer>();

    public RList(int n) {
        genCollection(n);
    }

    /**
     * Genere une collection de nombre random entre 0 et MAX puis la trie
     * @param iterations
     */
    private void genCollection(int iterations) {
        for (int i = 0; i < iterations; i++) {
            this.collection.add(RList.random.nextInt(RList.MAX));
        }
        Collections.sort(this.collection);
    }

    /** Getter for collection **/
    public java.util.List<Integer> getCollection() {
        return this.collection;
    }
}
