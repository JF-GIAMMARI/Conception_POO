package td1_interface;
import java.util.Arrays;

public class ConcreteStackTableau implements AStack {

    //pas besoin nbObjets --> tab.lenght
    private Object tab[] = new Object[10];
    private int nbObjets =0 ;

    public ConcreteStackTableau(){
            }

    @Override
    public boolean isEmpty() {
        boolean bool = false;
        if(this.tab.length==0){
            bool = true;
        }
        else{
            bool = false;
        }
        return bool;
    }

    @Override
   public void push(Object objet) {
        System.out.println(nbObjets);
        if(nbObjets<10){
        tab[nbObjets]= objet;
        nbObjets++;}
       else{
           System.err.println("trop d'objets");
        }
    }



    @Override
    public Object peek() {
        Object result=null;
        if(this.isEmpty()==false){
            int indice= this.nbObjets-1;
            result= tab[indice];
        }
        return result;
    }

    @Override
    public Object pop() {
        Object result=null;
        if(this.isEmpty()==false){
            int indice= this.nbObjets-1;
            tab[indice]=null;
            nbObjets+=-1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "ConcreteStackTableau{" +
                "tab=" + Arrays.toString(tab) +
                '}';
    }

    public static void main(String args[]){
        ConcreteStackTableau carotte = new ConcreteStackTableau();

        System.out.println(carotte.toString());
        carotte.push(1);
        carotte.push(2);
        carotte.push(3);
        carotte.push(4);
        carotte.push(5);
        carotte.push(6);
        carotte.push(7);
        carotte.push(8);
        carotte.push(9);
        carotte.push(10);
        carotte.push(11);



        System.out.println(carotte.peek());
       // carotte.pop();
        System.out.println(carotte.toString());
    }
}
