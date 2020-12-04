package tp1;
/**
 * Class name : TestCiterne
 * Description : Classe de test pour le TP
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class TestCiterne {
    public static void main(String[] args) {
        try{
            System.out.println("---------EX1----------");
            MonTableau m0 = new MonTableau(); // Test tableau vide
            MonTableau m1 = new MonTableau(new int[]{1, 2, 3, 4}); // Test tableau plein 1
            MonTableau m2 = new MonTableau(new int[]{-1, 2, -3, 4, 5}); // Test tableau plein 2
            System.out.println("Attendu : 1 --> "+m1.compareA(m2)); // Test m1 m2
            System.out.println("Attendu : 0 --> "+m1.compareA(m1)); // Test m1 m1
            System.out.println("Attendu : -1 --> "+m2.compareA(m1)); // Test m2 m1
            //System.out.println(m1.compareA(new int[]{1, 2, 3, 4})); // Test comparaison mauvais objet
        }catch (ClassCastException | NullPointerException e){
            e.printStackTrace();
        }

        Citerne c1 = null;
        Citerne c2 = null;
        Citerne c3= null;
        CiterneSecurisee cs1 = null;
        CiterneSecurisee cs2 = null;
        CiterneSecurisee cs3 = null;
        try {
            System.out.println("\n---------EX2----------");
            //c1 = new Citerne(2000000, Citerne.liquid_type.VINE); // Instanciation avec un mauvais argument
            c1 = new Citerne(200, Citerne.liquid_type.VINE);
            c2 = new Citerne(200, Citerne.liquid_type.VINE);
            c3 = new Citerne(300, Citerne.liquid_type.WATER);
        } catch (IllegalArgumentException | IllegalCapacityException e) { System.err.println(e); }


        try{ // Test Equals & ToString
            assert c1 != null || c2 != null || c3 != null;
            System.out.println(c1.equals(c2));
            System.out.println(c1.equals(c3));
            System.out.println(c1.plusAncienne(c2));
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
        }catch (Exception e){ e.printStackTrace(); }
        
        try{ // Test addLiquid
            assert c1 != null || c2 != null || c3 != null;
            Citerne c4 = new Citerne(200, Citerne.liquid_type.NONE);
            //c4.addLiquid(20); // Ajout sans liquide définis
            c1.addLiquid(20); // Ajout avec volume
            c2.addLiquid((float)0.7); // Ajout avec poucentage
            c3.addLiquid(300);
            //c3.addLiquid(10); // Ajout avec volume trop important
            System.out.println(c1.getContenu());
            System.out.println(c2.getContenu());
            System.out.println(c3.getContenu());
        } catch (MaxLiquidQuantityException | EmptyLiquidTypeException | IllegalCapacityException e) { e.printStackTrace(); }
        
        try{ // Test takeLiquid
            assert c1 != null || c2 != null || c3 != null;
            c1.takeLiquid(10); // Prendre avec volume
            c3.takeLiquid((float)0.4); // Prendre avec poucentage
            //c2.takeLiquid(500); // Prendre trops
            System.out.println(c1.getContenu());
            System.out.println(c2.getContenu());
            System.out.println(c3.getContenu());
        }catch (MinLiquidQuantityException e) { e.printStackTrace(); }


        try{ // Test changeLiquid & cleanCiterne
            assert c1 != null || c2 != null || c3 != null;
            System.out.println(c2.getContenu());
            //c2.changeLiquid(Citerne.liquid_type.WATER); //  Changement sans cleanCiterne
            c2.cleanCiterne(); // cleanCiterne
            c2.changeLiquid(Citerne.liquid_type.VINE); // Changement apres cleanCiterne
            System.out.println(c2.getContenu());
        }catch (IsNotCleanException e) { e.printStackTrace(); }

        try{ // Test compareA
            assert c1 != null || c2 != null || c3 != null;
            System.out.println(c1.compareA(c2)); // Test 1
            System.out.println(c2.compareA(c3)); // Test -1
            System.out.println(c1.compareA(c1)); // Test 0
        }catch (ClassCastException e) { e.printStackTrace(); }

        try {
            System.out.println("\n----- Citerne Sécurisée -----");
            cs1 = new CiterneSecurisee(200, Citerne.liquid_type.VINE, 50);
            cs2 = new CiterneSecurisee(200, Citerne.liquid_type.WATER); // Test par trop plein non définis
            cs3 = new CiterneSecurisee(200, Citerne.liquid_type.VINE, 50);

            System.out.println(cs1); // ToString
            System.out.println(cs2);
            System.out.println(cs3);
            cs3.changeTropPlein(200); // Change capacté trop plein
            System.out.println(cs3);

            System.out.println(cs1.compareA(cs2)); // Test 1
            System.out.println(cs2.compareA(cs1)); // Test -1
            System.out.println(cs1.compareA(cs3)); // Test 0

            System.out.println(cs1.equals(cs2)); // Test equals
            System.out.println(cs1.equals(cs3));

            //cs1.takeLiquid(50);
            cs1.addLiquid(50);
            assert(cs1.getQuantity() == 50.0):"Erreur sur la résultat attendu ";
            cs1.takeLiquid(20);
            assert(cs1.getQuantity() == 30.0):"Erreur sur la résultat attendu";
            cs1.addLiquid(170);
            assert(cs1.getQuantity() == 200.0):"Erreur sur la résultat attendu";
            cs1.addLiquid(20);
            assert(cs1.getQuantity() == 200.0 || cs1.getQuantityTP() != 20.0 ):"Erreur sur la résultat attendu";
            cs1.addLiquid(29);
            assert(cs1.getQuantity() == 200.0 || cs1.getQuantityTP() != 49.0 ):"Erreur sur la résultat attendu";
            cs1.addLiquid(1);
            assert(cs1.getQuantity() == 200.0 || cs1.getQuantityTP() != 50.0 ):"Erreur sur la résultat attendu";
            //cs1.addLiquid(20);
            assert(cs1.getQuantity() == 200.0 || cs1.getQuantityTP() != 50.0 ):"Erreur sur la résultat attendu";
            cs1.takeLiquid(60);
            assert(cs1.getQuantity() == 190.0 || cs1.getQuantityTP() != 0.0 ):"Erreur sur la résultat attendu";
            cs1.takeLiquid(60);
            assert(cs1.getQuantity() == 130.0 || cs1.getQuantityTP() != 0.0 ):"Erreur sur la résultat attendu";
            //cs1.addLiquid(160);
            //assert(cs1.getQuantity() == 200 || cs1.getQuantityTP() != 50 ):"Erreur sur la résultat attendu";

            // Test clonage profond
            CiterneSecurisee cs4 = (CiterneSecurisee) cs1.clone();
            System.out.println("CS4 : "+cs4.getContenu()); // Clonage
            System.out.println("CS1 : "+cs1.getContenu()); // Check Origine
            cs4.addLiquid(20); // Ajout sur la copie
            System.out.println("CS4 : "+cs4.getContenu()); // Check copie
            System.out.println("CS1 : "+cs1.getContenu()); // Check aucune modification origine
        } catch (IllegalArgumentException | IllegalCapacityException | IsNotCleanException | MaxLiquidQuantityException | EmptyLiquidTypeException | MinLiquidQuantityException | CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
