package interpreter.bytecode;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class GotoCode extends PcJumpCode {

    @Override
    public void printCode() {
        System.out.println("GOTO " + label);
    }
}
