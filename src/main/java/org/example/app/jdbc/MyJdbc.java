package org.example.app.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class MyJdbc {

    private static MyJdbc instancia = null;
    private Connection con = null;

    private MyJdbc()
    {
    }

    public void disconnect()
    {
        try
        {
            if( con!=null ) con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> query(String sql,Object ...params)
    {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try
        {
            // preparo la sentencia
            pstm = con.prepareStatement(sql);

            // seteo los parametros
            for(int i=0; i<params.length;i++)
            {
                pstm.setObject(i+1,params[i]);
            }

            // ejecuto el query
            rs = pstm.executeQuery();

            // metadata
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // recorro el ResultSet y cargo los datos
            List<Object[]> ret = new ArrayList<>();
            while( rs.next() )
            {
                Object[] fila = new Object[columnCount];
                for(int i=0;i<columnCount;i++)
                {
                    fila[i] = rs.getObject(i+1);
                }
                ret.add(fila);
            }

            return ret;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                if( rs!=null ) rs.close();
                if( pstm!=null ) pstm.close();
            }
            catch(Exception e2)
            {
                e2.printStackTrace();
                throw new RuntimeException(e2);
            }
        }
    }

    public static MyJdbc getInstance()
    {
        FileInputStream fis = null;

        try
        {
            if( instancia==null )
            {
                instancia = new MyJdbc();

                // me preparo para leer las propiedades
                /*Properties props = new Properties();
                fis = new FileInputStream("src/main/resources/MyJdbc.properties");
                props.load(fis);

                String url = props.getProperty("url");
                String driver = props.getProperty("driver");
                String usr = props.getProperty("usr");
                String pwd = props.getProperty("pwd");
                */
                String url = "jdbc:mysql://localhost:3306/neoris";
                String driver="com.mysql.cj.jdbc.Driver";
                String usr="admin";
                String pwd="admin";

                // levanto el driver
                Class.forName(driver);

                // Me conecto!
                instancia.con = DriverManager.getConnection(url,usr,pwd);
            }

            return instancia;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                if( fis!=null ) fis.close();
            }
            catch(Exception e2)
            {
                e2.printStackTrace();
                throw new RuntimeException(e2);
            }
        }
    }

    // insert, update y delete
    public int update(String sql,Object ...params)
    {
        return 0;
    }


}
