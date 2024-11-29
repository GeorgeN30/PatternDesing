/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaVista;

import CapaControl.ControlFacade;
import capaModelo.Usuario;

/**
 *
 * @author georg
 */
public class ConsultarUsuarioCommand implements Command {
    private ControlFacade controlFacade;
    private int userId;
    private pnlConsultarUsuario vista;

    public ConsultarUsuarioCommand(ControlFacade controlFacade, int userId, pnlConsultarUsuario vista) {
        this.controlFacade = controlFacade;
        this.userId = userId;
        this.vista = vista;
    }

    @Override
    public void execute() {
        // Consultar el usuario utilizando ControlFacade
        Usuario usuario = controlFacade.obtenerUsuario(userId);
        
        // Actualizar la vista (tabla) con la información del usuario
        vista.mostrarUsuario(usuario);
    }
}