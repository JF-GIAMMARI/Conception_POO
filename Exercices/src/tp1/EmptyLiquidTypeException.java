package tp1;
/**
 * Class name : EmptyLiquidTypeException
 * Description : Une exception indiquant que le type de liquide présent dans une citerne n'est pas definis
 * @author Jean-François Giammari & Alexandre Motbal
 */

public class EmptyLiquidTypeException extends Exception {
    public EmptyLiquidTypeException () { super() ; }
    public EmptyLiquidTypeException (String s) { super(s) ; }
}
