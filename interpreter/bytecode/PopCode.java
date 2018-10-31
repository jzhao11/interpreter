package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class PopCode extends ByteCode {

    private int numOfPops;

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        numOfPops = Integer.parseInt(byteCodeArgs.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        int count = numOfPops;
        while (count > 0 && vm.currRunStackSize() > 0) {
            vm.popRunStack();
            count--;
        }
    }

    @Override
    public void printCode() {
        System.out.println("POP " + numOfPops);
    }
}
