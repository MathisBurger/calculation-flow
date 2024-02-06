package de.mathisburger.factory;

import de.mathisburger.config.Function;
import de.mathisburger.data.CompilationResponse;

import java.io.*;
import java.util.Map;

/**
 * Used to create class objects
 */
public class ClassFactory {

    /**
     * Function that should be built
     */
    private final Function function;

    public ClassFactory(Function function) {
        this.function = function;
    }

    /**
     * Compiles a function
     *
     * @param classBody The body of the class
     * @return CompilationResponse
     * @throws IOException on file error
     * @throws InterruptedException on process error
     */
    public CompilationResponse writeClass(String classBody) throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("package tmp;import java.util.Map;public class " + this.function.className() + "{");
        sb.append("public " + this.function.resultType() + " calculate(de.mathisburger.factory.ParameterClass rawParams) {");
        sb.append("Map<String, de.mathisburger.factory.ParamEnum> params = rawParams.getParams();");
        Map<String, String> parameters = this.function.parameters();
        String[] keys = parameters.keySet().toArray(new String[0]);
        for (String key : keys) {
            sb.append(this.getUnwrapLine(key, parameters.get(key)));
        }
        sb.append(classBody);
        sb.append("}}");
        String filename = "./tmp/" + this.function.className() + ".java";
        File file = new File(filename);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(sb.toString());
        writer.close();
        File classFile = new File("./tmp/" + this.function.className() + ".class");
        if (classFile.exists()) {
            classFile.delete();
        }
        String javaHome = System.getProperty("java.home");
        Process proc = Runtime.getRuntime().exec(javaHome + "/bin/javac " + filename);
        InputStream stdIn = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(stdIn);
        BufferedReader br = new BufferedReader(isr);

        String line = null;
        StringBuilder fullLine = new StringBuilder();

        while ((line = br.readLine()) != null) {
            fullLine.append(line + "\n");
        }
        int exitCode = proc.waitFor();
        return new CompilationResponse(exitCode == 0, fullLine.toString());
    }

    /**
     * Generates an unwrap line
     *
     * @param name Name
     * @param type type
     * @return String
     */
    private String getUnwrapLine(String name, String type) {
        ParamEnum parsedType = ParamEnum.getType(type);
        if (parsedType == ParamEnum.CHAR) {
            return "char " + name + " = params.get(\"" + name + "\").getChar();";
        } else if (parsedType == ParamEnum.INT) {
            return "int " + name + " = params.get(\"" + name + "\").getInteger();";
        } else if (parsedType == ParamEnum.LONG) {
            return "long " + name + " = params.get(\"" + name + "\").getLong();";
        } else if (parsedType == ParamEnum.DOUBLE) {
            return "double " + name + " = params.get(\"" + name + "\").getDouble();";
        } else {
            return "String " + name + " = params.get(\"" + name + "\").getString();";
        }
    }
}
