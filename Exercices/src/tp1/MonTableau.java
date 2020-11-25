package tp1;
import java.util.stream.*;
public class MonTableau implements EstComparable {
    int[] tab = {};

    public MonTableau(int[] init_tab) {
        tab = init_tab;
    }

    /**
     * @return the sum of tab.
     */
    public int getSum(){
        return IntStream.of(tab).sum();
    }

    /**
     * Compare an object with this objects
     * @param o the object to compare with this object
     * @return -1 if o is > , 1 if is < and 0 if egal.
     */
    public int compareA(Object o) {
        int result = 0;
        // Check if o is not null or is not an instance of "Mon Tableau"
        if(o == null) throw new NullPointerException();
        if(o instanceof MonTableau == false){throw new ClassCastException();}else{
            MonTableau tab_ext = (MonTableau)o;
            int sum = this.getSum();
            int sum_o = tab_ext.getSum();
            if(sum < sum_o){ result = -1; } else if (sum > sum_o){ result = 1; }
        }
        return result;
    }
}
