/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaControl;


import capaModelo.DAOFactory;
import capaModelo.IMedicionDAO;
import capaModelo.Medicion;
import java.util.List;

/**
 *
 * @author georg
 */
public class RegisMedicionImpl implements IRegisMedicion {
    private IMedicionDAO medicionDAO;

    public RegisMedicionImpl() {
        medicionDAO = DAOFactory.getMedicionDAO();
        if (medicionDAO == null) {
            System.out.println("Error: medicionDAO es null en RegisMedicionImpl");
        } else {
            System.out.println("medicionDAO se ha inicializado correctamente en RegisMedicionImpl");
        }
    }

    @Override
    public void registrarMedicion(Medicion medicion) {
        if (medicionDAO == null) {
            System.out.println("Error: medicionDAO es null al intentar registrar una medición");
            return;
        }
        medicionDAO.insertarMedicion(medicion);
    }

    @Override
    public List<Medicion> obtenerMediciones(int userId) {
        if (medicionDAO == null) {
            System.out.println("Error: medicionDAO es null al intentar obtener mediciones");
            return null;
        }
        return medicionDAO.obtenerMedicionesPorUsuario(userId);
    }
}