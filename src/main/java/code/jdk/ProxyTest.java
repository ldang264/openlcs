package code.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        IVehical car = new Car();

        IVehical vehical = (IVehical) Proxy.newProxyInstance(car.getClass().getClassLoader(), Car.class.getInterfaces(), new VehicalInvacationHandler(car));
        vehical.run();
    }

    public static class VehicalInvacationHandler implements InvocationHandler {

        private final IVehical vehical;

        public VehicalInvacationHandler(IVehical vehical) {
            this.vehical = vehical;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("---------before-------");
            Object invoke = method.invoke(vehical, args);
            System.out.println("---------after-------");

            return invoke;
        }
    }

    public interface IVehical {
        void run();
    }

    public static class Car implements IVehical {
        public void run() {
            System.out.println("Car会跑");
        }
    }
}
