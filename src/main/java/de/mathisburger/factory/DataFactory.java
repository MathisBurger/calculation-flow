package de.mathisburger.factory;

import de.mathisburger.config.EndpointConfig;
import de.mathisburger.config.Function;
import de.mathisburger.data.FunctionData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * factory that handles data
 */
@ApplicationScoped
public class DataFactory {

    @Inject
    EndpointConfig config;

    /**
     * Gets all function data
     *
     * @return List<FunctionData>
     */
    public List<FunctionData> getFunctionData() {
        Map<String, Function> functionMap = this.config.functions();
        Set<String> keys = functionMap.keySet();
        List<FunctionData> collection = new ArrayList<>();
        for (String key : keys) {
            Function func = functionMap.get(key);
            FunctionData data = new FunctionData(key, func.className(), func.resultType(), func.parameters());
            collection.add(data);
        }
        return collection;
    }
}
