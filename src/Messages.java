public class Messages {
    public static void printFileNotFound(String inputFilePath) {
        System.out.println("Файл не найден. Работа завершена");
    }

    public static void printFileIsEmpty(String inputFilePath) {
        System.out.println("Файл не содержит данных. Работа завершена");
    }

    //TODO make keys for command line to get help
    public static void printHelpInfo() {
        System.out.println("Для работы с файлом запустите программу с ключом -");
        System.out.println("Программа обрабатывает команду с консоли или команду, содержащуюся в файле.");
        System.out.println("Доступны три оператора - add, mul, sup");
        System.out.println();

        printAddCommandInfo();
        printMulCommandInfo();
        printSupCommandInfo();
    }

    public static void printAddCommandInfo() {
        System.out.println("Формат команды add:");
        System.out.println("add 1 3 254 658 ");
        System.out.println("После add через пробел(ы) указываются числа.");
        System.out.println("Количество чисел не меньше двух.");
        System.out.println("Заданные числа суммируются.");
        System.out.println();
    }

    public static void printMulCommandInfo() {
        System.out.println("Формат команды mul:");
        System.out.println("mul 1 3 254 658 ");
        System.out.println("После mul через пробел(ы) указываются числа.");
        System.out.println("Количество чисел не меньше двух.");
        System.out.println("Заданные числа перемножаются.");
        System.out.println();
    }

    public static void printSupCommandInfo() {
        System.out.println("Формат команды sup:");
        System.out.println("sup 1 3 254");
        System.out.println("После sup через пробел(ы) указываются числа.");
        System.out.println("Количество чисел для команды - три.");
        System.out.println("Первые два числа перемножаются, третье прибавляется к полученному результату");
        System.out.println("Числа, начиная с четвертого, будут игнорироваться и не принимают участия в расчетах.");
        System.out.println();
    }

    public static void printFileNotCorrect() {
        System.out.println("В файле неверная команда.");
    }
}