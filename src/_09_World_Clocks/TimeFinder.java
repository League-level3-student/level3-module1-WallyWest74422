package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class TimeFinder implements ActionListener {
    ClockUtilities clockUtil;
    Timer timer;
    TimeZone timeZone0;
    HashMap<String, TimeZone> cities;
    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    
    String city0;
    String dateStr;
    String timeStr;
    
    public TimeFinder() {
    	clockUtil = new ClockUtilities();
    	 city0 = "San Diego, US";
         timeZone0 = clockUtil.getTimeZoneFromCityName(city0);
         cities = new HashMap<String, TimeZone>();
         cities.put(city0, timeZone0);
         String city1 = JOptionPane.showInputDialog("Type in the name of a city in this format 'City, Country' in order to see its current time.");
         TimeZone timeZone1 = clockUtil.getTimeZoneFromCityName(city1);
         cities.put(city1, timeZone1);
         String city2 = JOptionPane.showInputDialog("Type in the name of another city in this format 'City, Country' in order to see its current time.");
         TimeZone timeZone2 = clockUtil.getTimeZoneFromCityName(city2);
         cities.put(city2, timeZone2);
         Calendar calendar = null;


             for(String c : cities.keySet()){
            	 
                 calendar = Calendar.getInstance(cities.get(c));
                 String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
                 String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
                 dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
                 System.out.println(dateStr);
             }
			 
    	 //Calendar calendar = Calendar.getInstance(timeZone1);
      //   String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
     //    String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
      //   dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
         
         //System.out.println(dateStr);
         
         frame = new JFrame();
         panel = new JPanel();
         textArea = new JTextArea();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         frame.setSize(500, 500);
         frame.add(panel);
         panel.add(textArea);
         textArea.setText(city0 + "\n" + dateStr);
         
         // This Timer object is set to call the actionPerformed() method every
         // 1000 milliseconds
         timer = new Timer(1000, this);
         timer.start();
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 for(String c : cities.keySet()){
		 Calendar c2 = Calendar.getInstance(cities.get(c));
	        String militaryTime = c2.get(Calendar.HOUR_OF_DAY) + ":" + c2.get(Calendar.MINUTE) + ":" + c2.get(Calendar.SECOND);
	        String twelveHourTime = " [" + c2.get(Calendar.HOUR) + ":" + c2.get(Calendar.MINUTE) + ":" + c2.get(Calendar.SECOND) + "]";
	        timeStr = militaryTime + twelveHourTime;
	        System.out.println(timeStr);
	        textArea.setText(cities.keySet() + "\n" + dateStr + "\n" + timeStr);
	        frame.pack();
		 }
	        
	}
    


}
