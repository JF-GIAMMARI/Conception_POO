package tp2_collections.exercice_1;

/**
 * Class name : GenPair
 * Description : Classe l'exercice 1
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class GenPair<U, L> {
    private U obj1;
    private L obj2;

    /**
     * Contructor with 2 generic objects
     **/
    public GenPair(U obj1, L obj2) {
        this.setObj1(obj1);
        this.setObj2(obj2);
    }

    /**
     * Setter for Obj1
     **/
    public void setObj1(U el1) {
        this.obj1 = el1;
    }

    /**
     * Setter for Obj2
     **/
    public void setObj2(L el2) {
        this.obj2 = el2;
    }

    /**
     * Getter for Obj1
     **/
    public U getObj1() {
        return this.obj1;
    }

    /**
     * Getter for Obj2
     **/
    public L getObj2() {
        return this.obj2;
    }
}