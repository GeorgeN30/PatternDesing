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

        Medicion ultimaMedicion = mediciones.get(mediciones.size() - 1);
        double imc = ultimaMedicion.getPeso() / (ultimaMedicion.getTalla() * ultimaMedicion.getTalla());

        IMC nuevoIMC = new IMC(0, ultimaMedicion.getId(), imc, new Date(System.currentTimeMillis()));
        imcDAO.insertarIMC(nuevoIMC);

        return imc;
    }
}
