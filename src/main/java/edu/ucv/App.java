package edu.ucv;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Date date = new Date(34,8,1972);
        if(date.validate()){
            System.out.println( "Fecha valida" );
        } else {
            System.out.println( "Fecha invalida" );
        }

        Interval interval = new Interval(new FromEndPoint(4.4, true), new UntilEndPoint(5.6, false));
        System.out.println( "interval length: " + interval.length());
    }
}
