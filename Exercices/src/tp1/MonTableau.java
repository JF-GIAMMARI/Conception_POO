package tp1;

import java.util.stream.*;
/**
 * Class name : MonTableau
 * Description : Classe de l'exercice 1 du TP Heritage Interface Exception, c'est l'implémentation de l'interface "EstComparable"
 * @author Jean-François Giammari & Alexandre Motbal
 */

public class MonTableau implements EstComparable {
    int[] tab = {};

    /**
     * Compare an object with this objects
     * @param init_tab le Tableau a stocké
     */
    public MonTableau(int[] init_tab) {
        tab = init_tab;
    }
    public MonTableau() {this(new int[]{}); }

    /**
     * @return la somme des éléments du tableau stocké
     */
    public int getSum(){
        return IntStream.of(tab).sum();
    }

    /**
     * Compare le tableau avec un autre tableau
     * @param o l'objet "Mon Tableau" a comparer
     * @return Si o est > : 0, Si o est < :1, Si o est egale : 0
     */
    public int compareA(Object o) {
        int result = 0;
        if(o == null) throw new NullPointerException();
        if(!(o instanceof MonTableau)){throw new ClassCastException("Impossible de comparer les deux objets (Différence de Classe)");}else{
            MonTableau tab_ext = (MonTableau)o;
            int sum = this.getSum();
            int sum_o = tab_ext.getSum();
            if(sum < sum_o){ result = -1; } else if (sum > sum_o){ result = 1; }
        }
        return result;
    }


}
