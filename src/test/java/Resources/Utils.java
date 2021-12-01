package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

/**
 * The type Utils.
 */
public class Utils {

    /**
     * Headers request specification.
     *
     * @return the request specification
     * @throws IOException the io exception
     */
    public RequestSpecification headers() throws IOException {

        PrintStream log = new PrintStream(new FileOutputStream("C:\\Users\\dasab\\IdeaProjects\\LibraryAPIFramework\\Logs\\logging_"+DateandTime.addDateTime()+".txt"));

        RequestSpecification req = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setBaseUri(GetGlobalProperties("baseUrl")).build();

        return req;
    }

    /**
     * Get global properties string.
     *
     * @param param the param
     * @return the string
     * @throws IOException the io exception
     */
    public String GetGlobalProperties(String param) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\U" +
                "sers\\dasab\\IdeaProjects\\LibraryAPIFramework\\src\\test\\java\\Resources\\Global.properties");
        prop.load(fis);

        return prop.getProperty(param);
    }

}
