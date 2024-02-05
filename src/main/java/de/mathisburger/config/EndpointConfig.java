package de.mathisburger.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.Map;

@ConfigMapping(prefix = "endpoints")
public interface EndpointConfig {

    @WithName("functions")
    Map<String, Function> functions();
}
