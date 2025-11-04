package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import io.github.some_example_name.Main;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired()) return; // This handles macOS support and helps on Windows.
        createApplication();
    }

    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new Main(), getDefaultConfiguration());
    }

    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("GateDefender");
        /* //БЛОК Vsync
        // Vsync ограничивает количество кадров в секунду до того, которое может отображать ваше оборудование, и помогает устранить
        // разрыв экрана. Этот параметр не всегда работает в Linux, поэтому строка после него является защитной.
        configuration.useVsync(true); // Ограничивает частоту кадров в секунду частотой обновления текущего активного монитора, плюс 1, чтобы попытаться соответствовать частоте обновления
        // настройка Vsync должна ограничить фактическую частоту кадров в секунду, чтобы она соответствовала монитору.
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
        // Если вы удалите приведенную выше строку и установите для Vsync значение false, вы можете получить неограниченное количество кадров в секунду, что может быть
        // полезно для тестирования производительности, но также может быть очень напряженным для некоторого оборудования.
        // Вам также может потребоваться настроить драйверы графического процессора для полного отключения Vsync; это может привести к разрыву экрана.
        */
        configuration.setWindowedMode(640, 480);
        //// Вы можете изменить эти файлы; они находятся в каталоге lwjgl3/src/main/resources/ .
        ////  Их также можно загрузить из корневого каталога assets/ .
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
        configuration.setForegroundFPS(60);
        return configuration;
    }
}
