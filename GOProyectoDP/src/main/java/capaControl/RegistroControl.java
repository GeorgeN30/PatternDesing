package CapaControl;

import capaModelo.Usuario;
import capaModelo.Medicion;
import capaModelo.IMC;
import capaControl.RegistroFactory;
import capaControl.IRegisIMC;
import capaControl.IRegisMedicion;
import capaControl.IRegisUsuario;
import java.util.List;




public class RegistroControl {
    private static RegistroControl instancia;
    private final IRegisUsuario registrarUsuario;
    private final IRegisMedicion registrarMedicion;
    private final IRegisMedicion actualizarMedicion;
    private final IRegisIMC registrarIMC;
    

    private RegistroControl() {
        registrarUsuario = RegistroFactory.crearRegistroUsuario();
        registrarMedicion = RegistroFactory.crearRegistroMedicion();
        actualizarMedicion = RegistroFactory.crearActualizarMedicion();
        registrarIMC = RegistroFactory.crearRegistroIMC();
    }

    public static RegistroControl obtenerInstancia() {
        if (instancia == null) {
            instancia = new RegistroControl();
        }
        return instancia;
    }

    public void registrarUsuario(Usuario usuario) {
        registrarUsuario.registrarUsuario(usuario);
    }
    public void actualizarUsuario(Usuario usuario) {
        registrarUsuario.actualizarUsuario(usuario);
    }


    public void registrarMedicion(Medicion medicion) {
        registrarMedicion.registrarMedicion(medicion);
    }
    
    public void actualizarMedicion(Medicion medicion){
        actualizarMedicion.actualizarMedicion(medicion);
    }

    public void registrarIMC(IMC imc) {
        registrarIMC.registrarIMC(imc);
    }
    public List<Medicion> obtenerMediciones(int userId) {
        return registrarMedicion.obtenerMediciones(userId);
    }
    
}