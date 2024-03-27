import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PortScaner {

    private static final int THREADS = 100;// константа кол-во потоков
    private static final int TIMEOUT = 100;// константа время ожидания
    private static final int MIN_PORT_NUMBER = 0;// константа начало диапазона
    private static final int MAX_PORT_NUMBER = 65535;// константа конец диапазона

    public static void main(String[] args) {

        scan("easyoffer.ru");//вызываем метод scan и передаем ему адрес сканируемого ресурса
    }

    private static void scan(String host) {//метод scan принимает адрес в переменную host
        System.out.println("Scanning ports: ");//показываем в терминал что программа стартовала
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);//

        for (int i = MIN_PORT_NUMBER; i <= MAX_PORT_NUMBER; i++) {
            final int port = i;
            executor.execute(() -> {
                var inetSocketAddress = new InetSocketAddress(host, port);
                try (var socket = new Socket()) {
                    socket.connect(inetSocketAddress, TIMEOUT);
                    System.out.printf("Host: %s, port %s is opened\n", host, port);
                } catch (IOException ignored) {
                    //System.err.println(e.getMessage());
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finish!");
    }
}