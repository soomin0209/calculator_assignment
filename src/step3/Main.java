package step3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();

        while (true) {
            // 첫 번째 정수/실수 입력
            System.out.print("첫 번째 수를 입력해주세요: ");
            // parseNumber() 메서드를 호출해 정수/실수를 판별하기 위해 String 형태로 입력받음
            String input1 = sc.next();
            Number num1 = null;
            // 입력 받은 수가 0보다 작거나 Number가 아닐 경우 다시 입력
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

            // 첫 번째 정수/실수 입력
            System.out.print("두 번째 수를 입력해주세요: ");
            // parseNumber() 메서드를 호출해 정수/실수를 판별하기 위해 String 형태로 입력받음
            String input2 = sc.next();
            Number num2 = null;
            // 입력 받은 수가 0보다 작거나 Number가 아닐 경우 다시 입력
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

            // 사칙연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            String inputOp = sc.next();

            // 입력 받은 문자열이 두 글자 이상일 경우 메시지 출력
            if (inputOp.length() != 1) {
                System.out.println("*** 연산 기호는 한 글자만 입력해주세요 ***");
                System.out.println();
                continue;
            }

            // 문자열 -> 문자 변환
            char op = inputOp.charAt(0);

            // 계산 결과 출력 & 저장된 계산 결과 리스트 출력
            try {
                Number result = arithmeticCalculator.calculate(num1, num2, op);
                System.out.println("결과: " + result);
                // Getter 메서드 활용
                System.out.println("계산 결과 조회: " + arithmeticCalculator.getResults());
                // 입력 받은 수보다 큰 계산 결과들 출력
                System.out.print("계산 결과와 비교할 수를 입력해주세요: ");
                String inputNum = sc.next();
                Number num = null;
                // 입력 받은 수로 파싱 메서드 호출 -> 타입 판별
                // Number이 아닐 경우 메시지 출력
                while (num == null) {
                    try {
                        num = ArithmeticCalculator.parseNumber(inputNum);
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        System.out.print("다시 입력해주세요: ");
                        inputNum = sc.next();
                    }
                }
                System.out.println("입력 받은 수보다 큰 계산 결과 조회: " + arithmeticCalculator.getBiggerResults(num));

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
                    // 빈 배열일 경우 메시지 출력
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
            // 입력 받은 문자열이 "exit"일 경우 종료
            if (choice.equals("exit")) {
                break;
            }
            System.out.println();
        }
    }
}
