package pres;

import dao.DaoImpl;
import metier.IMetierImpl;

public class Presentation {
    static void main() {
        DaoImpl dao = new DaoImpl();
        IMetierImpl iMetier = new IMetierImpl();
        iMetier.setDao(dao);
        System.out.println(iMetier.calcul());

    }
}
