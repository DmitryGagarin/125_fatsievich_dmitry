public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        // Пусть num =sqrt(a) . Если num * num = a, то число a является полным квадратом.
        // fullSquare = a, partSquare = num
        int partSquare = 0;
        int fullSquare = 0;
        while (partSquare <= num){
            if(partSquare*partSquare <= num)
                fullSquare = partSquare*partSquare;
            else
                break;
            partSquare++;
        }
        return fullSquare;
    }

    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        int function = 1; //p(0)
        int changeK = 1; //k=1, это к, которое будет меняться
        int k = 1; //k=1 Изначально
        int sum = 0; //сумма
        if (num == 0)
            return function;
        if (num > 0) {
            while (changeK <= num) {
                sum = 2 * k + 6;
                changeK++;
                k = sum;
            }
            return sum;
        }
        return sum;
    }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base
        // то есть num - натуральное число
        int powBase = base;
        while (num >= powBase && num != powBase) {
            powBase = powBase * base;
        }
        return powBase == num;
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
        int operaNumb = 0; //изначальное число операций
        float iStart = start; //создаем переменную
        while (iStart > end) {
            if ((iStart % 2 == 0) && (end < iStart / 2)) {
                //если старт делится на 2 без остатка и если енд меньше половины старта
                iStart = iStart / 2; //делим старт на 2 и запомниаем новое значение и начинаем алгоритм заново
            } else { //если одно из условий не было соблюдено, то есть старт не делится на 2 без остатка или енд
                //больше половины старта, мы начинаем из старта вычитать по единичке и прибавлять по единичке к
                //кол ву операций
                iStart = iStart - 1;
            }//если этот старт делится на 2 без остатка и енд меньше половины старта, то все начинается заново, если
            //условия не соблюдены, то старт просто будет уменьшаться до значение енда
            operaNumb++;
        }
        return operaNumb;
    }
}

