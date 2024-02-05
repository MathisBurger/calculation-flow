package de.mathisburger.data;

import java.util.Map;

public class FunctionData {

    public final String name;

    public final String path;

    public final String className;

    public final String resultType;

    public final Map<String, String> parameters;

    public FunctionData(String name, String path, String className, String resultType, Map<String, String> parameters) {
        this.name = name;
        this.path = path;
        this.className = className;
        this.resultType = resultType;
        this.parameters = parameters;
    }

}
