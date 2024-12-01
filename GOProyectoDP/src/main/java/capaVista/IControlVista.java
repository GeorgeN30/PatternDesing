/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capaVista;

/**
 *
 * @author georg
 */
public interface IControlVista {
     void registrarUsuario(String nombre, int edad, char sexo);
     void actualizarUsuario(int id, String nombre, int edad, char sexo);
}
