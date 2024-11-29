package CapaControl;


import capaModelo.Medicion; 
import capaModelo.Usuario; 
import java.util.List;

public class ControlFacade{
    private RegistroControl registroControl;
    private ConsultaControl consultaControl;
    
    

public ControlFacade() {
    registroControl = RegistroControl.obtenerInstancia(); 
    consultaControl = ConsultaControl.obtenerInstancia(); 
}

    // Método para registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) {
        registroControl.registrarUsuario(usuario);
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuario(int id) {
        return consultaControl.obtenerUsuario(id);
    }
    public void actualizarUsuario(Usuario usuario){
        registroControl.actualizarUsuario(usuario);
    }
    
    // Método para registrar una nueva medición
    public void registrarMedicion(Medicion medicion) {
        registroControl.registrarMedicion(medicion);
    }
    public double calcularYRegistrarIMC(int userId) {
        return consultaControl.calcularYRegistrarIMC(userId);
    }
    

    // Método para obtener todas las mediciones de un usuario
    public List<Medicion> obtenerMediciones(int userId) {
        return consultaControl.obtenerMediciones(userId);
    }
    
    
}
