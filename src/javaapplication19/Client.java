/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author sa126
 */
 
public class Client
{
    Scanner sc=new Scanner(System.in);
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataInputStream in       =  null;
    private DataOutputStream out     = null;
    
    // constructor to put ip address and port
    public Client(String address, int port)
    {
        //closing connections if Open
//        try
//        {
//            input.close();
//            out.close();
//            socket.close();
//        }
//        catch(IOException i)
//        {
//            System.out.println(i);
//        }
//        
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Client Inet Address="+socket.getInetAddress());
            System.out.println("Client Name= "+socket.getInetAddress().getHostName());
            System.out.println("Client Port number="+socket.getPort());
            System.out.println("Remote address="+socket.getRemoteSocketAddress());
            
            // takes input from terminal
            input  = new DataInputStream(System.in);
 
            //takes input from the 
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
            String serverIp=in.readUTF();
            System.out.println("Connected to Server:- "+serverIp);
            System.out.println("Server's IP ADdr:- "+serverIp);
            System.out.println("Server's Port Number:- "+in.readInt());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
 
        // string to read message from input
        String line = ""; 
        int x=0;
        // keep reading until "Over" is input
        while (x!=-1)
        {
            try
            {
//                System.out.println("Enter radius for the circle");
////                x=input.readInt();
//                String l=input.readUTF();
//                out.writeUTF(l);
//                System.out.println("Input===="+l);
//                out.writeInt(x);
//                double ar=in.readDouble();
//                System.out.println("Area of the fuckin circle= "+ar);
                
//                line = input.readLine();
//                out.writeUTF(line);
//                x=input.readInt();
                int choice=0;
                while(1==1){
                    try{
                        String xp=JOptionPane.showInputDialog("Enter Your Choice:- \n 1- To calculate the Area of a Circle\n 2- To calculate the Area of a Rectangle\n 3- To convert a string to UPPERCASE\n 4- To convert a string to lowercase\n 5- To find the vowels in a string\n (-1): Quit.");
                        choice=Integer.parseInt(xp.trim());
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Enter a valid Number(0-5 or -1)");
                        
                    }
                }
//                System.out.println("Enter your choice");
                x=choice;
                out.writeInt(x);
                String s,xp="";
                switch(x){
                    case 1:
                        double r=0.0;
                        while(1==1){
                            try{
                                xp=JOptionPane.showInputDialog("Enter the radius of the circle");
                                r=Double.parseDouble(xp.trim());
                                break;
                            }
                            catch(Exception e){
                                System.out.println("Enter a valid radius value");

                            }
                        }
                        out.writeDouble(r);
                        JOptionPane.showMessageDialog(null,"The area of the circle is:- "+in.readDouble());
                        break;
                    case 2:
                        int a,b;
                        while(1==1){
                            try{
                                xp=JOptionPane.showInputDialog("Enter length of the rectangle");
                                a=Integer.parseInt(xp.trim());
                                break;
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null,"Enter a valid Number(integer)");
                            }
                        }
                        while(1==1){
                            try{
                                xp=JOptionPane.showInputDialog("Enter breadth of the rectangle");
                                b=Integer.parseInt(xp.trim());
                                break;
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null,"Enter a valid Number(integer)");

                            }
                        }
//                        System.out.println("Enter breadth of the rectangle");
//                        int a=sc.nextInt();
//                        int b=sc.nextInt();
                        out.writeInt(a);
                        out.writeInt(b);
                        JOptionPane.showMessageDialog(null,"The area of the rectangle is:- "+in.readInt());
                        break;
                    case 3:
                        while(1==1){
                            try{
                                xp=JOptionPane.showInputDialog("Enter a string");
                                break;
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null,"Enter a valid String");
                            }
                        }
//                        System.out.println("Enter a string");
//                        sc.nextLine();
//                        s=sc.nextLine();
                        out.writeUTF(xp);
                        JOptionPane.showMessageDialog(null,"The string in Uppercase is :- "+in.readUTF());
                        break;
                    case 4:
//                        String xp="";
                        while(1==1){
                            try{
                                xp=JOptionPane.showInputDialog("Enter a valid String");
                                break;
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null,"Enter a valid Number(integer)");

                            }
                        }
//                        System.out.println("Enter a string");
//                        sc.nextLine();
//                        s=sc.nextLine();
                        out.writeUTF(xp);
//                        System.out.println("Enter a string");
//                        sc.nextLine();
//                        s=sc.nextLine();
//                        out.writeUTF(s);
                        JOptionPane.showMessageDialog(null,"The string in Lowercase is :- "+in.readUTF());
                        break;
                        
                    case 5:
                        xp="";
                        while(1==1){
                            try{
                                xp=JOptionPane.showInputDialog("Enter a string");
                                break;
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null,"Enter a valid String");

                            }
                        }
//                        System.out.println("Enter a string");
//                        sc.nextLine();
//                        s=sc.nextLine();
                        out.writeUTF(xp);
//                        System.out.println("Enter a string");
//                        sc.nextLine();
//                        s=sc.nextLine();
//                        out.writeUTF(s);
                        JOptionPane.showMessageDialog(null,"The vowels in the string are  :- "+in.readUTF());
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(null,"Bye");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Enter a valid Choice(0-5 or -1)");
                        break;
                }
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
 
        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 2000);
    }
}