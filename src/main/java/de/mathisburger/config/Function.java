package de.mathisburger.config;

import io.smallrye.config.WithName;

import java.util.Map;

public interface Function {

    @WithName("className")
    String className();

    @WithName("resultType")
    String resultType();

    @WithName("parameters")
    Map<String, String> parameters();
}
