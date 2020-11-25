package clonage;

public class Mere implements Cloneable{
    private int i;
    private UneClasse unObjet;
    public Mere(int unI, UneClasse unObj){
        i = unI; unObjet = unObj;
    }


    public Object clone() throws CloneNotSupportedException {
        Mere s = null;
        try{
            s = (Mere) super.clone();
            s.i  = i;
            s.unObjet = (UneClasse)unObjet.clone();

        }catch(CloneNotSupportedException e){
            throw  new InternalError();
        }
        return s;
    }
}
