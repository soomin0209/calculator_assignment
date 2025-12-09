package step3;

import java.util.ArrayList;

public class ArithmeticCalculator <T extends Number> {

    // private으로 캡슐화
    private ArrayList<T> results = new ArrayList<>();

    public T calculate(T num1, T num2, char op) {
        OperatorType operatorType = OperatorType.fromChar(op);
        T result = operatorType.calculate(num1, num2);
        results.add(result);
        return result;
    }

    // Getter 메서드
    public ArrayList<T> getResults() {
        return results;
    }

    // Setter 메서드
    public void setResults(ArrayList<T> results) {
        this.results = results;
    }

    public boolean removeResult() { // 삭제 성공 여부 반환을 위해 boolean으로 변경
        try {
            results.remove(0);
            return true;    // 삭제 성공
        } catch (IndexOutOfBoundsException e){
            return false;   // 삭제 실패
        }
    }

    // 문자열을 Integer 또는 Double로 파싱
    public static Number parseNumber(String str) {
        try {
            // 소수점이 없으면 Integer로 파싱
            if (!str.contains(".")) {
                return Integer.parseInt(str);
            } else {
                return Double.parseDouble(str);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("*** 올바른 숫자를 입력해주세요 ***");
        }
    }
}
