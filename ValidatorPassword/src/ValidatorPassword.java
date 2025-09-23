
/*
будем проверять пароли на соответствие требованиям и покроем все тестами
Требования к паролю
- Не должен быть короче 8 и длиннее 22 символов
- Содержит буквы исключительно латинского алфавита (если вообще содержит)
- Обязательно содержит хотя бы 1 спецсимвол: @ ! # $ % ^ & * ( ) — _ + = ; : , . / ? \ | ` ~ [ ] { }
 */

public class ValidatorPassword {
    public static void main(String[] args) {
        String password = "1235ghj";
        //потом можно заменить на ввод с терминала

        StatusPass sp = StatusPass.BAD; //это временная заглушка, статус должен в Инспекторе присваиваться и возвращать стринг sp

        switch (sp){
            case BAD:
                System.out.println("ваш пароль плохой");
                break;
            case WEAK:
                System.out.println("ваш пароль плохой");
                break;
            case NORMAL:
                System.out.println("ваш пароль плохой");
                break;
            case STRONG:
                System.out.println("ваш пароль плохой");
                break;
        }

    }
}
