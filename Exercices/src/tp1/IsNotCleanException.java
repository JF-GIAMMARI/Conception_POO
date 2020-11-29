package tp1;
/**
 * Class name : IsNotCleanException
 * Description : Une exception indiquant que la citerne n'a pas été purgée
 * @author Jean-François Giammari & Alexandre Motbal
 */
public class IsNotCleanException extends  Exception {
    public IsNotCleanException () { super() ; }
    public IsNotCleanException (String s) { super(s) ; }
}
