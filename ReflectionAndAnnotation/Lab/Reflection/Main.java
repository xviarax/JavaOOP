package ReflectionLab.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // get the class information
        Class<Reflection> cl = Reflection.class;
        // get all interfaces a class implements
        Class[] interfacesOfCl = cl.getInterfaces();
        // get class constructor
        Constructor<Reflection> clConstructor = cl.getDeclaredConstructor();
        // initialize object:
        Reflection reflection = clConstructor.newInstance();

        // print class type + name of class:
        System.out.println(cl);
        // print type of parent class + name of parent class
        System.out.println(cl.getSuperclass());
        // print all interfaces:
        Arrays.stream(interfacesOfCl).forEach(System.out::println);
        // print initialized object:
        System.out.println(reflection);

    }
}
