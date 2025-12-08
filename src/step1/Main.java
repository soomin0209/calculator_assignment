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
    }
}
