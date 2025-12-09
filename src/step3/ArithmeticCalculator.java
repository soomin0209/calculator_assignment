package step3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

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

    // 입력받은 수보다 연산 결과가 큰 경우를 저장하는 컬렉션
    public ArrayList<T> getBiggerResults(T num) {
        try {
            // 람다 & 스트림으로 구현
            return results.stream().filter(result -> result.doubleValue() > num.doubleValue())
                    .collect(Collectors.toCollection(() -> new ArrayList<>()));
        } catch (NumberFormatException e) { // 입력 받은수가 Integer, Double 형태가 아니면 예외 처리
            throw new IllegalArgumentException("*** 올바른 숫자를 입력해주세요 ***");
        }
    }
}
