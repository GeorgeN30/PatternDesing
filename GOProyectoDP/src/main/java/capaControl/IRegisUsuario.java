/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capaControl;

import capaModelo.Usuario;

/**
 *
 * @author georg
 */
public interface IRegisUsuario {
    public void registrarUsuario(Usuario usuario);
    Usuario obtenerUsuario(int id);
    void actualizarUsuario(Usuario usuario);
}
