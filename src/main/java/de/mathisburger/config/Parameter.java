package de.mathisburger.config;

import io.smallrye.config.WithName;

public interface Parameter {

    @WithName("type")
    String type();

    @WithName("name")
    String name();
}
