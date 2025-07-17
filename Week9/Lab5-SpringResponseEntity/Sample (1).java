package Lab.Model;

import java.util.Objects;

/**
 * There is no need to change anything in this class. It is only used for demonstration purposes. Check out the
 * Controller class.
 */
public class Sample {
    private long id;
    private String text;

    public Sample(){

    }
    public Sample(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sample sample = (Sample) o;
        return id == sample.id && Objects.equals(text, sample.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }

    @Override
    public String toString() {
        return "Sample{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
