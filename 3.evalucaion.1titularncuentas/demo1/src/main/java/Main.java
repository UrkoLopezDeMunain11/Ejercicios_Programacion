
import Utilidades.DBConnection;
import Vista.MenuTitulares;


public class Main {
    public static void main(String[] args) {
        DBConnection.crearEMF();


        /*
        aqui ne el main cuando e n los ejercicios hay mas de una clase, llamaremos a una clase principla donde habra un menu
        q te da pa elegir en este caso cuenta o titular. si le da a titular te llevaria al menu titular y de ahi llmaria al controller y
        si le da al de cuesta pues lo mismo. entonces en vista estaria ña clase menuprincipal , menucuenta y menutitular
         */
        MenuTitulares menu = new MenuTitulares();
        menu.mostrarMenu();

    }
}
