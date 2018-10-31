package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class ArgsCode extends ByteCode {

    private int numOfArgs;

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        numOfArgs = Integer.parseInt(byteCodeArgs.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.createFrame(numOfArgs);
    }

    @Override
    public void printCode() {
        System.out.println("ARGS " + numOfArgs);
    }
}
