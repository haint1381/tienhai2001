package service;

public class ComputerService {
    public static double calculate(String action, double number1, double number2) {
        double answer;
        switch (action) {
            case "+": {
                answer = number1 + number2;
            }
            break;
            case "-": {
                answer = number1 - number2;
            }
            break;
            case "*": {
                answer = number1 * number2;
            }
            break;
            case "/": {
                answer = number1 / number2;
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        return answer;
    }
}
