public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int counter = 0;
        if (n2>n1) {
            for (int i = n1; i <= n2; i++) {
                if ((i % a == 0) && (i % b != 0)) counter++;
            }
        }
        if (n2<n1){
            for (int j = n2; j <= n1; j++){
                if ((j % a == 0) && (j % b !=0)) counter++;
            }
        }
        return counter;
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
        for (int i = 1; i <= num; i++){
            for(int j = 1; j <=i; j++){
                pos++;
                if (pos == num) numAtPos = i;
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
        // a(0) равно 1, поэтому i начинается от 1
        int b, summa = num;
        for (int i = 1; i < cnt; i++){
            b = num * d + 1;
            summa += b;
            num = b;
        }
        return summa;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int summa = 0;
        int result = 1;
        for(int i = 1; i <= n; i++){
            result = result * i;
            summa = summa + result;
        }
        return summa;
    }
}
