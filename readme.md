Тестовое задание от ScaleApp - https://novosibirsk.hh.ru/employer/2722874

Написать консольное Java приложение, выполняющие набор заданных арифметических операций.

Операции:

1) Сложение 2х и более чисел
2) Умножение 2х и более чисел
3) Умножение первых 2х чисел и сложение с 3м числом

Приложение может получать параметры либо из файла, либо вводом из консоли.

Приложение может выводить результат либо в файл, либо в консоль.

Режим работы определяется аргументами командной строки.

Если значение аргумента задано как "-", то это означает работу с консолью, иначе с файлом.

Примеры запуска с аргументами:

1) test-app - - <enter>
   (в данном случае получение параметров из консоли и вывод в консоль)

> add 10 20 <enter>
>
> Ответ: 30

2) test-app input.txt output.txt <enter>

   В файле input.txt строка:mul 1 2 3

   В файле output.txt строка: 6

Для суммирования - команда add Для умножения - команда mul Для x1*x2+x3 - команда sup