package utilities;

public class BrowserUtils {
    public static void Wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){ }

    }
}
