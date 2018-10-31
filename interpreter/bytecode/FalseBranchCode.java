package interpreter.bytecode;

import interpreter.VirtualMachine;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class FalseBranchCode extends PcJumpCode {

    @Override
    public void execute(VirtualMachine vm) {
        if (vm.popRunStack() == 0) {
            vm.pcJump(pcAddrOfLabel);
        }
    }

    @Override
    public void printCode() {
        System.out.println("FALSEBRANCH " + label);
    }
}
