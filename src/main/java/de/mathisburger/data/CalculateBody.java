package de.mathisburger.data;

import java.util.HashMap;
import java.util.Map;

public class CalculateBody {

    public String id;

    public Map<String, String> parameters;

    public CalculateBody() {
        this.id = "";
        this.parameters = new HashMap<>();
    }

    public String getId() {
        return this.id;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }
}
