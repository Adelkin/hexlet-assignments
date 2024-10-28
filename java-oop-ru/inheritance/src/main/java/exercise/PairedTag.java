package exercise;

import java.util.Map;
import java.util.List;
//import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> children) {
        super(tagName, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder childrenString = new StringBuilder();
        for (Tag child : children) {
            childrenString.append(child.toString());
        }
        return String.format("<%s%s>%s%s</%s>", tagName, renderAttributes(), body, childrenString, tagName);
    }
}
// END
