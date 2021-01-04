package tp2_collections.exercice_4;

import java.util.Comparator;

public class MilitaryOrder implements Comparator<String>{
        @Override
        // Compare then the lenght and after the lexical
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            }
            return o1.compareTo(o2);
        }

}
