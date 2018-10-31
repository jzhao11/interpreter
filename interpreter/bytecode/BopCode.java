package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class BopCode extends ByteCode {

    private String operator;

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        operator = byteCodeArgs.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int operand1 = vm.popRunStack();
        int operand2 = vm.popRunStack();
        int result;
        switch (operator) {
            case "+":
                result = operand2 + operand1;
                break;
            case "-":
                result = operand2 - operand1;
                break;
            case "/":
                result = operand2 / operand1;
                break;
            case "*":
                result = operand2 * operand1;
                break;
            case "==":
                result = (operand2 == operand1) ? 1 : 0;
                break;
            case "!=":
                result = (operand2 != operand1) ? 1 : 0;
                break;
            case "<=":
                result = (operand2 <= operand1) ? 1 : 0;
                break;
            case ">":
                result = (operand2 > operand1) ? 1 : 0;
                break;
            case ">=":
                result = (operand2 >= operand1) ? 1 : 0;
                break;
            case "<":
                result = (operand2 < operand1) ? 1 : 0;
                break;
            case "|":
                result = (operand2 != 0 || operand1 != 0) ? 1 : 0;
                break;
            default:
                result = (operand2 != 0 && operand1 != 0) ? 1 : 0;
                break;
        }
        vm.pushRunStack(result);
    }

    @Override
    public void printCode() {
        System.out.println("BOP " + operator);
    }
}
