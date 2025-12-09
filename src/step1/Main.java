package step1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 첫 번째 정수 입력
            System.out.print("첫 번째 정수를 입력해주세요: ");
            int num1 = sc.nextInt();
            // 정수가 0보다 작을 경우 메시지 출력
            while (num1 < 0) {
                System.out.print("0 이상의 정수로 다시 입력해주세요: ");
                num1 = sc.nextInt();
            }

            // 두 번째 정수 입력
            System.out.print("두 번째 정수를 입력해주세요: ");
            int num2 = sc.nextInt();
            // 정수가 0보다 작을 경우 메시지 출력
            while (num2 < 0) {
                System.out.print("0 이상의 정수로 다시 입력해주세요: ");
                num2 = sc.nextInt();
            }
            System.out.println();

            // 사칙연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /, 종료:exit): ");
            String input = sc.next();

            // 입력 받은 문자열이 "exit"일 경우 종료
            if (input.equals("exit")) {
                break;
            }

            // 입력 받은 문자열이 두 글자 이상일 경우 메시지 출력
            if (input.length() != 1) {
                System.out.println("*** 연산 기호는 한 글자만 입력해주세요 ***");
                System.out.println();
                continue;
            }

            // 문자열 -> 문자 변환
            char op = input.charAt(0);

            // 사칙 연산 수행
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
                    } catch (ArithmeticException e) {   // 나누는 수가 0일 경우 메시지 출력
                        System.out.println("*** 나누는 수는 0이 입력될 수 없습니다 ***");
                    }
                    break;
                default:
                    // 다른 문자일 경우 메시지 출력
                    System.out.println("*** 잘못된 연산 기호 입니다 ***");
                    break;
            }
            System.out.println();
        }
    }
}
