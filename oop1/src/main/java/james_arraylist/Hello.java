package james_arraylist;

public class Hello implements Cloneable {
    private int id;

    public Hello(int id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
