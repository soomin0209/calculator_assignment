package step3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();

        while (true) {
            System.out.print("첫 번째 수를 입력해주세요: ");
            String input1 = sc.next();
            Number num1 = null;
            while (num1 == null || num1.doubleValue() < 0) {
                try {
                    num1 = ArithmeticCalculator.parseNumber(input1);
                    if (num1.doubleValue() < 0) {
                        System.out.print("0 이상의 수로 다시 입력해주세요: ");
                        input1 = sc.next();
                        num1 = null;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.print("0 이상의 수로 다시 입력해주세요: ");
                    input1 = sc.next();
                }
            }

            System.out.print("두 번째 수를 입력해주세요: ");
            String input2 = sc.next();
            Number num2 = null;
            while (num2 == null || num2.doubleValue() < 0) {
                try {
                    num2 = ArithmeticCalculator.parseNumber(input2);
                    if (num2.doubleValue() < 0) {
                        System.out.print("0 이상의 수로 다시 입력해주세요: ");
                        input2 = sc.next();
                        num2 = null;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.print("0 이상의 수로 다시 입력해주세요: ");
                    input2 = sc.next();
                }
            }
            System.out.println();

            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
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

            try {
                Number result = arithmeticCalculator.calculate(num1, num2, op);
                System.out.println("결과: " + result);
                // Getter 메서드 활용
                System.out.println("계산 결과 조회: " + arithmeticCalculator.getResults());
            } catch (ArithmeticException ae) {
                System.out.println(ae.getMessage());
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
            System.out.println();

            // removeResult() 활용
            System.out.print("첫 번째 계산 결과를 삭제하시겠습니까? (yes 입력 시 삭제): ");
            String remove = sc.next();
            if (remove.equals("yes")) {
                boolean removed = arithmeticCalculator.removeResult();    // 삭제 성공 여부 반환
                if (removed) {
                    System.out.println("=== 삭제 완료: " + arithmeticCalculator.getResults() + " ===");
                } else {
                    System.out.println("*** 삭제할 계산 결과가 없습니다 ***");
                }
            }

            // Setter 메서드 활용
            System.out.print("계산 결과를 초기화 하시겠습니까? (yes 입력 시 초기화): ");
            String reset = sc.next();
            if (reset.equals("yes")) {
                arithmeticCalculator.setResults(new ArrayList<>());   // Setter 호출 -> 새 ArrayList로 초기화
                System.out.println("=== 초기화 완료: " + arithmeticCalculator.getResults() + " ===");
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String choice = sc.next();
            if (choice.equals("exit")) {
                break;
            }
            System.out.println();
        }
    }
}
