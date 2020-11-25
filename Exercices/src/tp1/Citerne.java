package tp1;

import java.time.LocalDate;


public class Citerne {
    enum liquid_type {NONE, WATER, VINE, OIL}
    static int nb_Citerne = 0;

    public final int id;
    public final LocalDate date;
    private final float capacity;
    private float quantity = 0;
    private liquid_type liquid;

    public Citerne(float capacity, liquid_type liquid) throws IllegalCapacityException {
        if (capacity < 1 || capacity > 20000) throw new IllegalCapacityException();
        nb_Citerne++;
        this.liquid = liquid;
        this.date = LocalDate.now();
        this.id = nb_Citerne;
        this.capacity = capacity;
    }

    public static int getNbCiterne() {
        return nb_Citerne;
    }

    public int plusAncienne(Object o) {
        int result = 0;
        if (o == null) throw new NullPointerException();
        if (o instanceof Citerne == false) {
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

    public liquid_type getLiquid() {
        return liquid;
    }

    private int getQuantityPourcentage(float poucentage, float reference) {
        if(poucentage < 0 || poucentage > 1) throw new IllegalArgumentException();
        return (int) ((poucentage * 100) * reference) / 100;
    }

    public void takeLiquid(float pourcentage) throws MinLiquidQuantityException {
        int volume = getQuantityPourcentage(pourcentage,quantity);
        takeLiquid(volume);
    }

    public void addLiquid(float pourcentage) throws EmptyLiquidTypeException, MaxLiquidQuantityException {
        int volume = getQuantityPourcentage(pourcentage,capacity);
        addLiquid(volume);
    }

    public void takeLiquid(int volume) throws MinLiquidQuantityException {
        if(volume <= 1) throw new IllegalArgumentException();
        quantity -= volume;
        if (quantity < 0) {
            float rest = -quantity;
            quantity = capacity;
            throw new MinLiquidQuantityException("Citerne N°"+id+" est vide : " + rest + "m2 restant sont manquant");
        }
    }

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

    public void cleanCiterne(){
        liquid = liquid_type.NONE;
        quantity = 0;
    }

    public void changeLiquid(liquid_type liquid) throws  IsNotCleanException {
        if(liquid != liquid_type.NONE && quantity != 0) throw new IsNotCleanException();
        this.liquid = liquid;
    }

    public String getContenu() {
        return "Type : " + liquid + " - " + quantity + " m2 - " + date;
    }

    @Override
    public String toString() {
        return "Citerne n°" + id + " | " + liquid + " - Capacité : " + capacity + " m2 - Mise en Service : " + date + " - Volume occupé : " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citerne c = (Citerne) o;
        return capacity == c.capacity && getLiquid() == c.getLiquid() && date.isEqual(c.date);
    }





    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{-1, 2, -3, 4, 5};
        MonTableau m1 = new MonTableau(a);
        MonTableau m2 = new MonTableau(b);
        System.out.println(m1.compareA(m2));
        System.out.println("-------------");
        try {
            Citerne c1 = new Citerne(200, liquid_type.VINE);
            Citerne c2 = new Citerne(200,liquid_type.VINE);
            Citerne c3 = new Citerne(300, liquid_type.WATER);
            c1.addLiquid(20);
            c2.addLiquid((float)0.7);
            c3.addLiquid(300);
            System.out.println(c1.equals(c2));
            System.out.println(c1.equals(c3));
            System.out.println(c1.plusAncienne(c2));
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            c1.takeLiquid(10);
            c2.cleanCiterne();
            c3.takeLiquid((float)0.4);
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            c2.changeLiquid(liquid_type.WATER);
            c1.cleanCiterne();
            c1.changeLiquid(liquid_type.VINE);
            System.out.println(c1.getContenu());


        } catch (Exception e) {
            System.err.println(e);
        }


    }

}
