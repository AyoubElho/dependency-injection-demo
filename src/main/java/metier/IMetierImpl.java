package metier;

import dao.IDao;

public class IMetierImpl implements IMetier {
    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        double res = data * 23;
        return res;
    }
}
