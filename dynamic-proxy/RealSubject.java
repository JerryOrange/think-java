/**
 * 代理的真实对象
 *
 * Created by Jiacheng on 2018/6/26.
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("Rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("Hello: " + str);
    }
}