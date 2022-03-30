import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {

        String strIn;
        int num3 = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение из двух арабских или римских чисел, не используйте отрицательные числа и числа больше 10:");
        strIn = in.nextLine();
        System.out.println("Вы ввели: "+strIn);
        in.close();

        String[] n;
        n = strIn.trim().split("\\s*(\\+|-|\\*|/|\\s)\\s*");

        int a = 0;
        int c = 0;

        try {
            if (n.length > 2) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            for (int i = 0; i < n.length;i++) {
                if (n[i].matches("I*|IV|V|VI|VII|VIII|IX|X")) {
                    a++;
                }
                if (n[i].matches("\\d*")) {
                    c++;
                }
                if ((c != 0) & (a == 0)) {
                    if (Integer.parseInt(n[i].trim())>10) throw new Exception("Операдн больше 10 запрещено использовать!");
                }
            }

            if (a == 1 & c == 1) throw new Exception("Используются одновременно разные системы счисления");
            if ((a == 1 & c == 0) | (a == 0 & c == 1)) throw new Exception("Строка не является математической операцией!");

            Number num1 = new Number();
            Number num2 = new Number();

            if (n[0].matches("I*|IV|V|VI|VII|VIII|IX|X") && n[1].matches("I*|IV|V|VI|VII|VIII|IX|X")) {
                RomanToArabic strRoman1 = new RomanToArabic();
                num1.setNum(strRoman1.convert(n[0]));
                if (num1.getNum()>10) throw new Exception("Операдн больше 10 запрещено использовать!");
                System.out.println(num1.getNum());

                RomanToArabic strRoman2 = new RomanToArabic();
                num2.setNum(strRoman2.convert(n[1]));
                if (num2.getNum()>10) throw new Exception("Операдн больше 10 запрещено использовать!");
                System.out.println(num2.getNum());
            } else {
                num1.setNum(n[0]);
                num2.setNum(n[1]);
            }

            boolean plus = strIn.contains("+");
            if (plus)
                num3 = num1.getNum() + num2.getNum();

            boolean minus = strIn.contains("-");
            if (minus)
                num3 = num1.getNum() - num2.getNum();

            boolean multiply = strIn.contains("*");
            if (multiply)
                num3 = num1.getNum() * num2.getNum();

            boolean divide = strIn.contains("/");
            if (divide)
                if (num2.getNum() == 0) {
                    throw new Exception("Делить на ноль незля!");
                } else {
                    num3 = num1.getNum() / num2.getNum();
                }

            if (a == 2 && num3 < 1) throw new Exception("В римской системе нет чисел меншьше I, вы ввели выражение рультат которого меньше I.");

            if (a == 2) {
                ArabicToRoman arb = new ArabicToRoman();
                String numStr = arb.convertNumToRoman(num3);
                System.out.println("Ответ: "+numStr);
            } else {
                System.out.println("Ответ: "+num3);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}