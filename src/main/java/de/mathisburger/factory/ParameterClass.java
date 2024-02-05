package de.mathisburger.factory;

import java.util.Map;

public class ParameterClass {

    private Map<String, ParamEnum> params;

    public ParameterClass(Map<String, ParamEnum> params) {
        this.params = params;
    }

    public Map<String, ParamEnum> getParams() {
        return params;
    }
}
