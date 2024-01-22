package lt.techin.exam;

import java.util.Objects;

public class Element {


    private String text;

    private boolean displayed;


    public Element() {
    }

    public Element(String text, boolean displayed) {

        this.text = text;
        this.displayed = displayed;
    }

    public String getText() {
        return text;
    }

    public boolean isDisplayed() {
        return displayed;
    }

    public void click() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return displayed == element.displayed && Objects.equals(text, element.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, displayed);
    }
}
