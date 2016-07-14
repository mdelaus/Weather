package weather;
import java.net.*;
import java.io.*;

public class Browser {
    public static void getWeather() throws Exception{
        System.out.println("Getting weather...");
        URL oracle = new URL("http://www.weather-forecast.com/locations/boston/forecasts/latest");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
