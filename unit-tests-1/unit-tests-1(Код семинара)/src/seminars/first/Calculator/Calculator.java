package seminars.first.Calculator;

import java.util.Scanner;
public class Calculator {
    private static final Scanner scanner;

    public Calculator() {
    }

    public static void main(String[] args) {
    }


    public static int getOperand() {
        System.out.println("Enter operand: ");
        int operand;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("You have mistaken, try again");
            if (!scanner.hasNext()) {
                throw new IllegalStateException("Input error");
            }

            scanner.next();
            operand = getOperand();
        }

        return operand;
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
            if(num < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number");
            }
            return Math.sqrt(num);
    }

    /* *Задание 1. * В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент скидки
 и возвращает сумму с учетом скидки. Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
 Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
 Не забудьте написать тесты для проверки этого поведения.
 */
    public static double calculateDiscount(double purchase, int discount) {

        if (purchase > 0) {
            if (discount >= 0 && discount <= 100) {
                return purchase - purchase * (double)discount/ 100.0;
            } else {
                throw new ArithmeticException("Неправильный размер скидки");
            }
        } else {
            throw new ArithmeticException("Неправильная сумма покупки");
        }
    }

    static {
        scanner = new Scanner(System.in);
    }
}