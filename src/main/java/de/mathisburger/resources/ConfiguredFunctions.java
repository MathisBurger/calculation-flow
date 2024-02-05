package de.mathisburger.resources;

import de.mathisburger.config.EndpointConfig;
import de.mathisburger.config.Function;
import de.mathisburger.data.FunctionData;
import de.mathisburger.factory.DataFactory;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.*;

@Path("/configured")
public class ConfiguredFunctions {

    @Inject
    DataFactory factory;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FunctionData> functions() {
        return this.factory.getFunctionData();
    }
}
