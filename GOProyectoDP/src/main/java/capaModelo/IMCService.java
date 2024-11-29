package capaModelo;

import capaControl.IConsultaServicio;
import java.sql.Date;
import java.util.List;

public class IMCService implements IConsultaServicio {
    private IMCDAO imcDAO;
    private MedicionDAO medicionDAO;

    public IMCService() {
        this.imcDAO = new IMCDAO();
        this.medicionDAO = new MedicionDAO();
    }

@Override
public double calcularYRegistrar(int userId) {
    List<Medicion> mediciones = medicionDAO.obtenerMedicionesPorUsuario(userId);
    if (mediciones == null || mediciones.isEmpty()) {
        System.out.println("No se encontraron mediciones para el usuario.");
        return -1;
    }

    // Obtener la última medición
    Medicion ultimaMedicion = mediciones.get(mediciones.size() - 1);
    // Obtener peso y talla directamente desde ultimaMedicion
    double peso = ultimaMedicion.getPeso();
    double talla = ultimaMedicion.getTalla();

    // Verificar que los valores sean válidos
    if (peso <= 0 || talla <= 0) {
        System.out.println("Valores de peso o talla no válidos.");
        return -1;
    }

    // Convertir la talla a metros (si está en cm)
    double tallaEnMetros = talla / 100.0;  // Conversión de cm a metros

    // Calcular el IMC
    double imc = peso / (tallaEnMetros * tallaEnMetros);

    // Crear el nuevo objeto IMC
    IMC nuevoIMC = new IMC(0, ultimaMedicion.getId(), imc, new Date(System.currentTimeMillis()));

    // Registrar el nuevo IMC
    imcDAO.insertarIMC(nuevoIMC);

    // Retornar el IMC calculado
    return imc;
}

}
