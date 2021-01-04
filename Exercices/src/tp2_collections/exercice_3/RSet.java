package tp2_collections.exercice_3;

import java.util.*;
/**
 * Class name : RSet
 * Description : Classe l'exercice 3
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class RSet {
    private static final int MAX = 1000;

    private static Random random = new Random();
    private java.util.Set<Integer> collection = new TreeSet<Integer>();
    
    public RSet(int n) {
        genCollection(n);
    }

    /**
     * Genere une collection trier de nombre random entre 0 et MAX
     * @param iterations
     */
    private void genCollection(int iterations){
        for(int i = 0; i < iterations; i++) {
            this.collection.add(RSet.random.nextInt(RSet.MAX));
        }
    }

    /**
     * Getter for collection
     **/
    public java.util.Set<Integer> getCollection() { return this.collection; }
}