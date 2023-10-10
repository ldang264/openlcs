package code.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        IVehicle car = new Car();

        IVehicle vehicle = (IVehicle) Proxy.newProxyInstance(car.getClass().getClassLoader(), Car.class.getInterfaces(), new VehicleInvacationHandler(car));
        vehicle.run();
    }

    public static class VehicleInvacationHandler implements InvocationHandler {

        private final IVehicle vehicle;

        public VehicleInvacationHandler(IVehicle vehicle) {
            this.vehicle = vehicle;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("---------before-------");
            Object invoke = method.invoke(vehicle, args);
            System.out.println("---------after-------");

            return invoke;
        }
    }

    public interface IVehicle {
        void run();
    }

    public static class Car implements IVehicle {
        public void run() {
            System.out.println("Car会跑");
        }
    }
}
