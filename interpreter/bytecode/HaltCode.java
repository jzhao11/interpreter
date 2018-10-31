package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class HaltCode extends ByteCode {

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltProgram();
    }

    @Override
    public void printCode() {
        System.out.println("HALT");
    }
}
