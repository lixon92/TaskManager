package ru.atkachev.tm;

/**
 * Hello world!
 *
 */

@WebService
public class App
{
    @WebMethod
    public Integer sum(
            @WebParam(name = "a")Integer a,
            @WebParam(name = "b")Integer b){
        return a + b;
    }
    public static void main( String[] args ){
        Endpoint.publish()
                длорлд
    }
}
