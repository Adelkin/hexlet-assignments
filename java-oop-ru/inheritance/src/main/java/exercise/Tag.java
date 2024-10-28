package exercise;

//import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    protected String tagName;
    protected Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    protected String renderAttributes() {
        StringBuilder attributesString = new StringBuilder();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            attributesString.append(String.format(" %s=\"%s\"", entry.getKey(), entry.getValue()));
        }
        return attributesString.toString();
    }

    public abstract String toString();
}
// END
