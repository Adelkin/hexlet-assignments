package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String labelText;
    private TagInterface childTag;

    public LabelTag(String labelText, TagInterface childTag) {
        this.labelText = labelText;
        this.childTag = childTag;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", labelText, childTag.render());
    }
}
// END
