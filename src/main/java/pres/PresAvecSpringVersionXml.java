package pres;

import metier.IMetier;
import metier.IMetierImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAvecSpringVersionXml {
    static void main() {
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("config.xml");
        IMetier iMetier = (IMetier) applicationContext.getBean("metier");
        System.out.println(iMetier.calcul());
    }
}
