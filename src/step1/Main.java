package step1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 정수를 입력해주세요: ");
        int num1 = sc.nextInt();
        while (num1 < 0) {
            System.out.print("다시 입력해주세요: ");
            num1 = sc.nextInt();
        }

        System.out.print("두 번째 정수를 입력해주세요: ");
        int num2 = sc.nextInt();
        while (num2 < 0) {
            System.out.print("다시 입력해주세요: ");
            num2 = sc.nextInt();
        }

        System.out.print("사칙연산 기호를 입력하세요: ");
        char op = sc.next().charAt(0);

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
                    System.out.println("나눗셈 연산에서 분모가 0이 입력될 수 없습니다.");
                }
                break;
            default:
                System.out.println("잘못된 연산 기호 입니다.");
        }
    }
}
