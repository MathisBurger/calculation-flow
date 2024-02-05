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
        sb.append("package tmp;import java.util.Map;public class " + this.function.className() + "{");
        sb.append("public " + this.function.resultType() + " calculate(Map<String,de.mathisburger.factory.ParamEnum> params) {");
        Map<String, String> parameters = this.function.parameters();
        String[] keys = parameters.keySet().toArray(new String[0]);
        for (String key : keys) {
            sb.append(this.getUnwrapLine(key, parameters.get(key)));
        }
        sb.append(classBody);
        sb.append("}}");
        String filename = "./" + this.function.className() + ".java";
        File file = new File(filename);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(sb.toString());
        writer.close();
        Runtime.getRuntime().exec("javac " + filename);
        //file.delete();
    }

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
