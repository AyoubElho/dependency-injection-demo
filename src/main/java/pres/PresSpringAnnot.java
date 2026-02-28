package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnot {
    static void main() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ext", "metier","dao");
        IMetier iMetier = applicationContext.getBean(IMetier.class);
        System.out.println(iMetier.calcul());
    }
}
