package de.mathisburger.config;

import io.smallrye.config.WithName;

import java.util.Map;

public interface Function {

    @WithName("path")
    String path();

    @WithName("className")
    String className();

    @WithName("resultType")
    String resultType();

    @WithName("parameters")
    Map<String, String> parameters();
}
