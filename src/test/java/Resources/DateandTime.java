package Resources;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * The type Dateand time.
 */
public class DateandTime {

    /**
     * Add date time string.
     *
     * @return the string
     */
    public static String addDateTime(){

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                .format(new Timestamp(System.currentTimeMillis()));

       return timeStamp;
    }

}
