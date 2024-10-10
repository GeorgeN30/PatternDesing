/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaControl;

import capaModelo.DAOFactory;
import capaModelo.IIMCDAO;
import capaModelo.IMC;

/**
 *
 * @author georg
 */
public class RegisIMCImpl implements IRegisIMC {
    private IIMCDAO imcDAO;

    public RegisIMCImpl() {
        imcDAO = DAOFactory.getIMCDAO();
    }

    @Override
    public void registrarIMC(IMC imc) {
        imcDAO.insertarIMC(imc);
    }
}