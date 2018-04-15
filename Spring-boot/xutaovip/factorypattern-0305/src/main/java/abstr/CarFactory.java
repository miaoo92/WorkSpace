package abstr;

import domain.BWM;
import domain.Benzi;

public class CarFactory extends AbstractFactory {
    @Override
    public Benzi getBenzi() {
        return new Benzi();
    }

    @Override
    public BWM getBwm() {
        return new BWM();
    }
}
