package step1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 정수를 입력해주세요: ");
            int num1 = sc.nextInt();
            while (num1 < 0) {
                System.out.print("0 이상의 정수로 다시 입력해주세요: ");
                num1 = sc.nextInt();
            }

            System.out.print("두 번째 정수를 입력해주세요: ");
            int num2 = sc.nextInt();
            while (num2 < 0) {
                System.out.print("0 이상의 정수로 다시 입력해주세요: ");
                num2 = sc.nextInt();
            }
            System.out.println();

            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /, 종료:exit): ");
            String input = sc.next();
            if (input.equals("exit")) {
                break;
            }

            if (input.length() != 1) {
                System.out.println("*** 연산 기호는 한 글자만 입력해주세요 ***");
                System.out.println();
                continue;
            }

            char op = input.charAt(0);

            int result = 0;
            switch (op) {
                case '+':
                    result = num1 + num2;
                    System.out.println("결과: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("결과: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("결과: " + result);
                    break;
                case '/':
                    try {
                        result = num1 / num2;
                        System.out.println("결과: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("*** 나누는 수는 0이 입력될 수 없습니다 ***");
                    }
                    break;
                default:
                    System.out.println("*** 잘못된 연산 기호 입니다 ***");
                    break;
            }
            System.out.println();
        }
    }
}
