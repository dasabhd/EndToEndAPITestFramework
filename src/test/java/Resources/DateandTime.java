package Resources;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateandTime {

    public static String addDateTime(){

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                .format(new Timestamp(System.currentTimeMillis()));

       return timeStamp;
    }

}
