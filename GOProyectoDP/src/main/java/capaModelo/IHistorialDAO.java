
package capaModelo;

import java.util.List;

/**
 *
 * @author georg
 */
public interface IHistorialDAO {
    void insertarHistorial(Historial historial);
    void actualizarHistorial(Historial historial);
    Historial obtenerHistorial(int id);
    List<Historial> obtenerHistorialPorUsuario(int usuarioId);
}
