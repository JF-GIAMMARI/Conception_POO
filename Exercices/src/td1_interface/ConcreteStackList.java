package td1_interface;

import java.util.ArrayList;

public class ConcreteStackList implements AStack {

    ArrayList list = new ArrayList();

    @Override
    public boolean isEmpty() {
        boolean result = false;
        if(list.size() == 0){
            result = true;
        }
        return result;
    }

    @Override
    public void push(Object objet) {
        list.add(objet);
        return;
    }



    @Override
    public Object peek() {
        return list.indexOf(list.size());
    }

    @Override
    public Object pop() {
        Object result = peek();
        list.remove(list.size()-1);
        return result ;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String args[]){
        ConcreteStackList carotte = new ConcreteStackList();

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
        carotte.pop();
        System.out.println(carotte.toString());
    }
}
