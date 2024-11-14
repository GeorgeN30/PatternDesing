package CapaControl;

import capaModelo.*;

import capaControl.ConsultaFactory;
import capaControl.IConsultaServicio;

import java.util.List;

public class ConsultaControl {
    private static ConsultaControl instancia;
    private IUsuarioDAO usuarioDAO;
    private IMedicionDAO medicionDAO;
   

    // Constructor privado
    private ConsultaControl() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
        medicionDAO = DAOFactory.getMedicionDAO();
        
    }

    // Método para obtener la única instancia de ConsultaControl
    public static ConsultaControl obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConsultaControl();
        }
        return instancia;
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuario(int id) {
        return usuarioDAO.obtenerUsuario(id);
    }

    // Método para obtener todas las mediciones de un usuario
    public List<Medicion> obtenerMediciones(int userId) {
        return medicionDAO.obtenerMedicionesPorUsuario(userId);
    }
    
    public double calcularYRegistrarIMC(int userId) {
        IConsultaServicio servicioIMC = ConsultaFactory.crearConsultaServicio("IMC");
        return servicioIMC.calcularYRegistrar(userId);
    }

    
}
