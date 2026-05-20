package vallegrande.edu.pe.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3307/usuario";

    private static final String USER = "root";

    private static final String PASSWORD = "123456";

    public static Connection getConexion() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("✅ Conexión exitosa");

        } catch (Exception e) {

            System.out.println("❌ Error de conexión");

            e.printStackTrace();
        }

        return con;
    }
}