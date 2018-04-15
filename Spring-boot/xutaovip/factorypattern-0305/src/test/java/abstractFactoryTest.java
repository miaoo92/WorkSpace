import abstr.CarFactory;

public class abstractFactoryTest {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        System.out.println(factory.getBwm());
    }
}
