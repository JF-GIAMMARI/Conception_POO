package tp1;

import clonage.Mere;
import clonage.UneClasse;

public class CiterneSecurisee extends Citerne implements Cloneable{
    private float capacityTP; // Capacité maximal du trop plein
    private float quantityTP = 0; // Quantité de liquide présent dans le trop plein
    public final int DEFAULTCAPACITY = 10; // Quantité du trop plein par défaut en pourcent
    
    /**
     * Constructeur pour créer une Citerne Sécurisée
     * @param capacity : Capacité maximal
     * @param liquid   : Type de liquide original
     * @param capacityTP : Capacité maximal du trop plein
     */
    public CiterneSecurisee(float capacity, liquid_type liquid, float capacityTP) throws IllegalCapacityException {
        super(capacity, liquid);
        if (capacityTP < MINLIQUIDCAPACITY || capacityTP > MAXLIQUIDCAPACITY){
            capacityTP = getCapacity()*DEFAULTCAPACITY/100;
        }
        this.capacityTP = capacityTP;
    }
    public CiterneSecurisee(float capacity, liquid_type liquid) throws IllegalCapacityException {
        this(capacity,liquid,0);
    }

    /**
     * Getter pour la capacité maximum du trop plein
     */
    public float getCapacityTP() {
        return capacityTP;
    }

    /**
     * Getter pour la quantitée présente dans le trop plein
     */
    public float getQuantityTP() {
        return quantityTP;
    }


    /**
     * takeLiquid prenant en entrer un volume
     * @param volume : Entier représentant le volume a retirer
     */
    public void takeLiquid(int volume) throws MinLiquidQuantityException {
        if(volume <= 0) throw new IllegalArgumentException();
        float rest = quantityTP-volume;
        if(rest < 0){
            super.takeLiquid((int)-rest);
            quantityTP = 0;
        }else{ quantityTP -= volume; }
    }

    /**
     * addLiquid prenant en entrer un volume prenant en compte le trop plein
     * @param volume : Entier représentant le volume a ajouter
     */
    public void addLiquid(int volume) throws EmptyLiquidTypeException, MaxLiquidQuantityException {
        if(volume <= 0) throw new IllegalArgumentException();
        int rest = (int) (getQuantity() + volume);
        if(rest > getCapacity()){
            rest -= getQuantity();
            int InCiterne = (int) (getCapacity()-getQuantity());
            if(InCiterne <0){
                super.addLiquid(InCiterne);
            }
            rest -= InCiterne;
            quantityTP +=rest;
            if(quantityTP > capacityTP){
                int exces = (int) (quantityTP-capacityTP);
                quantityTP = capacityTP;
                throw new MaxLiquidQuantityException("Le trop plein est plein : " + exces + "m3 restant a déverser");

            }
        }else{
            super.addLiquid((int)volume);
        }
        checkAlert();
    }

    /**
     * Compare une citerne a une autre citerne en fonction d'abord e la quantité, et si nécessaire, la capacité
     * @param o l'objet Citerne a comparer
     * @return Si o est > : 0, Si o est < :1, Si o est egale : 0
     */
    public int compareA(Object o) {
        int result = 0;
        if(o == null) throw new NullPointerException();
        if(!(o instanceof CiterneSecurisee)){throw new ClassCastException("Impossible de comparer les deux objets (Différence de Classe)");}else {
            CiterneSecurisee citerne_ext = (CiterneSecurisee) o;
            if (getQuantity()+quantityTP < citerne_ext.getQuantity()+citerne_ext.quantityTP) {
                result = -1;
            } else if (getQuantity()+quantityTP > citerne_ext.getQuantity()+citerne_ext.quantityTP) {
                result = 1;
            }else{
                if(getCapacity()+capacityTP < citerne_ext.getCapacity()+citerne_ext.capacityTP){
                    result = -1;
                } else if (getCapacity()+capacityTP > citerne_ext.getCapacity()+citerne_ext.capacityTP){
                    result = 1;
                }
            }
        }
        return result;
    }

    /**
     * Vérifie les états d'alerte
     */
    private void checkAlert(){
        if(getQuantity() >= getCapacity()){System.err.println("Attention : La citerne est pleine, le trop plein est remplis avec " +quantityTP+" m3");}
        if(quantityTP >= capacityTP/2 && quantityTP != capacityTP){System.err.println("Attention : Le trop plein est remplis a plus de 50%  ("+quantityTP+"m3)");}
        if(quantityTP == capacityTP){System.err.println("Attention : Le trop plein est.. plein");}
    }

    /**
     * Fonction vidant et nettoyant la citerne et le trop plein de sont ancien type de liquide
     */
    public void cleanCiterne(){
        super.cleanCiterne();
        quantityTP = 0;
    }

    /**
     * Change le liquide de la citerne et du trop plein
     * @param liquid : Le type de liquide a définir
     */
    public void changeLiquid(liquid_type liquid) throws  IsNotCleanException {
        if(quantityTP != 0) throw new IsNotCleanException();
        super.changeLiquid(liquid);
    }

    /**
     * Change la capacité du trop plein si il est nettoyé
     * @param new_capacity : Le nouveau volume
     */
    public void changeTropPlein(int new_capacity) throws IsNotCleanException, MaxLiquidQuantityException {
        if(quantityTP != 0) throw new IsNotCleanException();
        if(new_capacity > MAXLIQUIDCAPACITY) throw new MaxLiquidQuantityException();
        capacityTP = new_capacity;
    }

    /**
     * Permet d'afficher le contenu de la citerne et du trop plein (Liquide, Quantité, Date)
     */
    public String getContenu() {
        return super.getContenu()+ " - Quantité du trop plein " + quantityTP + " m3";
    }

    /**
     * Permet d'afficher les caractéristiques de la citerne sécurisée
     */
    @Override
    public String toString() {
        return super.toString() + " - Capacité du trop plein : " + capacityTP + " - Volume occupé du trop plein : " + quantityTP;
    }

    /**
     * Permet de vérifier l'égalité entre deux citerne (Liquide, Capacité, Date)
     * @return True si c'est égale, sinon False
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiterneSecurisee c = (CiterneSecurisee) o;
        return super.equals(o) && quantityTP == c.quantityTP && capacityTP == c.capacityTP;
    }

    /**
     * Clonage profond de CiterneSecurisée
     * @return Copie
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        CiterneSecurisee c = null;
        try{
            c = (CiterneSecurisee) super.clone();
            c.quantityTP  = getQuantityTP();
            c.capacityTP = getCapacityTP();

        }catch(CloneNotSupportedException e){
            throw  new InternalError();
        }
        return c;
    }


}
