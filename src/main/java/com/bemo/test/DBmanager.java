package com.bemo.test;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;


@ManagedBean(name = "DBmanager", eager = true)
@SessionScoped
public class DBmanager implements Serializable {

private static final long serialVersionUID = 1L;
public static void main (){ 
}
private static Connection getConnection() throws URISyntaxException, SQLException {
    String dbUrl = System.getenv("JDBC_DATABASE_URL");
    return DriverManager.getConnection(dbUrl);
}
   public void insert () {
      
      UserData.age = 40;
      
        try {
            getConnection();
        executeUpdate("INSERT INTO test (age) VALUES (55)");

        }

     
         catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        //if (connection != null) try{connection.close();} catch(SQLException e){};
      }
     
   }

   
}
