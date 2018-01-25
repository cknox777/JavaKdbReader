/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtokdb;

import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author connor.knox
 */
public class ConnectionToKDB {
    
    public ConnectionToKDB(){}
    
   public void ConnectToKDB(){
    //c connection = null;
        // 1) create a java calendar instance
        Calendar calendar = Calendar.getInstance();
        // 2) get a java.util.Date from the calendar instance.
        //    this date will represent the current instant, or "now".
        java.util.Date now = calendar.getTime();
        // 3) a java current time (now) instance
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        try{
        c connection=new c("localhost",6002,"admin:admin");
        
        /*code to put a row of data into the trade table
        Object [] result={currentTimestamp,"JFIK",74.32,new Integer(93),new Boolean(false),'B','O'};
        connection.ks(".u.upd","trade",result);
        */
        
        //subscribe to TP to get the feed data
        //Object subscribeToKdbProcess = connection.k(".u.sub","trade","");
        boolean run = true; //While true the application will continue to query the kdb process (RDB or TP depending on port)
        while(run){
        
        
        //System.out.println("Received "+ Arrays.deepToString(objectFeedArray));
        //System.out.println("Recieved" + connection.k("-1#trade"));
        /*
        Put in a sleep(1000). Should stop the duplications you see in the console
        */
        c.Flip flip = (c.Flip)connection.k("-1#trade");
        for(int col=0;col<flip.x.length;col++)
          System.out.print((col>0?",":"")+flip.x[col]);
        System.out.println();
        for(int row=0;row<c.n(flip.y[0]);row++){
          for(int col=0;col<flip.x.length;col++)
            System.out.print((col>0?",":"")+c.at(flip.y[col],row));
            System.out.println();
        }
        //run = false;
        Thread.sleep(1000); // Prevents duplicate rows produced due to querying the rdb multiple times before a new 'last row' was generated
        //System.out.println(connection.k("2+4")); //Test connection to kdb process
        }
        //connection.close();
        
        }
        catch(c.KException ke){
            System.out.println("Oops"); 
        }
        catch(IOException io){
            System.out.println("Oops2");
        }
        catch(InterruptedException ie){
            System.out.println("Oops3");
        }
        System.exit(0);
   }
}
