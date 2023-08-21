package james_clone;

public class SubItem implements Cloneable{
    public String text;

    public SubItem(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SubItem{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}