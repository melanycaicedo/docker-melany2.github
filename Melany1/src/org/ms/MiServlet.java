package org.ms;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Connection conn;
	private String host = "localhost";
	private final String DB = "productos";
	private String user = "USER_MYCB";
	private String pass = "MApAyo";
	private String puerto = "3306";
    private ResultSet res;
    private Statement sql;
    
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException{
		System.out.println(request);
		
		response.setContentType("text/html");
		PrintWriter  salida;
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://" + this.host + ":" + this.puerto + "/" + this.DB;
	        conn = (Connection) DriverManager.getConnection(url, this.user, this.pass);
	        
			salida = response.getWriter();
			String sql = "select * from producto";
		     setRs(sql);
		     salida.println("ID PRODUCTO"+"&nbsp;&nbsp;&nbsp;&nbsp;"+"DECRIPCION DEL PRODUCTO"+"&nbsp;&nbsp;&nbsp;&nbsp;"+"PRECIO DEL PRODUCTO"+"&nbsp;&nbsp;&nbsp;&nbsp;"+"VENTA PRODUCTO");	
			  salida.println("<br>");
			while(getRs().next()) {
			
		    salida.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getRs().getString("ID_PRODUCTO")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getRs().getString("DESCRIPCION_DEL_PRODUCTO")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getRs().getString("PRECIO_PRODUCTO")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getRs().getString("PRECIO_VENTA"));	
		    salida.println("<p>---------------------------------------------------------------------------------------------------------------------------------------------------</p>");
				
				
			}
			salida.print("<a href='index.jsp'>REGRESAR A PAGINA PRINCIPAL</a>");
		}catch(Exception e) {
			
			
			
		}
	}
	  public ResultSet getRs() {
	        return res;
	    }
	
	    public void setRs(String devcode) {
	        try {
	            setSql();
	            res = getSql().executeQuery(devcode);
	        } catch (Exception e) {
	        }
	    }
	    public Statement getSql() {
	        return sql;
	    }
	    public void setSql() {
	        try {
	            this.sql = (Statement) conn.createStatement();
	         
	        } catch (Exception e) {
	        }
	    }

}
