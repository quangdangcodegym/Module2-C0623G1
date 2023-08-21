package james_trycatch;

public class Triangle {
    private int a;
    private int b;
    private int c;
    public Triangle(int a, int b, int c) throws TriangleException  {

       if (a <= 0 || b <= 0 || c <= 0) {
           throw new TriangleException("Tam giac khong hop le");
       }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public void hello() throws Exception {
        throw new Exception("Avavav");
    }
    public void hello1(){

    }

    public Triangle() {
    }
}
