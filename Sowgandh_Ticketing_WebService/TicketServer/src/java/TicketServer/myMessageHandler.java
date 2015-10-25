/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicketServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.NodeList;

/**
 *
 * @author sowgandh
 */
public class myMessageHandler implements SOAPHandler<SOAPMessageContext> {
    
    public boolean handleMessage(SOAPMessageContext messageContext) {
        Statement stat = null;Connection conn=null;
        Statement stat2 = null;
        try{
         Class.forName("com.mysql.jdbc.Driver");
              conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","sn2638");
              stat =  conn.createStatement();
              stat2 = conn.createStatement();
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(myMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        String outProperty = SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY;
        boolean outgoing = (Boolean) messageContext.get(outProperty);
        SOAPMessage msg = messageContext.getMessage();
        String username = "";
        try {
            if (outgoing) {
                //msg.writeTo(new FileOutputStream("C:/Users/sowgandh/Desktop/message.txt"));
                //System.out.println("MyMessage "+msg.toString());
            } else {
                SOAPHeader header = msg.getSOAPHeader();
                Iterator it = header.examineAllHeaderElements();
                while (it.hasNext()) {
                    SOAPHeaderElement e = (SOAPHeaderElement) it.next();
                    NodeList nl = e.getElementsByTagName("wsse:Username");
                    for (int i = 0; i < nl.getLength(); i++) {
                        username += nl.item(i).getTextContent();
                    }
                }
              //  FileOutputStream f = new FileOutputStream("C:/Users/sowgandh/Desktop/usernames.txt");
              //  byte data[] = username.getBytes();
              //  f.write(data);
                
                Iterator tags = messageContext.getMessage().getSOAPPart().getEnvelope().getBody().getChildElements();
                String methodname="";
                while (tags.hasNext()) {
                    Object obj = tags.next();
                    if(obj instanceof SOAPElement) {
                        SOAPElement e = (SOAPElement) obj;
                        methodname = e.getElementName().getLocalName();
                        break;
                    }

                }

                System.out.println("Username is "+username);
                
                //System.out.println("functionName->" + operationName);
                
                if(methodname.equals("details")){
                    String query = "insert into user_list values"+"('"+username+"')";
                    System.out.println("Query is "+query);
                    
                    
                    try {
                        stat2.executeUpdate(query);
                    } catch (SQLException ex) {
                        Logger.getLogger(myMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return true;
                    
                }else if(methodname.equals("booking")){
                    String query= "Select * from user_list";
                    boolean check=false;
                    try {
                        ResultSet re = stat.executeQuery(query);
                        while(re.next()){
                            if(re.getString(1).equals(username)){
                                check=true;
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(myMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!check){
                        return false;
                        
                    }else{
                        String query2 = "Delete from user_list where usernames = " + "'"+username+"'";
                        try {
                            stat.executeUpdate(query2);
                           
                        } catch (SQLException ex) {
                            Logger.getLogger(myMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return true;
                    }
                    
                }
                
                
                
                
               // msg.writeTo(new FileOutputStream("C:/Users/sowgandh/Desktop/inputmessage.txt"));

            }
        }  catch (SOAPException e) {
            System.out.println("SOAP		IO	Error!!!!");
            throw new RuntimeException(e);

        }
       return true;
    }
    
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
}
