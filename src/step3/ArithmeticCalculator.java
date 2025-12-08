package step3;

import java.util.ArrayList;

public class ArithmeticCalculator {

    // private으로 캡슐화
    private ArrayList<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char op) {
        OperatorType operatorType = OperatorType.fromChar(op);
        int result = operatorType.calculate(num1, num2);
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

    public boolean removeResult() { // 삭제 성공 여부 반환을 위해 boolean으로 변경
        try {
            results.remove(0);
            return true;    // 삭제 성공
        } catch (IndexOutOfBoundsException e){
            return false;   // 삭제 실패
        }
    }
}
