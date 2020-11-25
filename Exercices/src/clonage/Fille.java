package clonage;

public class Fille extends Mere{

    private UneClasse unObjetSensible;
    public Fille(int unI, UneClasse unObj, UneClasse unObjSens){
        super(unI,unObj);
        unObjetSensible = unObjSens;
    }


    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}