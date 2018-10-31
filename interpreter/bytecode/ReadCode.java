package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jianfei Zhao
 * @email jzhao11@mail.sfsu.edu
 */
public class ReadCode extends ByteCode {

    @Override
    public void init(ArrayList<String> byteCodeArgs) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                int tmp = input.nextInt();
                vm.pushRunStack(tmp);
                break;
            } catch (Exception ex) {
                System.out.println("INVALID INPUT: the input must be an integer.");
            }
        }
        sc.close();
    }

    @Override
    public void printCode() {
        System.out.println("READ");
    }
}
