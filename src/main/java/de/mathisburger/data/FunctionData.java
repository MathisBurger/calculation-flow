package de.mathisburger.data;

import java.util.Map;
import java.util.Set;

/**
 * Data object that contains function information
 */
public class FunctionData {

    /**
     * The name or ID
     */
    public final String name;

    /**
     * The java class name
     */
    public final String className;

    /**
     * The result type
     */
    public final String resultType;

    /**
     * All parameters
     */
    public final Map<String, String> parameters;

    public FunctionData(String name, String className, String resultType, Map<String, String> parameters) {
        this.name = name;
        this.className = className;
        this.resultType = resultType;
        this.parameters = parameters;
    }

    /**
     * Gets all parameters as a list
     * @return String
     */
    public String getParameterList() {
        Set<String> params = parameters.keySet();
        return String.join("; ", params);
    }

}
