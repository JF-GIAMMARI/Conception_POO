package tp2_collections;
import tp2_collections.exercice_1.GenPair;
import tp2_collections.exercice_2.AnagrammeDetector;
import tp2_collections.exercice_3.RList;
import tp2_collections.exercice_3.RSet;
import tp2_collections.exercice_4.SortAll;
import tp2_collections.exercice_5.Adresse;
import tp2_collections.exercice_5.Personne;


import java.io.File;
import java.util.*;

/**
 * Class name : Test
 * Description : Classe de test pour le TP2
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("\nEXERCICE 1 \n");
        List<GenPair<Integer, String>> PairTest = new ArrayList<GenPair<Integer, String>>();
        PairTest.add(new GenPair(7, "Mots"));
        PairTest.add(new GenPair(50, "Random"));
        PairTest.add(new GenPair(96, "Encyclopedie"));
        PairTest.add(new GenPair(74, "Exemple"));
        PairTest.add(new GenPair(832, "Collection"));

        for (int i = 0; i < PairTest.size(); i++) {
            System.out.println(PairTest.get(i).getObj1());
            System.out.println(PairTest.get(i).getObj2());
        }

        PairTest.get(1).setObj1(20);
        PairTest.get(1).setObj2("Test");
        System.out.println(PairTest.get(1).getObj1());
        System.out.println(PairTest.get(1).getObj2());

        System.out.println("\nEXERCICE 2 \n");
        //Dictionnaire réduis pour un temps de calcul acceptable (10s)
        AnagrammeDetector ad = new AnagrammeDetector("dictionnaire.txt", 2);
        System.out.println(ad.getAnagram());

        System.out.println("\nEXERCICE 3 \n");
        RList RL1 = new RList(10);
        RSet RS1 = new RSet(10);
        System.out.println(RL1.getCollection());
        System.out.println(RS1.getCollection());

        System.out.println("\nEXERCICE 4 \n");
        ArrayList<String> list = new ArrayList<String>();
        File file = new File("mots.txt");
        Scanner scanner = new Scanner(file);
        do {
            String currentLine = scanner.nextLine();
            list.add(currentLine);
        } while (scanner.hasNext());
        System.out.println("Original               : " + list);
        SortAll sortTest1 = new SortAll(list,"lexical");
        System.out.println("Sorted Lexical         : " + sortTest1.getSortedList());
        SortAll sortTest2 = new SortAll(list,"military");
        System.out.println("Sorted Military        : " + sortTest2.getSortedList());
        SortAll sortTest3 = new SortAll(list,"lexical_reverse");
        System.out.println("Sorted Lexical Reverse : " + sortTest3.getSortedList());


        System.out.println("\nEXERCICE 5 \n");
        ArrayList<Personne> arrayPersonne = new ArrayList<Personne>();
        Adresse Ad1 = new Adresse(20,"Allée des Jambons","20600","Bastia");
        arrayPersonne.add(new Personne("NOM1", "PRENOM 1 ",  new GregorianCalendar(2012,05,2), Ad1));
        arrayPersonne.add(new Personne("NOM2", "PRENOM 2",  new GregorianCalendar(2021,06,9), Ad1));
        arrayPersonne.add(new Personne("NOM3", "PRENOM 3",  new GregorianCalendar(2050,04,19), Ad1));
        arrayPersonne.add(new Personne("NOM4", "PRENOM 4",  new GregorianCalendar(2050,04,19), Ad1));
        for (int i = 0; i < arrayPersonne.size(); i++) {
            for (int j = 0; j < arrayPersonne.size(); j++) {
                System.out.println(arrayPersonne.get(i).getNom() + ".CompareTo(" + arrayPersonne.get(j).getNom() + ") : " + arrayPersonne.get(i).compareTo(arrayPersonne.get(j)) );
            }
        }
  }



}
