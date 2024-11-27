/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaVista;

/**
 *
 * @author georg
 */

import javax.swing.JOptionPane;
import CapaControl.ControlFacade;
import capaModelo.Medicion;


public class ValidandoState implements EstadoMedida {
    @Override
    public void realizarAccion(pnlRegistrarMedidas pnl) {
        // Obtener los valores de los campos con los nuevos getters
        int userId = pnl.getId();  // ID debe ser un número entero
        double talla = pnl.getTalla();  // Talla como double
        double peso = pnl.getPeso();  // Peso como double

        // Validar que los valores sean correctos
        if (userId == -1 || talla == -1.0 || peso == -1.0) {
            // Si algún valor es inválido, mostrar mensaje de error
            JOptionPane.showMessageDialog(pnl, "Por favor complete todos los campos correctamente.");
        } else {
            // Crear el objeto Medicion
            Medicion nuevaMedicion = new Medicion(0,userId , talla, peso);

            // Llamar al ControlFacade para realizar la inserción en la base de datos
            ControlFacade controlFacade = new ControlFacade();
            controlFacade.registrarMedicion(nuevaMedicion);  // Insertar en la base de datos

            // Cambiar al estado Completado
            pnl.setEstado(new CompletadoState());  // Cambiar a estado Completado

            // Mensaje de éxito
            JOptionPane.showMessageDialog(pnl, "Las medidas se han guardado correctamente.");
        }
    }
}
