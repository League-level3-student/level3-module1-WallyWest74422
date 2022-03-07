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
         HashMap<String, TimeZone> cities = new HashMap<String, TimeZone>();
         cities.put(city0, timeZone0);
         String city1 = JOptionPane.showInputDialog("Type in the name of a city in this format 'City, Country' in order to see its current time.");
         TimeZone timeZone1 = clockUtil.getTimeZoneFromCityName(city1);
         cities.put(city1, timeZone1);
         Calendar calendar = null;
         for (int i = 0; i < cities.size(); i++) {
			 calendar = Calendar.getInstance(cities.get("city"+i));
		}
    	 //Calendar calendar = Calendar.getInstance(timeZone1);
         String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
         String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
         dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
         
         System.out.println(dateStr);
         
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
		 Calendar c = Calendar.getInstance(timeZone0);
	        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
	        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
	        timeStr = militaryTime + twelveHourTime;
	        
	        System.out.println(timeStr);
	        textArea.setText(city0 + "\n" + dateStr + "\n" + timeStr);
	        frame.pack();
	}
    


}
