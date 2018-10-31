package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class ReturnCode extends ByteCode {

    private String label = "";
    private int returnValue;

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        if (byteCodeArgs.size() > 0) {
            label = byteCodeArgs.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.popFrame();
        vm.pcJump(vm.popReturnAddr());
        returnValue = vm.peekRunStack();
    }

    @Override
    public void printCode() {
        System.out.print("RETURN " + label + "    exit");
        if (!label.equals("")) {
            String funcName = label.substring(0, label.indexOf("<<"));
            System.out.print(" " + funcName + ":" + returnValue);
        }
        System.out.println();
    }
}
