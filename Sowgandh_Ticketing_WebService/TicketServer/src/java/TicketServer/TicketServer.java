/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicketServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sowgandh
 */
@WebService(serviceName = "TicketServer")
public class TicketServer {

    /**
     * This is a sample web service operation
     */
   @WebMethod(operationName = "details")
   
    public String details() {
       // ArrayList<String> details = new ArrayList<String>();
         String temp1=""; 
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","sn2638");
             Statement stat =  conn.createStatement();
             String query = "Select * from Tickets";
             ResultSet r = stat.executeQuery(query);
             while(r.next()){
                  System.out.println("Inside loop");
                 if(r.getString(3).equals("NO")){
                 temp1 =temp1+ r.getString(2)+"-"+r.getString(4) + ",";
                 }
                 
                 
             }
         }
         catch(Exception e){
             
         }
        System.out.println("Sowgandh "+temp1);
        return temp1;
    }
    
    
    @WebMethod(operationName = "booking")
   
    public String booking(@WebParam(name = "value1") String value1) {
       // ArrayList<String> details = new ArrayList<String>();
         String temp1=""; 
        try{
            boolean check1=false;
            System.out.println("Value "+value1);
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","sn2638");
             Statement stat =  conn.createStatement();
             Statement stat2 = conn.createStatement();
             String check = "Select * from  Tickets";
             ResultSet r = stat2.executeQuery(check);
             while(r.next()){
                 if(r.getString(2).equals(value1)&& r.getString(3).equals("YES")){
                   System.out.println("Entering the logic ");
                     check1=true; 
                 }
             }
             
             if(!check1){
             String query = "Update Tickets Set Booked = 'YES' where Ticket = "+ "'" + value1+"'";
              System.out.println("Query is "+query);
           
             int val = stat.executeUpdate(query);
            System.out.println("Value is ------"+val);
            temp1="Ticket has been booked sucessfully";
             }else{
                 temp1="Ticket has been sold out";
             }
             
         }
         catch(Exception e){
            e.printStackTrace();
         }
       return temp1 ;
    }
}
