package de.mathisburger.config;

import io.smallrye.config.WithName;

public interface Function {

    @WithName("path")
    String path();

    @WithName("className")
    String className();

    @WithName("resultType")
    String resultType();
}
