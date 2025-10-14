/*
Тут с помощью регулярок будем проверять пароли
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InspectorPass  {
    public static StatusPass checkPassword (String password){

        //cначала проверка на Плохой пароль, длинна, спецсимволы, англ буквы - ГОТОВО
        if (passwordBadCheck(password)) { //сли придет тру то пароль плохой
            return StatusPass.BAD;
        }
        //проверка на наличие в списке известных паролей - ГОТОВО
        //(вообще этот список надо прогнать через BAD метод, чтобы уменьшить его размер)
        if (passwordForbidenListCheck(password)) {//сли придет тру то пароль есть в списке 10к самых простых паролей
            return StatusPass.WEAK;
        }
        //проверка на наличие англ букв, если их нету то пароль слабый
        if (password.replaceAll("[^a-zA-Z]", "").equals("")) { //все НЕ английские буквы убираем, сравниваем с ничем, если тру то англ букв нет вообще а это слабый пароль
            return StatusPass.WEAK;
        }
        //проверка на часто повторяющиеся (3 и более раз) символы
        if (passwordRepeatedCharactersCheck(password)) {//сли придет тру то есть 3 и более повтора
            return StatusPass.WEAK;
        }


        if (passwordNormalCheck(password)) { //сли придет тру то пароль нормальный
            return StatusPass.NORMAL;
        }
        else   { //сли придет тру то пароль нормальный
            return StatusPass.STRONG;
        }

    }// end checkPassword

    private static boolean passwordForbidenListCheck(String passwordForbList) {//вернем тру если пароль в списке известных паролей
        Scanner scan;
        try {
            scan = new Scanner(new File("resources/forbidden_passwords_10k.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file forbidden_passwords_10k.txt");
        }

        while (scan.hasNext()){//пока есть еще слово
            String checkedWord = scan.next();
            if (checkedWord.equals(passwordForbList)){
                return true;
            }
        }//end while
        return false;

    }//end passwordForbidenListCheck

        //не сделан
    private static boolean passwordNormalCheck(String passNormal) {
        //пишем код
        return true;
    }
        //проверка на повторяющиеся подряд символы
    private static boolean passwordRepeatedCharactersCheck(String passRepeat) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < passRepeat.length(); i++) {
            char ch = passRepeat.charAt(i);
            map.merge(ch, 1, Integer::sum);
        }

        if (Collections.max(map.values()) >= 3) {
            return true; //сли тру то есть 3 и более повтора, слабый пароль
        } else {
            return false;
        }
    }

    private static boolean passwordBadCheck(String passBad){ //вернем тру если пароль плохой
        //проверка на null
        if (passBad == null) {
            throw new IllegalArgumentException("password cannot be null"); //сделать тест
        }
        //проверка на длинну пароля
        if (!passBad.matches("^.{8,22}$")) { // если длинна НЕ от 8 до 22 символов
            return true; //вернем тру если пароль не прошел проверку
        }
        //проверка на буквы латинского алфавита (если вообще содержит)
        if (!passBad.replaceAll("[\\\\!@#$%^&*()—_+=;:,./?|`~\\[\\]{}\\d]", "").matches("^[a-zA-Z]*$")){ //убрали спецсимволы и цифры, далее проверка если НЕ содержит английские буквы
            return true; //вернем тру если пароль не прошел проверку
        }
        //проверка на содержание спецсимволов
        if (passBad.replaceAll("[^\\\\!@#$%^&*()—_+=;:,./?|`~\\[\\]{}]", "").equals("")){// [^(крышечка делает НЕ) все что НЕ спецсимвол убираем, сравниваем с пустой строкой, если тру то нет спецсимволов
            return true; //вернем тру если пароль не прошел проверку
        }
        else {
            return false;
        }// end passwordBadCheck

        //пишем код

    }//end passwordBadCheck


}
