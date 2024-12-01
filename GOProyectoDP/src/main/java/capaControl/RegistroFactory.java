
package capaControl;

import capaModelo.DAOFactory;
import capaModelo.IUsuarioDAO;


public class RegistroFactory {
    public static IRegisUsuario crearRegistroUsuario() {
      IUsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
        return new RegisUsuarioImpl(usuarioDAO);
    }

    public static IRegisMedicion crearRegistroMedicion() {
        IRegisMedicion medicionImpl = new RegisMedicionImpl();
        return new MedicionLoggingDecorator(medicionImpl);
    }
    
    public static IRegisMedicion  crearActualizarMedicion(){
        IRegisMedicion actualizacionImpl = new RegisMedicionImpl();
        return new MedicionLoggingDecorator(actualizacionImpl);
    }

    public static IRegisIMC crearRegistroIMC() {
        return new RegisIMCImpl();
    }
    
}