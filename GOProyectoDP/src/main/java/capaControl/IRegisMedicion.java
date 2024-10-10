/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capaControl;

import capaModelo.Medicion;
import java.util.List;

/**
 *
 * @author georg
 */
public interface IRegisMedicion {
    void registrarMedicion(Medicion medicion);
    List<Medicion> obtenerMediciones(int userId);
}
