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
    }
}
