package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class CallCode extends PcJumpCode {

    private ArrayList<Integer> args;

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddr();
        vm.pcJump(this.pcAddrOfLabel);
        args = vm.nPeekRunStack();
    }

    @Override
    public void printCode() {
        System.out.print("CALL " + label);
        int toIndex;
        String funcName;
        StringBuilder strArgs = new StringBuilder();
        if (args.size() > 0) {
            strArgs.append(args.get(0));
            for (int i = 1; i < args.size(); ++i) {
                strArgs.append(",").append(args.get(i));
            }
        }
        if ((toIndex = label.indexOf("<<")) > 0) {
            funcName = label.substring(0, toIndex);
            System.out.print("    " + funcName + "(" + strArgs.toString() + ")");
        }
        System.out.println();
    }
}
