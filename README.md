# Task_8
Видео работы: https://vk.com/video/@g4st3r7?z=video305871474_456239515%2Fpl_305871474_-2

Задача 8. Многомерные (двумерные) массивы Входные данные для этой задачи должны читаться из текстового файла, а выходные – записываться в текстовый файл. Данная задача должна быть оформлена двумя способами:

1. В виде консольного приложения с разбором параметров командной строки,
2. В виде оконного приложения, где двумерный массив можно задать в JTable. При этом должна быть возможность загрузить данный из файла в JTable (реализованная в виде двух функций: чтение данных из файла в двумерный массив и отображение двумерного массива в JTable), а также сохранить данные из JTable в файл (реализованная в виде двух функций: чтение данных из JTable в двумерный массив и запись двумерного массива в файл). Функции, реализующие логику задачи и чтение / запись данных из файлов / в файлы, должны быть оформлены в виде отдельного модуля (в отдельном файле). Этот модуль без каких-либо изменений должен использоваться в двух программах: с консольным интерфесом (файлы для чтения / записи задаются в параметрах командной строки) и оконным интерфейсом. Заранее придумать не менее 5 различных тестов, охватывающих как типичные, так и все возможные граничные (наиболее невероятные и показательные) ситуации. (Сохранить в текстовых файлах input01.txt, input02.txt и т. д.) Решение, естественно, должно быть оформлено в виде отдельной функции. В реализации обязательно использовать вспомогательные функции (в этой задаче, какие именно вспомогательные функции использовать, не расписано, вы должны самостоятельно решить, какие именно будут удобны для вашего варианта). В данных задачах, если явно не оговорено иное, предполагается, что все строки двумерного массива имеют одинаковую длину, т.е. массив является прямоугольным. В реализации разрешено также использовать вместо прямоугольных массивов ступенчатые массивы (т.е. массивы массивов или списки списков). В этом случае необходимо дополнительно реализовать функцию проверки «прямоугольности» ступенчатого массива, которую применять для проверки корректности данных перед обработкой. Реализация в виде консольного приложения с разбором параметров командной строки Имена файлов для чтения и записи должны передаваться в параметрах командной строки, например, так:

Вариант №26
Для двух переданных прямоугольных массивов целых чисел определить, можно ли второй массив наложить на первый таким образом, чтобы значения в ячейках совпадали.
Функция должна вернуть координаты ячейки первого массива, на который требуется поместить верхний левый угол второго массива.

ArrayUtlis был очищен от ненужных методов и отредактирован под необходимые требования(прим. чтение и запись 2 матриц из одного файла с разделителем между матрицами)