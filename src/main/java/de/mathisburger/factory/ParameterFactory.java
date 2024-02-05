package de.mathisburger.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParameterFactory {

    private final Map<String, String> parameters;

    public ParameterFactory(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Map<String, ParamEnum> parseTypes(Map<String, String> values) {
        Map<String, ParamEnum> map = new HashMap<>();
        Set<String> keys = values.keySet();
        for (String key : keys) {
            String dataType = this.parameters.get(key);
            map.put(key, ParameterFactory.parseValue(dataType, values.get(key)));
        }
        return map;
    }

    public static ParamEnum parseValue(String type, String value) {
        ParamEnum data = ParamEnum.getType(type);
        if (data == ParamEnum.CHAR) {
            data.setChar(value.charAt(0));
        } else if (data == ParamEnum.INT) {
            data.setInteger(Integer.parseInt(value));
        } else if (data == ParamEnum.LONG) {
            data.setLong(Long.parseLong(value));
        } else if (data == ParamEnum.DOUBLE) {
            data.setDouble(Double.parseDouble(value));
        } else {
            data.setString(value);
        }
        return data;
    }

    public static String getFullString(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            sb.append(key + " (" + params.get(key) + "); ");
        }
        return sb.toString();
    }

}
