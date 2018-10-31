package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class LabelCode extends ByteCode {

    private String label;

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        label = byteCodeArgs.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void printCode() {
        System.out.println("LABEL " + label);
    }
}
