import java.sql.*;
public class conection {
    
String URL, user, pass;
String sql;    
String cedula, nombre, apellido;
Connection con;
public Statement Connection;

public Statement OpenConnection()
{
    URL = "jdbc:mysql://127.0.0.1/proy_final_alba?useSSL=false";
    user = "root";
    pass = "root";

    try
    {
        con = DriverManager.getConnection(URL,user,pass);
        Connection = con.createStatement();
    }
    catch(Exception e)
    { 
        System.out.println("Error1 "+e.toString());
    }
    return Connection;
}
public void CloseConnection()
{
    try
    {
     Connection.close();
    }
    catch(Exception e)
    { 
        System.out.println("Error "+e.toString());
    }
}
public Connection getCon(){
    return con;
}

}