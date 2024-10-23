package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.sql.PreparedStatement;

public class SeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "segurosgroup?useSSL=false";
    

    public SeguroDao() {
    }

    // obtener una conexión a la base de datos
    private Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            // Cargar el driver de MySQL
            //Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión a la base de datos
            conn = DriverManager.getConnection(host + dbName, user, pass);
        } catch (SQLException e) {
            throw new Exception("Error al conectar con la base de datos", e);
        }
        return conn;
    }

    // agregar un seguro usando el procedimiento almacenado
    public int agregarSeguro(Seguro seguro) {
        int filasAfectadas = 0;
        String sql = "{ CALL agregarSeguro(?, ?, ?, ?) }";  // Llamada al stored procedure

        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            // Establecer los valores en los parámetros del procedimiento almacenado
            stmt.setString(1, seguro.getDescripcion());
            stmt.setInt(2, seguro.getIdTipo());
            stmt.setFloat(3, seguro.getCostoContratacion());
            stmt.setFloat(4, seguro.getCostoAsegurado());

            // Ejecutar la consulta y obtener las filas afectadas
            filasAfectadas = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filasAfectadas;
    }

    // Obtener seguros según su tipo
    public ArrayList<Seguro> obtenerSegurosSegunTipo(int idTipo) {
        ArrayList<Seguro> listaSeguros = new ArrayList<>();
        String sql = "SELECT * FROM seguros WHERE idTipo = ?";

        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            // Establecer el valor del parámetro idTipo
            stmt.setInt(1, idTipo);
            ResultSet rs = stmt.executeQuery();

            // Recorrer el resultado de la consulta
            while (rs.next()) {
                Seguro seguro = new Seguro();
                seguro.setIdSeguro(rs.getInt("idSeguro"));
                seguro.setDescripcion(rs.getString("descripcion"));
                seguro.setIdTipo(rs.getInt("idTipo"));
                seguro.setCostoContratacion(rs.getFloat("costoContratacion"));
                seguro.setCostoAsegurado(rs.getFloat("costoAsegurado"));

                // Agregar el seguro a la lista
                listaSeguros.add(seguro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaSeguros;
    }
    
 // Obtener el idSeguro más grande de la tabla seguros
    public int obtenerIdSeguroMaximo() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int idMaximo = 0;
        String sql = "SELECT MAX(idSeguro) AS maxId FROM seguros";  // Consulta SQL para obtener el id máximo

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Si hay un resultado, obtener el valor máximo
            if (rs.next()) {
                idMaximo = rs.getInt("maxId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idMaximo;  // Retornar el idSeguro más grande, o 0 si no se encontró ningún seguro
    }
    
    public ArrayList<Seguro> obtenerSeguros() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ArrayList<Seguro> listaSeguros = new ArrayList<>();
        String sql = "SELECT * FROM seguros";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Seguro seguro = new Seguro();
                seguro.setIdSeguro(rs.getInt("IdSeguro"));
                seguro.setDescripcion(rs.getString("descripcion"));
                seguro.setIdTipo(rs.getInt("idTipo"));
                seguro.setCostoContratacion(rs.getFloat("costoContratacion"));
                seguro.setCostoAsegurado(rs.getFloat("costoAsegurado"));

                // Agregar el seguro a la lista
                listaSeguros.add(seguro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaSeguros;
    }
   
    
   
    
    
    
    

}
