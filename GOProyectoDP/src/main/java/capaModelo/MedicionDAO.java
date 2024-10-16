
package capaModelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicionDAO implements IMedicionDAO {
    private Connection connection;

    public MedicionDAO() {
        try {
        this.connection = ConexionSingleton.obtenerInstancia().getConexion();
        if (this.connection == null) {
            System.out.println("Error: La conexión es null en MedicionDAO");
        } else {
            System.out.println("Conexión establecida correctamente en MedicionDAO");
        }
    } catch (Exception e) {
        System.out.println("Error en el constructor de MedicionDAO: " + e.getMessage());
        e.printStackTrace();
    }
    }



    @Override
    public void insertarMedicion(Medicion medicion) {
    String sql = "{CALL GestionarMedicion(?, ?, ?, ?, ?)}";
    try (CallableStatement cs = connection.prepareCall(sql)) {
        cs.setString(1, "Insertar");
        cs.setNull(2, Types.INTEGER); // ID autogenerado
        cs.setInt(3, medicion.getUserId()); // Asegúrate de que es getUserId()
        cs.setDouble(4, medicion.getPeso());
        cs.setDouble(5, medicion.getTalla());
        cs.executeUpdate();
        System.out.println("Medición registrada exitosamente.");
    } catch (SQLException e) {
        System.out.println("Error al insertar la medición: " + e.getMessage());
        e.printStackTrace();
    }
}

    @Override
    public Medicion obtenerMedicion(int id) {
        String sql = "{call GestionarMedicion('Obtener', ?, NULL, NULL, NULL)}";
        Medicion medicion = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Asegúrate de usar getDouble para obtener los valores de decimal
                medicion = new Medicion(
                        rs.getInt("id"),
                        rs.getInt("UserID"),
                        rs.getDouble("peso"), // Usa getDouble aquí
                        rs.getDouble("talla")  // Usa getDouble aquí
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicion;
    }

    @Override
    public void actualizarMedicion(Medicion medicion) {
        String sql = "{call GestionarMedicion('Actualizar', ?, ?, ?, ?)}";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, medicion.getUserId());
            ps.setDouble(2, medicion.getPeso()); // Asegúrate de usar setDouble
            ps.setDouble(3, medicion.getTalla()); // Asegúrate de usar setDouble
            ps.setInt(4, medicion.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
     public List<Medicion> obtenerMedicionesPorUsuario(int userId) {
        List<Medicion> mediciones = new ArrayList<>();
        String sql = "{call GestionarMedicion('ObtenerPorUsuario', NULL, ?)}";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);  // Establecer el parámetro de usuario
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicion medicion = new Medicion(
                        rs.getInt("id"),
                        rs.getInt("UserID"),
                        rs.getDouble("peso"),
                        rs.getDouble("talla")
                );
                mediciones.add(medicion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mediciones;
    }
}