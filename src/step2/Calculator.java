package step2;

import java.util.ArrayList;

public class Calculator {

    // private으로 캡슐화
    private ArrayList<Integer> results = new ArrayList<>();

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

    // Getter 메서드
    public ArrayList<Integer> getResults() {
        return results;
    }

    // Setter 메서드
    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }

    public void removeResult() {
        results.remove(0);
    }
}
