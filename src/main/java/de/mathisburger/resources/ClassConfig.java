package de.mathisburger.resources;

import de.mathisburger.config.EndpointConfig;
import de.mathisburger.config.Function;
import de.mathisburger.data.ConfigBody;
import de.mathisburger.factory.ClassFactory;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path("/configure")
public class ClassConfig {

    @Inject
    EndpointConfig config;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    public String configure(ConfigBody body) throws IOException {
        if (!this.config.functions().containsKey(body.getId())) {
            return "UNKNOWN ID";
        }
        Function function = this.config.functions().get(body.getId());
        ClassFactory factory = new ClassFactory(function);
        factory.writeClass(body.classBody);
        return "OK";
    }
}
