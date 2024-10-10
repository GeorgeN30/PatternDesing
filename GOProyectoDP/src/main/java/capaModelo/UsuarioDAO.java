
package capaModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {
    
    private Connection conexion;

    public UsuarioDAO() {
        this.conexion = ConexionSingleton.obtenerInstancia().getConexion();
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        String sql = "{call GestionarUsuario('Insertar', NULL, ?, ?, ?, ?)}";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getEdad());
            ps.setString(3, String.valueOf(usuario.getSexo()));
            ps.setDate(4, usuario.getFechaRegistro());
            ps.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerUsuario(int id) {
        String sql = "{call GestionarUsuario('Obtener', ?, NULL, NULL, NULL, NULL)}";
        Usuario usuario = null;
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("Nombre"),
                    rs.getInt("Edad"),
                    rs.getString("Sexo").charAt(0),
                    rs.getDate("FechaRegistro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }


    @Override
    public void actualizarUsuario(Usuario usuario) {
        String query = "{call GestionarUsuario('Actualizar'?, ?, ?, ?, ?, ?)}";
    try (PreparedStatement ps = conexion.prepareStatement(query)) {
        ps.setString(1, "Actualizar");
            ps.setInt(2, usuario.getId());
            ps.setString(3, usuario.getNombre());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, String.valueOf(usuario.getSexo()));
            ps.setDate(6, null); 
            ps.executeUpdate();
            System.out.println("Usuario actualizado exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
       String query = "{CALL GestionarUsuario('ObtenerTodos')}";
    List<Usuario> usuarios = new ArrayList<>();
    try (PreparedStatement ps = conexion.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Usuario usuario = new Usuario(
                rs.getInt("id"),
                rs.getString("Nombre"),
                rs.getInt("edad"),
                rs.getString("sexo").charAt(0),  // Convertir a char el valor del sexo
                rs.getDate("fechaRegistro")
            );
            usuarios.add(usuario);
        }
        System.out.println("Usuarios obtenidos exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return usuarios;    
    }
}
