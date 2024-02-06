package de.mathisburger.resources;

import de.mathisburger.config.EndpointConfig;
import de.mathisburger.config.Function;
import de.mathisburger.data.CompilationResponse;
import de.mathisburger.data.ConfigBody;
import de.mathisburger.factory.ClassFactory;
import de.mathisburger.factory.RawCodeFactory;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Configures a function
 */
@Path("/configure")
public class ClassConfig {

    @Inject
    EndpointConfig config;

    /**
     * Configures a function
     *
     * @param body The config body object
     * @return CompilationResponse response
     * @throws IOException as file read exception
     * @throws InterruptedException on failed waiting for process
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CompilationResponse configure(ConfigBody body) throws IOException, InterruptedException {
        if (!this.config.functions().containsKey(body.getId())) {
            return new CompilationResponse(false, "UNKNOWN");
        }
        Function function = this.config.functions().get(body.getId());
        ClassFactory factory = new ClassFactory(function);
        CompilationResponse success = factory.writeClass(body.getClassBody());
        RawCodeFactory.WriteRawCode(body.getId(), body.getClassBody());
        return success;
    }
}
