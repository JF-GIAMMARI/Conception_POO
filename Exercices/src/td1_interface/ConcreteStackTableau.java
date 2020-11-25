package td1_interface;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ConcreteStackTableau implements AStack {
    public static int maxSize = 5;
    private Object tab[] = new Object[maxSize];
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
   public void push(Object objet) throws FullStackException  {
        if (nbObjets>=maxSize) throw new FullStackException("La pile est pleine");
        else{
            tab[nbObjets]= objet;
            nbObjets++;
        }
    }


    @Override
    public Object peek() {
        Object result=null;
        if (isEmpty()) throw new EmptyStackException();
        int indice = this.nbObjets-1;
        result= tab[indice];


        return result;
    }

    @Override
    public Object pop() {
        Object result=null;
        if (isEmpty()) throw new EmptyStackException();
        int indice= this.nbObjets-1;
        tab[indice]=null;
        nbObjets+=-1;
        return result;
    }

    @Override
    public String toString() {
        return "ConcreteStackTableau{" +
                "tab=" + Arrays.toString(tab) +
                '}';
    }

    public static void main(String args[]){
        ConcreteStackTableau t = new ConcreteStackTableau();
        try{
            t.push(1);
            t.push(2);
            t.push(3);
            t.push(4);
            t.push(5);
            t.push(6);
        }catch(FullStackException e){
            System.err.println(e);

        }

        System.out.println(t.peek());
        t.pop();
        t.pop();
        t.pop();
        t.pop();
        t.pop();
        t.pop();
        t.pop();
        System.out.println(t.toString());
    }
}
