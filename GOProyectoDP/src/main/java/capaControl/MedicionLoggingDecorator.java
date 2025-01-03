
package capaControl;

import capaModelo.Medicion;
import java.util.List;

public class MedicionLoggingDecorator implements IRegisMedicion {
    private IRegisMedicion medicionControl;

    // Constructor que recibe el objeto a decorar
    public MedicionLoggingDecorator(IRegisMedicion medicionControl) {
        this.medicionControl = medicionControl;
    }

    @Override
    public void registrarMedicion(Medicion medicion) {
        // Funcionalidad adicional antes de registrar la medición
        System.out.println("[LOG] Iniciando registro de medición: ");
        
        // Delegar la operación al objeto original
        medicionControl.registrarMedicion(medicion);
        
        // Funcionalidad adicional después de registrar la medición
        System.out.println("[LOG] Medición registrada exitosamente: ");
    }
    
    @Override
    public void actualizarMedicion(Medicion medicion) {
        // Funcionalidad adicional antes de registrar la medición
        System.out.println("[LOG] Iniciando Actualizacion de medición: ");
        
        // Delegar la operación al objeto original
        medicionControl.registrarMedicion(medicion);
        
        // Funcionalidad adicional después de registrar la medición
        System.out.println("[LOG] Medición Actualizada exitosamente: ");
    }

    @Override
    public List<Medicion> obtenerMediciones(int userId) {
        // Delegar directamente sin añadir funcionalidad adicional
        return medicionControl.obtenerMediciones(userId);
    }
}