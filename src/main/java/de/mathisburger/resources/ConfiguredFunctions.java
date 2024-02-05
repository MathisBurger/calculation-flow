package de.mathisburger.resources;

import de.mathisburger.config.EndpointConfig;
import de.mathisburger.config.Function;
import de.mathisburger.data.FunctionData;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.*;

@Path("/configured")
public class ConfiguredFunctions {

    @Inject
    EndpointConfig endpointConfig;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FunctionData> functions() {
        Map<String, Function> functionMap = this.endpointConfig.functions();
        Set<String> keys = functionMap.keySet();
        List<FunctionData> collection = new ArrayList<>();
        for (String key : keys) {
            Function func = functionMap.get(key);
            FunctionData data = new FunctionData(key, func.path(), func.className(), func.resultType(), func.parameters());
            collection.add(data);
        }
        return collection;
    }
}
