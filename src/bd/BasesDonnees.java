package bd;

import java.lang.*;
import java.io.*;
import java.sql.*;

import Stockage.MemoPompier;
import metier.*;


public class BasesDonnees {
	
	private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://Localhost/bdpompiers";
    private String user = "root";
    private String password = ""; //pas de password
    private MemoPompier memoPompier = new MemoPompier();

    private Connection getConnection (){
        Connection conn = null;
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
       
    public void affichePompierPro(){
    	  Connection conn = this.getConnection();
    	  try {
        	  
              Statement stmt = conn.createStatement();
              ResultSet res = stmt.executeQuery("SELECT * FROM pompierpro");

              while (res.next()){
                  System.out.println(res.getString("nom") + " " + res.getString("prenom") + " numeroBIP : "+res.getInt("bip")+" grade : "+res.getString("grade"));
                  memoPompier.add(new PompierPro(res.getString("nom"), res.getString("prenom"),res.getInt("bip"), res.getString("grade")));
              }
              conn.close();
          }
          catch (Exception e) {
             // e.printStackTrace();
         }
    }
    
    public void affichePompierVol(){
  	  Connection conn = this.getConnection();
  	  try {
      	  
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM pompiervol");

            while (res.next()){
                System.out.println("nom :"+res.getString("nom")+" prenom :"+res.getString("prenom")+" numeroBIP : "+res.getInt("bip")+" nivformation : "+res.getInt("nivformation"));
                memoPompier.add(new PompierVol(res.getString("nom"), res.getString("prenom"),res.getInt("bip"), res.getInt("nivformation")));
            }
            conn.close();
        }
        catch (Exception e) {
           // e.printStackTrace();
       }

    }

    public MemoPompier getUnMemoPompier(){
        return memoPompier;
    }




	
}