package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class DumpCode extends ByteCode {

    private String dumpState;

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        dumpState = byteCodeArgs.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (dumpState.equals("ON")) {
            vm.setDumpState(true);
        } else if (dumpState.equals("OFF")) {
            vm.setDumpState(false);
        }
    }

    @Override
    public void printCode() {
    }
}
