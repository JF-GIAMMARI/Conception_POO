package tp2_collections.exercice_4;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class name : SortAll
 * Description : Classe l'exercice 4
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class SortAll {
    private String type = "";
    private ArrayList<String> originList;
    private ArrayList<String> sortedList;

    public SortAll(ArrayList<String> list, String type) {
        this.originList = list;
        this.type = type;
        switch (type.toUpperCase()){
            case "LEXICAL":
                sortedList = this.getLexical(list);
                break;
            case "MILITARY":
                sortedList = this.getMilitary(list);
                break;
            case "LEXICAL_REVERSE":
                sortedList = this.getLexicalReverse(list);
                break;

        }
    }

    private ArrayList<String> getLexical(ArrayList<String> list){
        ArrayList<String> sorted = new ArrayList<String>(list.size());
        for(String element : list){
            sorted.add(new String(element));
        }
        // Using a native method is more optimal than recreating it in this case.
        sorted.sort(Comparator.naturalOrder());
        return sorted;
    }

    private ArrayList<String> getMilitary(ArrayList<String> list){
        ArrayList<String> sorted = new ArrayList<String>(list.size());
        for(String element : list){
            sorted.add(new String(element));
        }
        sorted.sort(new MilitaryOrder());
        return sorted;
    }

    private ArrayList<String> getLexicalReverse(ArrayList<String> list){
        ArrayList<String> sorted = new ArrayList<String>(list.size());
        for(String element : list){
            sorted.add(new String(element));
        }
        // Using a native method is more optimal than recreating it in this case.
        sorted.sort(Comparator.reverseOrder());
        return sorted;
    }

    public ArrayList<String> getSortedList(){
        return this.sortedList;
    }

    public ArrayList<String> getOriginList(){
        return this.originList;
    }
}
