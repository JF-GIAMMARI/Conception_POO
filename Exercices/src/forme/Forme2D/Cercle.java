package forme.Forme2D;

import forme.Bases.Forme2D;

/**
 * Class name : Cercle
 * Description : Class for an Ellipses
 * @author Jean-François Giammari
 */
public class Cercle extends Forme2D {
    protected double r = 0;

    /** CONSTRUCTOR **/
    /**
     * Full content constructor
     * @param r - Rayon
     * @param name - Name + n°
     */
    public Cercle(String name, double r) {
        super(name);
        if (r < 0) r = 0;
        this.r = r;
    }

    public Cercle( double r) {
        this("", r);
    }
    /** METHODS **/
    /**
     * return the surface of the shape
     */
    public double surface(){
        return Math.PI*Math.pow(r, 2);
    }

    /**
     * return the perimetre of the shape
     */
    public double perimetre(){
        return 2*Math.PI*r;
    }

    /**
     * @return a String that describe the shape
     */
    @Override
    public String toString() {
        return super.toString() + "\n* Rayon : "+ r;
    }

}
