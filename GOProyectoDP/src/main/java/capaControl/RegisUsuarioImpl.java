/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaControl;


import capaModelo.IUsuarioDAO;
import capaModelo.Usuario;

/**
 *
 * @author georg
 */
public class RegisUsuarioImpl implements IRegisUsuario{
    private  IUsuarioDAO usuarioDAO;

    public RegisUsuarioImpl(IUsuarioDAO usuarioDAO) {
       this.usuarioDAO = usuarioDAO;
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.insertarUsuario(usuario);
    }
    @Override
    public Usuario obtenerUsuario(int id) {
        return usuarioDAO.obtenerUsuario(id);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioDAO.actualizarUsuario(usuario);
    }
    
}
