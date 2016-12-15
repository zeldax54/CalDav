/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.*; 
import net.fortuna.ical4j.model.property.*;
import java.util.logging.Logger;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.util.UidGenerator;



/**
 *
 * @author hector.duran
 */
public class Ical4jClassTest {
    
    
    
public static void   TestFunctios( java.io.OutputStream out ) throws FileNotFoundException, IOException, ParserException, ValidationException{
  CreateCalendarFile( out);
//FileInputStream fin = new FileInputStream("mycalendar.ics");
//CalendarBuilder builder = new CalendarBuilder();
//Calendar calendar = builder.build(fin);
    
    }


 public static  void CreateCalendarFile( java.io.OutputStream out) throws IOException, FileNotFoundException, ValidationException{
net.fortuna.ical4j.model.Calendar calendar = new net.fortuna.ical4j.model.Calendar();
// java.io.ByteArrayInputStream ba = new    java.io.ByteArrayInputStream(request.getParameter("x").getBytes());
 
calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
calendar.getProperties().add(Version.VERSION_2_0);
calendar.getProperties().add(CalScale.GREGORIAN);
//Elementos
java.util.Calendar calendarjava = java.util.Calendar.getInstance();
calendarjava.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
calendarjava.set(java.util.Calendar.DAY_OF_MONTH, 25);
// initialise as an all-day event..
VEvent christmas = new VEvent(new Date(calendarjava.getTime()), "Christmas Day");
// Generate a UID for the event..
UidGenerator ug = new UidGenerator("1");
christmas.getProperties().add(ug.generateUid());
calendar.getComponents().add(christmas);

  WriteFile(calendar ,out);
}

static void  WriteFile(net.fortuna.ical4j.model.Calendar calendar,java.io.OutputStream out ) throws FileNotFoundException, IOException, ValidationException
{
try
  {
 //out = new FileOutputStream("C:\\Users\\hector.duran\\Desktop\\mycalendar.ics");
CalendarOutputter outputter = new CalendarOutputter();
outputter.output(calendar,  out);
      System.out.println(" Creado con exito");
  }
catch(IOException | ValidationException e)
{
    System.out.println(   e.getLocalizedMessage());
}

} 




}
