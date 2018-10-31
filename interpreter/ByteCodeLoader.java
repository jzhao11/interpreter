package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import interpreter.bytecode.*;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time. For each
     * line it should: Tokenize string to break it into parts. Grab correct
     * class name for the given ByteCode from CodeTable. Create an instance of
     * the ByteCode class name returned from code table. Parse any additional
     * arguments for the given ByteCode and send them to the newly created
     * ByteCode instance via the init function.
     *
     * @return
     */
    public Program loadCodes() {
        this.program = new Program();
        String codeLine;
        String token;
        StringTokenizer tokenizer;
        
        try {
            while ((codeLine = this.byteSource.readLine()) != null) {
                tokenizer = new StringTokenizer(codeLine, " ", true);
                ByteCode bc = constructByteCode(tokenizer.nextToken());
                ArrayList<String> byteCodeArgs = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    if (!(token = tokenizer.nextToken()).equals(" ")) {
                        byteCodeArgs.add(token);
                    }
                }
                if (bc != null) {
                    bc.init(byteCodeArgs);
                    this.program.addByteCode(bc);
                }
            }
            this.byteSource.close();
            
            this.program.resolveAddrs();
        } catch (IOException ex) {
            System.out.println("Code Loading Exception");
        }
        
        return this.program;
    }

    // construct a bytecode instance by using code as the classname
    public ByteCode constructByteCode(String code) {
        String className = CodeTable.getClassName(code);
        ByteCode bc = null;
        try {
            bc = (ByteCode) Class.forName("interpreter.bytecode." + className).getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            System.out.println("ByteCode Constructing Exception");
        }
        return bc;
    }
}
