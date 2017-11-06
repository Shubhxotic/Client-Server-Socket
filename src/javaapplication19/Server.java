/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Shubham Agarwal
 */
public class Server {
    	
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    private DataOutputStream out     = null;
    // constructor with port
    public Server(int port)
    {
        //close connections if open
//        try{
//            // close connection
//            socket.close();
//            in.close();
//        }
//        catch(Exception i)
//        {
//            System.out.println(i);
//        }
        // starts server and waits for a connection
        try
        {

//            System.out.println("Thank You " +xp);
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
            InetAddress ia;
            ia=server.getInetAddress();
//            System.out.println("inet addr of server= "+ia.getHostAddress());
            String temp=ia.getHostAddress().toString();
            
            System.out.println("Client accepted");
 
            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            out    = new DataOutputStream(socket.getOutputStream());
 
            out.writeUTF(temp);
            out.writeInt(server.getLocalPort());
            String line = "";
            int x=0;
            // reads message from client until "Over" is sent
            while(x!=-1)
            {
                try
                {
//                    String l=in.readUTF();
//                    System.out.println(l);
//                    x = in.readInt();
//                    double area=3.14*x*x;
//                    out.writeDouble(area);
//                    System.out.println("*le area on the server side="+area); 
//                      line = in.readUTF();
//                    System.out.println(line);
                    x = in.readInt();
                    System.out.println("The choice received by the server "+x);
                    String s="";
                  switch(x){
                      case 1:
//                          System.out.println("Enter radius of the Circle");
                          double r=in.readDouble();
                          double ar=3.14*r*r;
                          System.out.println("Area calculated on the server side:- "+ar+ "for the radius given as:- "+r);
                          out.writeDouble(ar);
                          break;
                      case 2:
//                          System.out.println("Enter radius of the Circle");
                          int a=in.readInt();
                          int b=in.readInt();
                          System.out.println("Area calculated on the server side:- "+(a*b)+ "for length="+a+" and breadth= "+b);
                          out.writeInt(a*b);
                          break;
                      case 3:
//                          System.out.println("Enter a string");
                          s=in.readUTF();
                          System.out.println("String received on the server side:-"+s);
                          System.out.println("Converted String sent by the server:-"+s.toUpperCase());
                          out.writeUTF(s.toUpperCase());
                          break;
                      case 4:
//                          System.out.println("Enter a string");
                          s=in.readUTF();
                          System.out.println("String received on the server side:-"+s);
                          System.out.println("Converted String sent by the server:-"+s.toLowerCase());
                          out.writeUTF(s.toLowerCase());
                          break;
                      case 5:
//                          System.out.println("Enter radius of the Circle");
//                          s=sc.nextLine();
//                          out.writeUTF(s);
                          s=in.readUTF();
                          System.out.println("String received on the server side:-"+s);
                          String ans="";
                          for(int i=0;i<s.length();i++)
                          {
                              char ch=s.charAt(i);
                              if("AEIOUaeiou".indexOf(ch)!=-1){
                                  ans+=ch+",";
                              }
                          }
                          System.out.println("The vowels in the String are:= "+ans);
                          out.writeUTF(ans);
                          break;
                      case -1:
                          System.out.println("Bye");
                          System.exit(0);
                          break;
                      default:
                          System.out.println("Enter a valid number(1-5 or -1)");
                          break;
                  }
                    
                    
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
 
            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        Server server = new Server(2000);
    }
}