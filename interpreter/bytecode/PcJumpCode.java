package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class PcJumpCode extends ByteCode {

    protected int pcAddrOfLabel;
    protected String label;

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
        label = byteCodeArgs.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pcJump(pcAddrOfLabel);
    }

    public void setPcAddrOfLabel(int pcAddr) {
        pcAddrOfLabel = pcAddr;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void printCode() {
    }
}
