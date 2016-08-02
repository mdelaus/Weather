package weather;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Browser {
    public static void getWeather() throws Exception{
        
        System.out.println("Getting weather...");
        
        //Scanner to read city input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a city: ");
        String city = scanner.next();
        
        //fetch the weather for a given city
        URL oracle = new URL("http://www.weather-forecast.com/locations/"+ city + "/forecasts/latest");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        
        //Formats the weather forcast
        String forcast = null;
        String inputLine;
        String replaced = null;
        while ((inputLine = in.readLine()) != null) {
            //System.out.println(inputLine);
            
            //Pulls the forcast from the websites HTML
            if (inputLine.contains("<span class=\"phrase\">")) {
                String[] split = inputLine.split("<span class=\"phrase\">");
                forcast = split[1].split("</span></span>")[0];
                replaced = forcast.replace("&deg;", " °").replace(". ", "\n");
            }
        }
        
        //Print the weather forcast
        System.out.println(replaced);
            
        in.close();
    }
}
