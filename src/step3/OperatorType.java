package step3;

public enum OperatorType {

    ADD('+') {
        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBTRACT('-') {
        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*') {
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/') {
        @Override
        public int calculate(int num1, int num2) {
            if (num2 == 0 ) {
                throw new ArithmeticException("*** 나누는 수는 0이 입력될 수 없습니다 ***");
            }
            return num1 / num2;
        }
    };

    private final char op;  // Enum 상수가 가진 값 저장
    public abstract int calculate(int num1, int num2);

    OperatorType(char op) { // 생성자 - 자동 private
        this.op = op;
    }
}
