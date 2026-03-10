package metier;

import dao.IDao1;
import  metier.*;

public class MetierImpl1 implements IMetier1 {
    private IDao1 dao1;

    public void setDao1(IDao1 dao1) {
        this.dao1 = dao1;
    }


    @Override
    public double calcul1() {
        return dao1.getValue() + 54;
    }

}
