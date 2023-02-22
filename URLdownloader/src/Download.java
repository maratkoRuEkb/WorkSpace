import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.*;



public class Download {
    public static void main (String[] args){
            new Download().go();
        }

        private void go() {
            try {// пробуем и ловим исключения
                URL url = new URL("https://ic.pics.livejournal.com/serg_zagatin/8710798/30784/30784_600.jpg"); //создаем объект URL и передаем ему ссылку
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                FileOutputStream fos = new FileOutputStream("picture.jpg");
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



}
