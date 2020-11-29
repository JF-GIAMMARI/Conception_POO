package tp1;
/**
 * Class name : MaxLiquidQuantityException
 * Description : Une exception indiquant que la capacité d'une citerne a atteint sont maximum
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class MaxLiquidQuantityException extends Exception{
    public MaxLiquidQuantityException () { super() ; }
    public MaxLiquidQuantityException (String s) { super(s) ; }
}
