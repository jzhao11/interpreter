package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public abstract class ByteCode {

    public abstract void init(ArrayList<String> byteCodeArgs);

    public abstract void execute(VirtualMachine vm);
    
    public abstract void printCode();
}
