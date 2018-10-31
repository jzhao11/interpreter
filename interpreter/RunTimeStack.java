package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    
    public int store(int offset) {
        int topElement = pop();
        int pointer = framePointer.peek();
        runTimeStack.set(pointer + offset, topElement);
        return topElement;
    }
    
    //Used to load variables onto the RuntimeStack from a
    //given offset within the current frame. This means we
    //will go to the offset in the current frame, copy the
    //value and push it to the top of the stack. No values
    //should be removed with loads.
    public int load(int offset) {
        int pointer = framePointer.peek();
        int element = runTimeStack.get(pointer + offset);
        return push(element);
    }
    
    // dump all the elements in runTimeStack
    // each "[]" pair refers to a stack frame
    // each two adjacent elements in the same frame is separated by a ","
    public void dump() {
        int fpSize = framePointer.size();
        int fpStart = 0;
        int fpEnd;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fpSize; ++i) {
            fpEnd = (i + 1 < fpSize) ? framePointer.get(i + 1) - 1 : runTimeStack.size() - 1;
            if (fpStart <= fpEnd) {
                sb.append("[").append(runTimeStack.get(fpStart++));
                while (fpStart <= fpEnd) {
                    sb.append(",").append(runTimeStack.get(fpStart++));
                }
                sb.append("] ");
            } else {
                sb.append("[] ");
            }
        }
        System.out.println(sb.toString());
    }
    
    // remove the top element from the runTimeStack
    public int pop() {
        return runTimeStack.remove(runTimeStack.size() - 1);
    }
    
    // get the top of the stack without removing the item
    public int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }
    
    public ArrayList<Integer> nPeek() {
        ArrayList<Integer> args = new ArrayList<>();
        int toIndex = runTimeStack.size();
        int fromIndex = framePointer.peek();
        for (int i = fromIndex; i < toIndex; ++i) {
            args.add(runTimeStack.get(i));
        }
        return args;
    }
    
    // push an element to the top of the runTimeStack
    public int push(int element) {
        runTimeStack.add(element);
        return element;
    }
    
    // this version only used for LitCode
    public Integer push(Integer value) {
        runTimeStack.add(value);
        return value;
    }
    
    public void newFrameAt(int numOfArgs) {
        int pointer = runTimeStack.size() - numOfArgs;
        framePointer.push(pointer);
    }
    
    // pop framePointer when returning from a function
    // save the element at top of runTimeStack as topElement
    // topElement is the return value of current frame (not the return value of popFrame())
    // pop runTimeStack until it hits the frame pointer (the bottom of the current stack)
    // push topElement back to the runTimeStack
    public int popFrame() {
        int pointer = framePointer.pop();
        int topElement = runTimeStack.remove(runTimeStack.size() - 1);
        while (runTimeStack.size() > pointer) {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        runTimeStack.add(topElement);
        return pointer;
    }
    
    // get the size of the run-time stack for the current executing function
    // serve as a range check
    // should be called before popping any element from the runTimeStack
    public int currSize() {
        int pointer = framePointer.peek();
        int runStackSize = runTimeStack.size();
        return (pointer >= runStackSize) ? 0 : (runStackSize - pointer);
    }
}
