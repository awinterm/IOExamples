/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre_000
 */
public class LabStartUp {
    public static void main(String[] args) throws IOException {
        boolean append = true;
        File fileData = new File(File.separatorChar + "Users" + File.separatorChar + "andre_000" + File.separatorChar 
                + "Desktop" + File.separatorChar + "JavaLab111115" + File.separatorChar + "LabData.txt");
        
        
        BufferedReader in = null;
        
        try {
	   in = new BufferedReader(new FileReader(fileData));
	   String line = in.readLine();
	   while(line != null){
		  System.out.println(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        
        
        PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(fileData, append)));
    
        out.println("");
        out.println("Andrew Summers");
        out.println("1323 Genesee Street");
        out.println("Delafield Wi 53018");
        out.close();
        
        List<String> records = new ArrayList<>();
        
        try {
	   in = new BufferedReader(new FileReader(fileData));
	   String line = in.readLine();
	   while(line != null){
		  //System.out.println(line);
		  records.add(line);               
                  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        
        System.out.println("This is our list.");
         for (Object record : records) {
            String s = (String) record;
            System.out.println(s);
        }
        System.out.println("**********************************************************");
        System.out.println("Challenge 3");
        
        
        // this is whatever record you want to look up.
        int recordNumber = 4;
        
        
        System.out.println("NAME OF 2nd CONTACT!");
        
        String name = records.get(recordNumber * 4 - 4);
        System.out.println(name);
        
        String address = records.get(recordNumber * 4 - 2);
        System.out.println(address);
        String[] addressParts = address.split(" ");
        String state = "monkey";
        if ( addressParts.length == 3){
            state = addressParts[2];
        }
        else if ( addressParts.length == 4){
            state = addressParts[3];
        }
        
        System.out.println("*********************ANSWER FOR Challenge 3**************************");
        
        System.out.println(name + " State: " + state);
        
    }
}
