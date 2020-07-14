package utilities;

public class StringUtility {
    public static void verifyEqual(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");
        }
    }
}
