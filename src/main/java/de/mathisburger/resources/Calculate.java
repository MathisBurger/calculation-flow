package de.mathisburger.resources;

import de.mathisburger.config.EndpointConfig;
import de.mathisburger.config.Function;
import de.mathisburger.data.CalculateBody;
import de.mathisburger.factory.ParamEnum;
import de.mathisburger.factory.ParameterFactory;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.Map;

@Path("/calculate")
public class Calculate {

    @Inject
    EndpointConfig config;

    @POST
    public String calc(CalculateBody body) {
        if (!this.config.functions().containsKey(body.id)) {
            return "BAD_REQUEST";
        }
        Function func = this.config.functions().get(body.id);
        ParameterFactory factory = new ParameterFactory(func.parameters());
        Map<String, ParamEnum> parameter =  factory.parseTypes(body.parameters);
        return "";
    }
}
