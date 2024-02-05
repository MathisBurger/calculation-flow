package de.mathisburger.factory;

import de.mathisburger.config.Function;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ClassFactory {

    private final Function function;

    public ClassFactory(Function function) {
        this.function = function;
    }

    public void writeClass(String classBody) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("package tmp;public class " + this.function.className() + "{");
        sb.append("public " + this.function.resultType() + " calculate(");
        Map<String, String> parameters = this.function.parameters();
        String[] keys = parameters.keySet().toArray(new String[0]);
        for (int i=0; i<keys.length; i++) {
            if (i == 0) {
                sb.append(parameters.get(keys[i]) + " "+ keys[i]);
            } else {
                sb.append("," + parameters.get(keys[i]) + " "+ keys[i]);
            }
        }
        sb.append(") {");
        sb.append(classBody);
        sb.append("}}");
        String filename = "./" + this.function.className() + ".java";
        File file = new File(filename);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(sb.toString());
        writer.close();
        Runtime.getRuntime().exec("javac " + filename);
        file.delete();
    }
}
