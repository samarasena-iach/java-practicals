package ReflectionAPI;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverClassForReflection {

    public static void main(String[] args) {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff", "Bezos", 57, "Amazon", 600000.0),
                new Employee(2, "Elon", "Musk", 49, "Space X, Tesla, PayPal", 500000.0),
                new Employee(3, "Bill", "Gates", 65, "Microsoft", 400000.0),
                new Employee(4, "Mark", "Zuckerberg", 39, "Facebook", 300000.0)
        };

        List<Employee> employeeList = Arrays.asList(arrayOfEmps);

        Field[] fieldsArray = Employee.class.getDeclaredFields();
        System.out.println(employeeList.getClass().getSimpleName());
        System.out.println("Class : " + employeeList.getClass());

        System.out.println("Fields : ");
        for (Field f : fieldsArray) {
            System.out.println(f.getName());
        }

        getFields(arrayOfEmps);
    }

    public static <T> List<Field> getFields(T t) {
        List<Field> fields = new ArrayList<>();
        Class<?> c = t.getClass();
        while (c != Object.class) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
            c = c.getSuperclass();
        }
        return fields;
    }

}
