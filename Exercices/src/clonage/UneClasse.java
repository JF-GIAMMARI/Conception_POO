package clonage;

public class UneClasse implements Cloneable {

    public UneClasse() {

    }

    public Object clone(){
        Object o = null;
        try{
             o = super.clone();
        }catch (CloneNotSupportedException e){
            throw  new InternalError();
        }
        return o;
    }
}
