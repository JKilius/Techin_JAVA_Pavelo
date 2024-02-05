package utils;

import java.util.Date;

public class TestUtils {

    public static String emailGenerateByTime(){
        long timeMillSeconds = new Date().getTime();
        return "user"+timeMillSeconds+"@email.com";
    }
}
