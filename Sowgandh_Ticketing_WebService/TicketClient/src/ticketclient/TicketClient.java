/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketclient;

import java.util.Scanner;

/**
 *
 * @author sowgandh
 */
public class TicketClient {

     public static void fetch_available_seats(){
        System.out.println("");
       
        String temp = details();    
        String array[] = temp.split(",");
        for(int i=0;i<array.length;i++){
            if(array[i].startsWith("1")){
                String temp_array[] = array[i].split("-");
                if(i==0){
                System.out.println();System.out.println("Stand  1");System.out.println();
                }
                for(int j=0;j<1;j++){
                    //System.out.println(j);
                    System.out.println(temp_array[j] +" and its cost is "+temp_array[j+1]);
                }
                
            }else if(array[i].startsWith("2")){
                String temp_array[] = array[i].split("-");
               
                if(i==6){
                System.out.println();System.out.println("Stand  2");System.out.println();
                }
                for(int j=0;j<1;j++){
                    System.out.println(temp_array[j] +" and its cost is "+temp_array[j+1]);
                }
            }else if(array[i].startsWith("3")){
                String temp_array[] = array[i].split("-");
                if(i==12){
                System.out.println();System.out.println("Stand  3");System.out.println();
                }
                for(int j=0;j<1;j++){
                    System.out.println(temp_array[j] +" and its cost is "+temp_array[j+1]);
                }
            }else if(array[i].startsWith("4")){
                String temp_array[] = array[i].split("-");
                if(i==18){
                System.out.println();System.out.println("Stand  4");System.out.println();
                }
                for(int j=0;j<1;j++){
                    System.out.println(temp_array[j] +" and its cost is "+temp_array[j+1]);
                }
            }
        }

    }
    
    public static void book_seats(){
        System.out.println("");
        System.out.println("Enter your ticket");
        Scanner sc = new Scanner(System.in);
        String ticket = sc.nextLine();
        try{
        System.out.println(booking(ticket));
        }catch(Exception e){
            System.out.println("Your not registered with the database");
        }
    }
    
    public static void main(String[] args) {
       
        while(true){
            System.out.println();
            System.out.println("Enter 1 to fetch_details");
            System.out.println("Enter 2 to book the seats");
            System.out.println("Enter 3 to terminate");
            Scanner sc = new Scanner(System.in);
            String temp = sc.nextLine();
            if(temp.equals("1")){
                fetch_available_seats();
                
            }else if(temp.equals("2")){
                book_seats();
               
            }else if(temp.equals("3")){
                break;
            }
        }
        
    }

    private static String booking(java.lang.String value1) {
        ticketclient.TicketServer_Service service = new ticketclient.TicketServer_Service();
        ticketclient.TicketServer port = service.getTicketServerPort();
        return port.booking(value1);
    }

    private static String details() {
        ticketclient.TicketServer_Service service = new ticketclient.TicketServer_Service();
        ticketclient.TicketServer port = service.getTicketServerPort();
        return port.details();
    }
    
}
