import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Jiacheng on 2018/6/26.
 */
public class Client {
    public static void main(String[] args) {
        //我们要代理的真实对象
        Subject realSubject = new RealSubject();

        //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，
         * 我们来看看其三个参数 第一个参数 handler.getClass().getClassLoader()
         * 我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，
         * 表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的InvocationHandler这个对象上
         */
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);

        /*
         * 通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，也不是我们定义的那组接口的类型
         * 而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号
         */
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
    }
}
