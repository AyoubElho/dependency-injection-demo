package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("metier")
public class IMetierImpl implements IMetier {

    private IDao dao;

    IMetierImpl(@Qualifier("dao2") IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        double res = data * 23;
        return res;
    }
}
