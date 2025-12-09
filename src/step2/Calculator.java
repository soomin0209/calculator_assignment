package step2;

import java.util.ArrayList;

public class Calculator {

    // private으로 캡슐화
    private ArrayList<Integer> results = new ArrayList<>();

    // 사칙 연산 구현
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
                if (num2 == 0) {    // 나누는 수가 0일 경우 예외 처리
                    throw new ArithmeticException("*** 나누는 수는 0이 입력될 수 없습니다 ***");
                }
                result = num1 / num2;
                break;
            default:
                // 다른 문자일 경우 예외 처리
                throw new IllegalArgumentException("*** 잘못된 연산 기호 입니다 ***");
        }

        // 결과를 배열리스트에 저장
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

    // 첫 번째 결과 삭제 메서드
    public boolean removeResult() { // 삭제 성공 여부 반환을 위해 boolean으로 변경
        try {
            results.remove(0);
            return true;    // 삭제 성공
        } catch (IndexOutOfBoundsException e){
            return false;   // 삭제 실패
        }
    }
}
