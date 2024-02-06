package de.mathisburger.data;

/**
 * Request object for configuring a function
 */
public class ConfigBody {

    /**
     * The ID of the function
     */
    public String id;

    /**
     * The class body as text
     */
    public String classBody;

    public ConfigBody() {
        this.id = "";
        this.classBody = "";
    }

    /**
     * Gets the class body
     * @return String
     */
    public String getClassBody() {
        return this.classBody;
    }

    /**
     * Gets the ID
     * @return String
     */
    public String getId() {
        return this.id;
    }
}
