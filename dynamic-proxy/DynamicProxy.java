import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 *
 * Created by Jiacheng on 2018/6/26.
 */
public class DynamicProxy implements InvocationHandler {
    //这个就是我们要代理的真实对象
    private Object subject;

    //构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    /**
     *
     * @param object 所代理的那个真实对象
     * @param method 我们所要调用真实对象的某个方法的Method对象
     * @param args   调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent house");
        System.out.println("Method:" + method);
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);
        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after rent house");
        return null;
    }
}
