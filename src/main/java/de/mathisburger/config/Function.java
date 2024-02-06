package de.mathisburger.config;

import io.smallrye.config.WithName;

import java.util.Map;

/**
 * Function interface that implements configuration
 * information.
 */
public interface Function {

    /**
     * The java class name
     * @return String
     */
    @WithName("className")
    String className();

    /**
     * The result type (String, int, ...)
     * @return String
     */
    @WithName("resultType")
    String resultType();

    /**
     * The parameters of the function
     * @return Map<String, Function>
     */
    @WithName("parameters")
    Map<String, String> parameters();
}
