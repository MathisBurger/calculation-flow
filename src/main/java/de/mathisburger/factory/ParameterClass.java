package de.mathisburger.factory;

import java.util.Map;

/**
 * Class that is provided to compiled classes
 */
public class ParameterClass {

    /**
     * All parameters of the function
     */
    private Map<String, ParamEnum> params;

    public ParameterClass(Map<String, ParamEnum> params) {
        this.params = params;
    }

    /**
     * Gets all params
     *
     * @return Map<String, ParamEnum>
     */
    public Map<String, ParamEnum> getParams() {
        return params;
    }
}
