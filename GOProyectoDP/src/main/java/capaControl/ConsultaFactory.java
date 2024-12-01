/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaControl;

import capaModelo.IMCService;
public class ConsultaFactory {
    public static IConsultaServicio crearConsultaServicio(String tipoServicio) {
        // Este método crea y devuelve un servicio de consulta dependiendo del tipo pasado.
        switch (tipoServicio) {
            case "IMC":
                // Crear y devolver el servicio de IMC
                return new IMCService();
            
            default:
                throw new IllegalArgumentException("Tipo de servicio desconocido: " + tipoServicio);
        }
    }
}
