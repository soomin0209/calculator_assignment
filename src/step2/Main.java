package step2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

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
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            String input = sc.next();

            // 입력 받은 문자열이 두 글자 이상일 경우 메시지 출력
            if (input.length() != 1) {
                System.out.println("*** 연산 기호는 한 글자만 입력해주세요 ***");
                System.out.println();
                continue;
            }

            // 문자열 -> 문자 변환
            char op = input.charAt(0);

            // 계산 결과 출력 & 저장된 계산 결과 리스트 출력
            try {
                int result = calculator.calculate(num1, num2, op);
                System.out.println("결과: " + result);
                // Getter 메서드 활용
                System.out.println("계산 결과 조회: " + calculator.getResults());
            } catch (ArithmeticException ae) {
                System.out.println(ae.getMessage());
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
            System.out.println();

            // removeResult() 활용
            System.out.print("첫 번째 계산 결과를 삭제하시겠습니까? (yes 입력 시 삭제): ");
            String remove = sc.next();
            if (remove.equals("yes")){
                boolean removed = calculator.removeResult();    // 삭제 성공 여부 반환
                if (removed) {
                    System.out.println("=== 삭제 완료: " + calculator.getResults() + " ===");
                } else {
                    // 빈 배열일 경우 메시지 출력
                    System.out.println("*** 삭제할 계산 결과가 없습니다 ***");
                }
            }

            // Setter 메서드 활용
            System.out.print("계산 결과를 초기화 하시겠습니까? (yes 입력 시 초기화): ");
            String reset = sc.next();
            if (reset.equals("yes")) {
                calculator.setResults(new ArrayList<>());   // Setter 호출 -> 새 ArrayList로 초기화
                System.out.println("=== 초기화 완료: " + calculator.getResults() + " ===");
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String choice = sc.next();
            // 입력 받은 문자열이 "exit"일 경우 종료
            if (choice.equals("exit")) {
                break;
            }
            System.out.println();
        }
    }
}
