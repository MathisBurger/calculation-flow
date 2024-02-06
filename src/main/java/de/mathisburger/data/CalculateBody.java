package de.mathisburger.data;

import java.util.HashMap;
import java.util.Map;

/**
 * The request object that is serialized for handling the
 * application request
 */
public class CalculateBody {

    /**
     * Function ID
     */
    public String id;

    /**
     * All parameters
     */
    public Map<String, String> parameters;

    public CalculateBody() {
        this.id = "";
        this.parameters = new HashMap<>();
    }

    /**
     * Used to get the ID
     * @return String
     */
    public String getId() {
        return this.id;
    }

    /**
     * Gets all parameters
     * @return Map<String, String>
     */
    public Map<String, String> getParameters() {
        return this.parameters;
    }
}
