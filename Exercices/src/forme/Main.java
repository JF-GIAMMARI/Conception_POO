package forme;
import forme.Forme2D.Cercle;
import forme.Forme2D.Ellipse;
import forme.Forme2D.Rectangle;
import forme.Forme3D.Cylindre;
import forme.Forme3D.Sphere;

import java.util.ArrayList;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> formesList = new ArrayList<Object>();

        Ellipse Ellipse1= new Ellipse("Mon Ellipse 1",6,7);
        Ellipse Ellipse2= new Ellipse(4,5);
        formesList.add(Ellipse1);
        formesList.add(Ellipse2);

        Cercle Cercle1= new Cercle("Mon Cercle 1",6);
        Cercle Cercle2= new Cercle(4);
        formesList.add(Cercle1);
        formesList.add(Cercle2);

        Rectangle Rectangle1= new Rectangle("Mon Rectangle 1",6,7);
        Rectangle Rectangle2= new Rectangle(4,5);
        formesList.add(Rectangle1);
        formesList.add(Rectangle2);

        Sphere Sphere1= new Sphere("Ma Sphere 1",6);
        Sphere Sphere2= new Sphere(4);
        formesList.add(Sphere1);
        formesList.add(Sphere2);

        Cylindre Cylindre1= new Cylindre("Mon Cylindre 1",6, 10);
        Cylindre Cylindre2= new Cylindre(4, 10);
        formesList.add(Cylindre1);
        formesList.add(Cylindre2);

        for (int i = 0; i < formesList.size()-1 ; i+=2) {
            out.println(formesList.get(i));
            out.println(formesList.get(i+1));
            out.println(formesList.get(i).equals(formesList.get(i+1))); // false
        }
        formesList.clear();


    }
}
