package step2;

import java.util.ArrayList;

public class Calculator {

    ArrayList<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("*** 나누는 수는 0이 입력될 수 없습니다 ***");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("*** 잘못된 연산 기호 입니다 ***");
        }

        results.add(result);
        return result;
    }
}
