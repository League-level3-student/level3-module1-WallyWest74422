package _08_California_Weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;


public class WeatherFinder {
	 ArrayList<String> matchingCities = new ArrayList<String>();
	 ArrayList<String> inBetweenCities = new ArrayList<String>();
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
          if( cityName1.get(city).weatherSummary.equals(conditionNew)) {
        	  matchingCities.add(city);
          }else {
 //       	  System.out.println("Unable to find cities for" + conditionNew + ".");
          }
          for(String s : matchingCities){
              System.out.println(s);
          }
        }
        HashMap<String, WeatherData> inBetween = Utilities.getWeatherData();
        String min = JOptionPane.showInputDialog("Type in a minimum temperature.");
        int min1=Integer.parseInt(min);
        String max = JOptionPane.showInputDialog("Type in a maximum temperature.");
        int max1=Integer.parseInt(max);
        for(String city1 : inBetween.keySet()){
        	 if( inBetween.get(city1).temperatureF >min1 &&  inBetween.get(city1).temperatureF <max1) {
           	  inBetweenCities.add(city1);
             }for(String i : inBetweenCities) {
        		 System.out.println(i);
        	 }
        }
	return weatherData;

}
}