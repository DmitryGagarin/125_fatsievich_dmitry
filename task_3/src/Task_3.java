public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int count = 0;
        if (n2 > n1) {
            for (int x = n1; x <= n2; x++) {
                if ((x % a == 0) && (x % b != 0)) {
                    count++;
                }
            }
        }
        if (n2 < n1) {
            for (int x = n2; x <= n1; x++) {
                if ((x % a == 0) && (x % b != 0)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int pos = 0;
        int numAtPos = 1;
        for (int i=1; i<=num; i++){
            for(int j=1; j <= i; j++ ){
                pos++;
                if (pos==num) numAtPos = i;
            }
        }
        return numAtPos;
    }



    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int firstNumber = num;
        int summa = firstNumber;
        for (int i = 1; i < cnt; i++){
            summa = summa + firstNumber * d + 1;
            firstNumber = firstNumber * d + 1;
        }
        return summa;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // S(n) = 1! + 2! + 3! + ... + n!
        // (n! - это n-факториал. Кто не знает - гуглите)
        // n! = 1*2*3*...*n*(n+1)
        int summa = 0; //конечное значение
        int itog = 1; //промежуточное значение
        for (int i = 1; i <= n; i++){
            itog = itog * i;
            summa = summa + itog;
        }
        return summa;

    }
}
