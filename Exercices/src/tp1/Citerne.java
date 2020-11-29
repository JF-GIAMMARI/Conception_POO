package tp1;
import java.time.LocalDate;

/**
 * Class name : Citerne
 * Description : Classe qui permet de créer et gérer des citerne de liguide
 * @author Jean-François Giammari & Alexandre Motbal
 */


public class Citerne {
    enum liquid_type {NONE, WATER, VINE, OIL} // Liste des type de liquide utilisable
    static int nb_Citerne = 0; // Nombre de d'instance de Citerne
    public final int id; // ID de la citerne
    public final LocalDate date; // Date de création de la citerne
    private final float capacity; // Capacité maximal de la citerne

    private float quantity = 0; // Quantité de liquide présent dans la citerne
    private liquid_type liquid; // Liquide présent dans la citerne


    /** CONSTRUCTOR **/
    /**
     * Constructeur pour créer une Citerne
     * @param capacity : Capacité maximal
     * @param liquid : Type de liquide original
     */
    public Citerne(float capacity, liquid_type liquid) throws IllegalCapacityException {
        assert liquid != null;
        if (capacity < 1 || capacity > 20000) throw new IllegalCapacityException();
        nb_Citerne++;
        this.liquid = liquid;
        this.date = LocalDate.now();
        this.id = nb_Citerne;
        this.capacity = capacity;
    }


    /**
     * Getter pour le nombre d'instance de Citerne
     */
    public static int getNbCiterne() {
        return nb_Citerne;
    }

    /**
     * Fonction pour déterminé en fonction de la date (DD/MM/YY) la plus ancienne citerne
     * @param o : La citerne a comparer
     */
    public int plusAncienne(Object o) {
        int result = 0;
        if (o == null) throw new NullPointerException();
        if (!(o instanceof Citerne)) {
            throw new ClassCastException();
        } else {
            Citerne cit_ext = (Citerne) o;
            if (date.isAfter(cit_ext.date)) {
                result = cit_ext.id;
            } else if (cit_ext.date.isAfter(date)) {
                result = id;
            }
        }
        return result;

    }

    /**
     * Getter pour le type de liduide présent dans la Citerne
     */
    public liquid_type getLiquid() {
        return liquid;
    }

    /**
     * Détermine le volume correspondant a un pourcentage en fonction d'une référence
     * @param poucentage : Le pourcentage entre 0 et 1
     * @param reference : La référence du calcul (Quantité daja présente ou Capacité Maximum
     */
    private int setQuantityPourcentage(float poucentage, float reference) {
        if(poucentage < 0 || poucentage > 1) throw new IllegalArgumentException();
        return (int) ((poucentage * 100) * reference) / 100;
    }

    /**
     * takeLiquid prenant en entrer un volume
     * @param volume : Entier représentant le volume a retirer
     */
    public void takeLiquid(int volume) throws MinLiquidQuantityException {
        if(volume < 1) throw new IllegalArgumentException();
        quantity -= volume;
        if (quantity < 0) {
            float rest = -quantity;
            quantity = 0;
            throw new MinLiquidQuantityException("Citerne N°"+id+" est vide : " + rest + "m2 restant sont manquant");
        }
    }

    /**
     * addLiquid prenant en entrer un volume
     * @param volume : Entier représentant le volume a ajouter
     */
    public void addLiquid(int volume) throws EmptyLiquidTypeException, MaxLiquidQuantityException {
        if(volume <= 1) throw new IllegalArgumentException();
        if (liquid == liquid_type.NONE) throw new EmptyLiquidTypeException();
        quantity += volume;
        float rest = quantity - capacity ;
        if (rest > 0) {
            quantity = capacity;
            throw new MaxLiquidQuantityException("Citerne N°"+id+" pleine : " + rest + "m2 restant a déverser");
        }
    }
    /**
     * takeLiquid prenant en entrer un poucentage
     * @param pourcentage : Le pourcentage entre 0 et 1
     */
    public void takeLiquid(float pourcentage) throws MinLiquidQuantityException {
        int volume = setQuantityPourcentage(pourcentage,quantity);
        takeLiquid(volume);
    }
    /**
     * addLiquid prenant en entrer un poucentage
     * @param pourcentage : Le pourcentage entre 0 et 1
     */
    public void addLiquid(float pourcentage) throws EmptyLiquidTypeException, MaxLiquidQuantityException {
        int volume = setQuantityPourcentage(pourcentage,capacity);
        addLiquid(volume);
    }

    /**
     * Fonction vidant et nettoyant la citerne de sont ancien type de liquide
     */
    public void cleanCiterne(){
        liquid = liquid_type.NONE;
        quantity = 0;
    }

    /**
     * Change le liquide de la citerne
     * @param liquid : Le type de liquide a définir
     */
    public void changeLiquid(liquid_type liquid) throws  IsNotCleanException {
        if(liquid != liquid_type.NONE && quantity != 0) throw new IsNotCleanException();
        this.liquid = liquid;
    }

    /**
     * Permet d'afficher le contenu de la citerne (Liquide, Quantité, Date)
     */
    public String getContenu() {
        return "Type : " + liquid + " - " + quantity + " m2 - " + date;
    }

    @Override
    /**
     * Permet d'afficher les caractéristiques de la citerne
     */
    public String toString() {
        return "Citerne n°" + id + " | " + liquid + " - Capacité : " + capacity + " m2 - Mise en Service : " + date + " - Volume occupé : " + quantity;
    }

    @Override
    /**
     * Permet de vérifier l'égalité entre deux citerne (Liquide, Capacité, Date)
     * @return True si c'est égale, sinon False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citerne c = (Citerne) o;
        return capacity == c.capacity && getLiquid() == c.getLiquid() && date.isEqual(c.date);
    }






}
