package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class LitCode extends ByteCode {

    private Integer value;
    private String variable = "";

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        value = Integer.parseInt(byteCodeArgs.get(0));
        if (byteCodeArgs.size() > 1) {
            variable = byteCodeArgs.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunStack(value);
    }

    @Override
    public void printCode() {
        System.out.print("LIT " + value);
        if (!variable.equals("")) {
            System.out.print(" " + variable + "    int " + variable);
        }
        System.out.println();
    }
}
