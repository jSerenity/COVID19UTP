import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;
public class medico extends persona {
    private String especialidad ,especodigo, codigo;
    private int pacientesmes, pacientesAnual;
    private String sql;
    conection db = new conection();


    public void setPames(int c)
    {
        pacientesmes = c;
    }
    public int getPames()
    {
        return pacientesmes;
    }
    public void setPano(int c)
    {
        pacientesAnual = c;
    }
    public int getPano()
    {
        return pacientesAnual;
    }
    public void setespecialidad(String c)
    {
        especialidad = c;
    }
    public String getespecialidad()
    {
        return especialidad;
    }
    public void setcodigo(String c)
    {
        codigo = c;
    }
    public String getcodigo(){
        return codigo;
    }
    public void setespecodigo(String c)
    {
        especodigo = c;
    }
    public String getespecodigo(){
        return especodigo;
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
                sql = "select a.id, a.nombre, a.apellido, a.cedula, a.direccion, a.telefono,a.pacientes_mes as `pacientes_al_mes` , a.pacientes_anual as `pacientes_al_año`,a.codigo, b.descripcion as `especialidad`, b.codigo as `CodifoE` from medico a inner join especialidad b on a.especialidad =b.codigo Where a.Id ='"+ced+"'";
            }
            else{
                sql = "select a.id, a.nombre, a.apellido, a.cedula, a.direccion, a.telefono,a.pacientes_mes as `pacientes_al_mes` , a.pacientes_anual as `pacientes_al_año`,a.codigo, b.descripcion as `especialidad`, b.codigo as `CodifoE` from medico a inner join especialidad b on a.especialidad =b.codigo Where a.cedula ='"+ced+"'";
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
               setPames(rs.getInt("pacientes_al_mes"));
               setPano(rs.getInt("pacientes_al_año"));             
               setTelefono(rs.getString("telefono"));
               setcodigo(rs.getString("codigo"));
               setespecialidad(rs.getString("especialidad"));
               setespecodigo(rs.getString("CodifoE"));
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
            sql = "select a.id, a.nombre, a.apellido, a.cedula, a.direccion, a.telefono,a.pacientes_mes as `pacientes_al_mes` , a.pacientes_anual as `pacientes_al_año`,a.codigo, b.descripcion as `especialidad` from medico a inner join especialidad b on a.especialidad =b.codigo";
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
                    {dtm.addColumn("Especialidad");

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
            sql = "update medico set nombre='"+getNombre()+"', ";
            sql = sql + "apellido='"+getApellido()+"', ";
            sql = sql + "cedula='"+getCedula()+"', ";
            sql = sql + "codigo='"+getcodigo()+"', ";
            sql = sql + "direccion='"+getDireccion()+"', ";
            sql = sql + "pacientes_mes='"+getPames()+"', ";
            sql = sql + "pacientes_anual='"+getPano()+"', ";
            sql = sql + "telefono='"+getTelefono()+"', ";
            sql = sql + "especialidad='"+getespecodigo()+"' ";
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
            sql = "INSERT INTO medico (cedula,nombre,apellido,direccion,telefono,especialidad,pacientes_mes,pacientes_anual,codigo) values ('";
            sql = sql + getCedula()+"','" + getNombre()+"','"+getApellido()+"','"+getDireccion()+"','"+getTelefono()+"','"+getespecodigo()+"','"+getPames()+"','"+getPano()+"','"+getcodigo()+"')";

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
            sql = "delete from medico where Id = '"+getId()+"'";
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