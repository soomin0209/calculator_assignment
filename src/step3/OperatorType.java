package step3;

public enum OperatorType {

    ADD('+') {
        @Override
        public <T extends Number> T calculate(T num1, T num2) {
            double result = num1.doubleValue() + num2.doubleValue();
            return (T) convertToType(num1, num2, result);
        }
    },
    SUBTRACT('-') {
        @Override
        public <T extends Number> T calculate(T num1, T num2) {
            double result = num1.doubleValue() - num2.doubleValue();
            return (T) convertToType(num1, num2, result);
        }
    },
    MULTIPLY('*') {
        @Override
        public <T extends Number> T calculate(T num1, T num2) {
            double result = num1.doubleValue() * num2.doubleValue();
            return (T) convertToType(num1, num2, result);
        }
    },
    DIVIDE('/') {
        @Override
        public <T extends Number> T calculate(T num1, T num2) {
            if (num2.doubleValue() == 0.0 ) {
                throw new ArithmeticException("*** 나누는 수는 0이 입력될 수 없습니다 ***");
            }
            double result = num1.doubleValue() / num2.doubleValue();
            return (T) convertToType(num1, num2, result);
        }
    };

    private final char op;  // Enum 상수가 가진 값 저장
    public abstract <T extends Number> T calculate(T num1, T num2);

    OperatorType(char op) { // 생성자 - 자동 private
        this.op = op;
    }

    // char 타입으로 입력받은 기호를 Enum 상수로 변환
    public static OperatorType fromChar(char op) {
        for (OperatorType type : OperatorType.values()) {
            if (type.op == op) {
                return type;
            }
        }
        throw new IllegalArgumentException("*** 잘못된 연산 기호 입니다 ***");
    }

    // 결과 값 타입 결정하는 메서드
    private static Number convertToType(Number num1, Number num2, double result) {
        // 둘 중 하나라도 Double이면 결과도 Double
        if (num1 instanceof Double || num2 instanceof Double) {
            return result;
        }
        // 둘 다 Integer면 결과도 Integer
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (int) result;
        }
        return result;
    }
}
