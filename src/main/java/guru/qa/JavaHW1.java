package guru.qa;

public class JavaHW1 {
    public static void main (String [] args){
        // поупражняться с математическими и логическими операторами
        int a = 20;
        int b = 7;

        // арифметические
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

        // сравнения
        if (a == 2) {
            System.out.println("Ho ho ho");
        } else if (a > 21) {
            System.out.println("Oh oh oh");
        } else {
            System.out.println("No no no");
        }
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(a < b);
        System.out.println(a <= b);

        // логические
        if (a == 20  && b == 7) {
            System.out.println("Bobo");
        }
        if (a != 20 || b > 10) {
            System.out.println("A != 5 or b > 3");
        } else {
            System.out.println("Nothing");
        }


        // переполнение при вычислениях
        int overflow = Integer.MAX_VALUE;
        System.out.println("So many" + (overflow + 1));


        // попробовать вычисления комбинаций типов данных (int и double)
        int varInt = 33;
        double varDouble = 5.3;
        double divDouble = 10.1;
        System.out.println(varInt - varDouble);
        System.out.println(varInt + varDouble);
        System.out.println(varInt * varDouble);
        System.out.println(varInt / varDouble);
        System.out.println(varDouble * divDouble);
        if (varDouble != 5.3) {
            System.out.println("Hospade");
        } else {
            System.out.println("Hospade iisuse");
        }
    }
}
