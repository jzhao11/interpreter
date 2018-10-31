package interpreter;

import java.util.Stack;
import java.util.ArrayList;
import interpreter.bytecode.*;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        pc = 0;
        isRunning = true;
        dump = false;
        ByteCode bc;
        while (isRunning) {
            bc = program.getCode(pc);
            bc.execute(this);
            if (dump) {
                bc.printCode();
                runStack.dump();
            }
            pc++;
        }
    }
    
    public void pcJump(int pcAddr) {
        pc = pcAddr;
    }
    
    public void haltProgram() {
        isRunning = false;
    }
    
    public void createFrame(int numOfArgs) {
        runStack.newFrameAt(numOfArgs);
    }
    
    public int popFrame() {
        return runStack.popFrame();
    }
    
    public int pushReturnAddr() {
        return returnAddrs.push(pc);
    }
    
    public int popReturnAddr() {
        return returnAddrs.pop();
    }
    
    public int storeRunStack(int offset) {
        return runStack.store(offset);
    }
    
    public int loadRunStack(int offset) {
        return runStack.load(offset);
    }
    
    public void pushRunStack(int value) {
        runStack.push(value);
    }
    
    // this version only used for LitCode
    public void pushRunStack(Integer value) {
        runStack.push(value);
    }
    
    public int popRunStack() {
        return runStack.pop();
    }
    
    public int peekRunStack() {
        return runStack.peek();
    }
    
    public ArrayList<Integer> nPeekRunStack() {
        return runStack.nPeek();
    }
    
    public void setDumpState(boolean state) {
        dump = state;
    }
    
    public int currRunStackSize() {
        return runStack.currSize();
    }
}
