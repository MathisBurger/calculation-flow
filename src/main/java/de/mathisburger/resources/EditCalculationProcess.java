package de.mathisburger.resources;

import de.mathisburger.config.EndpointConfig;
import de.mathisburger.config.Function;
import de.mathisburger.factory.ParameterFactory;
import de.mathisburger.factory.RawCodeFactory;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

/**
 * Edit template
 */
@Path("/edit")
public class EditCalculationProcess {

    @Inject
    Template editPage;

    @Inject
    EndpointConfig config;

    /**
     * Renders the edit template
     *
     * @param id The function ID
     * @return TemplateInstance
     * @throws IOException on bad file read
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance renderEdit(@QueryParam("id") String id) throws IOException {
        Function func = this.config.functions().get(id);
        return this.editPage.data("id", id)
                .data("body", RawCodeFactory.readRawCode(id))
                .data("resultType", func.resultType())
                .data("params", ParameterFactory.getFullString(func.parameters()));
    }
}
