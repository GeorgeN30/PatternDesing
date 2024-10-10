/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capaModelo;

import java.util.List;


public interface IMedicionDAO {
    void insertarMedicion(Medicion medicion);
    void actualizarMedicion(Medicion medicion);
    
    Medicion obtenerMedicion(int id);
    List<Medicion> obtenerMedicionesPorUsuario(int userId);
}
