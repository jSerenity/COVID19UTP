import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;
public class paciente extends persona {
    private String sexo, provincia,provicodigo;
    private int edad;
    private String sql;
    conection db = new conection();
    private ComboItem proYCo;
    public void setSexo(String c)
    {
        sexo = c;
    }
    public String getSexo()
    {
        return sexo;
    }
    public void setEdad(int c)
    {
        edad = c;
    }
    public int getEdad()
    {
        return edad;
    }
    public void setProvincia(String c)
    {
        provincia = c;
    }
    public String getProvincia()
    {
        return provincia;
    }
    public void setcodigo(String c)
    {
        provicodigo = c;
    }
    public String getcodigo(){
        return provicodigo;
    }
    public void setproYCo(ComboItem c)
    {
        proYCo = c;
    }
    public ComboItem getproYCo(){
        return proYCo;
    }
    
    public boolean buscar(String ced, String idB )
    {
        boolean encontrado = false;
       
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = db.OpenConnection();
            if(idB.equals("Codigo"))
            {
                sql = "select a.id, a.nombre, a.apellido, a.cedula, a.direccion, a.telefono, a.edad, a.sexo, b.descripcion, b.codigo from paciente a inner join provincia b on a.provincia =b.codigo Where a.Id ='"+ced+"'";
            }
            else{
                sql = "select a.id, a.nombre, a.apellido, a.cedula, a.direccion, a.telefono, a.edad, a.sexo, b.descripcion, b.codigo from paciente a inner join provincia b on a.provincia =b.codigo Where a.cedula ='"+ced+"'";
                }
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next())
            {
               setId(rs.getInt("id")); 
               setNombre(rs.getString("nombre")); 
               setApellido(rs.getString("apellido"));
               setCedula(rs.getString("cedula"));
               setDireccion(rs.getString("direccion"));
               setEdad(rs.getInt("edad"));
               setTelefono(rs.getString("telefono"));
               setSexo(rs.getString("sexo"));
               setcodigo(rs.getString("codigo"));
               setProvincia(rs.getString("descripcion"));
               setproYCo(new ComboItem(rs.getString("codigo"),rs.getString("descripcion")));
            encontrado = true;
            }
            db.CloseConnection();
        }
        catch(Exception e)
        {
            System.out.println("error "+e.toString());
        }
        return encontrado;
    }
    public void listar(DefaultTableModel dtm)
    {   
        sql = "";
        Object[] fila = new Object[3];

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = db.OpenConnection();
            sql = "select a.id, a.nombre, a.apellido, a.cedula, a.direccion, a.telefono, a.edad, if(a.sexo='M','Hombre','Mujer') as Sexo, (b.descripcion) as Provincia from paciente a inner join provincia b on a.provincia =b.codigo";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount=0;
            columnCount = metaData.getColumnCount();
            if (dtm.getRowCount()>0)
                dtm.setRowCount(0);
            else
            {
                
                for (int i = 1; i <= columnCount; i++) {
                    if(metaData.getColumnName(i).equals("descripcion"))
                    {dtm.addColumn("Provincia");

                    }else{
                        dtm.addColumn(metaData.getColumnName(i));
                    }
                   
                }
            }
            while (rs.next())
            {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                    System.out.println(rs.getObject(i));
                }
                dtm.addRow(vector);
            }
            db.CloseConnection();
        }
        catch(Exception e)
        {
            System.out.println("error "+e.toString());
        }
    }

    public int modificar()
    {
        sql = "";
        int result=10;
        try
        {
            Statement stmt = db.OpenConnection();
            sql = "update paciente set nombre='"+getNombre()+"', ";
            sql = sql + "apellido='"+getApellido()+"', ";
            sql = sql + "cedula='"+getCedula()+"', ";
            sql = sql + "direccion='"+getDireccion()+"', ";
            sql = sql + "edad='"+getEdad()+"', ";
            sql = sql + "sexo='"+getSexo()+"', ";
            sql = sql + "telefono='"+getTelefono()+"', ";
            sql = sql + "provincia='"+getcodigo()+"' ";
            sql = sql + "where Id='"+getId()+"'";
            System.out.println(sql);
            result = stmt.executeUpdate(sql); 
            System.out.println(""+result);
            db.CloseConnection(); 
        }
        catch(Exception e)
        {
            System.out.println("error "+e.toString());
        }
        return result;
    }
    public int adicionar()
    {
        sql = "";
        int result=10;
        try
        {
            Statement stmt = db.OpenConnection();
            sql = "INSERT INTO paciente (cedula,nombre,apellido,direccion,telefono,provincia,edad,sexo) values ('";
            sql = sql + getCedula()+"','" + getNombre()+"','"+getApellido()+"','"+getDireccion()+"','"+getTelefono()+"','"+getcodigo()+"','"+getEdad()+"','"+getSexo()+"')";

            System.out.println(sql);
            result = stmt.executeUpdate(sql); 
            System.out.println(""+result);
            db.CloseConnection(); 
        }
        catch(Exception e)
        {
            System.out.println("error "+e.toString());
        }
        return result;
    }
    public int eliminar()
    {
        sql = "";
        int result=10;
        try
        {
            Statement stmt = db.OpenConnection();
            sql = "delete from paciente where Id = '"+getId()+"'";
            System.out.println(sql);
            result = stmt.executeUpdate(sql); 
            System.out.println(""+result);
            db.CloseConnection(); 
        }
        catch(Exception e)
        {
            System.out.println("error "+e.toString());
        }
        return result;
    }
}