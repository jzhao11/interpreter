package interpreter;

import java.util.ArrayList;
import interpreter.bytecode.*;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return program.get(pc);
    }

    public int getSize() {
        return program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-structure bytecodes are stored in.
     */
    public void resolveAddrs() {
        int programSize = getSize();
        for (int i = 0; i < programSize; ++i) {
            ByteCode bc1 = getCode(i);
            if (bc1 instanceof PcJumpCode) {
                for (int j = 0; j < programSize; ++j) {
                    ByteCode bc2 = getCode(j);
                    if (bc2 instanceof LabelCode && (((PcJumpCode) bc1).getLabel()).equals(((LabelCode) bc2).getLabel())) {
                        ((PcJumpCode) bc1).setPcAddrOfLabel(j);
                    }
                }
            }
        }
    }
    
    public boolean addByteCode(ByteCode bc) {
        return program.add(bc);
    }
}
