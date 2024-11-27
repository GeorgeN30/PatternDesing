/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaVista;

import javax.swing.JOptionPane;

/**
 *
 * @author georg
 */
public class CompletadoState implements EstadoMedida {
    @Override
    public void realizarAccion(pnlRegistrarMedidas pnl) {
        // Mostrar mensaje de que el proceso está completado
        JOptionPane.showMessageDialog(pnl, "Registro completado. Puede ingresar nuevas medidas.");
        pnl.limpiarCampos();
    }
}
