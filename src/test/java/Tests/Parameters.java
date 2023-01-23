package Tests;

import org.testng.annotations.Test;

public class Parameters {

    @Test
    @org.testng.annotations.Parameters({"myname"})
    public void test(String name){
        System.out.println("my name is" +name);
    }

}
