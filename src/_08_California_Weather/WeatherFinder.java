package _08_California_Weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class WeatherFinder {
	HashMap start() {
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
        String cityName = JOptionPane.showInputDialog("Which city in California would you like to see the weather of?");
 String cityNameNew = Utilities.capitalizeWords(cityName ); {
}
    		  WeatherData datum = weatherData.get(cityNameNew);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
        HashMap<String, WeatherData> cityName1 = Utilities.getWeatherData();
        String condition = JOptionPane.showInputDialog("Type in a weather condition in order to see the cities in California that match that description.");
        String conditionNew = Utilities.capitalizeWords(condition);
        for(String city : cityName1.keySet()){
          if( cityName1.get(city).weatherSummary==conditionNew) {
        	  
          }else {
        	  cityName1.remove(city, cityName1.get(city));
          }
          System.out.println(cityName1.values());
        }
        	System.out.println(cityName1);
        

	return weatherData;

}
}