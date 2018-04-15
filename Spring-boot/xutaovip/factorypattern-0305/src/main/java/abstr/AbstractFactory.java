package abstr;

import domain.BWM;
import domain.Benzi;

/**
 *
 * 抽象工厂是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 * 易于扩展
 * Created by miaoo on 2018/3/5.
 */
public abstract class AbstractFactory {

    public abstract Benzi getBenzi();

    public abstract BWM getBwm();

}
