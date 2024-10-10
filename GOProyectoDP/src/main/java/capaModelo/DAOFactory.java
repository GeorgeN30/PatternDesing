
package capaModelo;

/**
 *
 * @author georg
 */
public class DAOFactory {
    
     public static IUsuarioDAO getUsuarioDAO() {
       return new UsuarioDAO();
    }
     public static IMedicionDAO getMedicionDAO() {
        MedicionDAO medicionDAO = new MedicionDAO();
        if (medicionDAO == null) {
            System.out.println("Error: MedicionDAO es null en DAOFactory");
        } else {
            System.out.println("MedicionDAO se ha creado correctamente en DAOFactory");
        }
        return medicionDAO;
    
    }

    public static IIMCDAO getIMCDAO() {
        return new IMCDAO();
    }

   
}
