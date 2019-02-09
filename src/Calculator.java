import org.mariuszgromada.math.mxparser.Expression;

public class Calculator {

    public static void calc(){
        Expression x = new Expression("1 / 6");
        System.out.println(x.calculate());
    }
}
