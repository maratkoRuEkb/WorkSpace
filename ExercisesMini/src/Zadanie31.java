import java.util.Map;
/*
    Задание 31 - ВЫПОЛНЕНО
    Напишите программу на Java, чтобы проверить, установлена ли Java на вашем компьютере.
Ожидаемый результат

 Версия Java: 1.8.0_71
Java Runtime Version: 1.8.0_71-b15
Домашняя страница Java: /opt/jdk/jdk1.8.0_71/jre
Поставщик Java: корпорация Oracle
URL поставщика Java: http://Java.oracle.com/
Java Class Path:.
+ сделал выведение всех переменных системы
*/
public class Zadanie31 {
    public static void main(String[] args) {
        System.out.println("Version Java: " + System.getProperty("java.version"));
        System.out.println("OS version: " + System.getProperty("os.version"));
        System.out.println("Java Runtime Version: " + System.getProperty("java.specification.version"));
        System.out.println("Java installation directory: " + System.getProperty("java.home"));
        System.out.println("vendor Java: " + System.getProperty("java.vendor"));
        System.out.println("URL vendor Java: " + System.getProperty("java.vendor.url"));
        System.out.println("Java Class Path: " + System.getProperty("java.class.path"));
        System.out.println("user name: " + System.getProperty("user.name"));
        System.out.println("");
        System.out.println("Properties "+System.getenv());

        Map<String, String> env = System.getenv(); //
        System.out.println(env.get("ProgramData")); //вызов одного конкретного ключа

        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName)); // Формат: строка=строка/следующая строка/
            //System.out.println(envName); // Формат: строка=строка/следующая строка/
        }


    }
}
