package de.mathisburger.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.Map;

/**
 * Default endpoint configuration in application.yml
 */
@ConfigMapping(prefix = "endpoints")
public interface EndpointConfig {

    /**
     * Sub-field that contains all functions
     * @return Map<String, Function>
     */
    @WithName("functions")
    Map<String, Function> functions();
}
