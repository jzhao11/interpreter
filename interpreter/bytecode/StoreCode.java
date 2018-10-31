package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class StoreCode extends ByteCode {

    private int offset;
    private String variable = "";
    private int topElement;

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        offset = Integer.parseInt(byteCodeArgs.get(0));
        if (byteCodeArgs.size() > 1) {
            variable = byteCodeArgs.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        topElement = vm.storeRunStack(offset);
    }

    @Override
    public void printCode() {
        System.out.print("STORE " + offset);
        if (!variable.equals("")) {
            System.out.print(" " + variable + "    " + variable + "=" + topElement);
        }
        System.out.println();
    }
}
