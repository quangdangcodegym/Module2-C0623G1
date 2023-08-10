package abstract_interface;

// class Circle con kế thừa lớp cha thì phải ghi đè phương thức trừu tượng của lớp cha
// một lớp trừu tượng kế thừa một lớp cha trừng thì ko can ghi đè phương thức trừu tượng của lớp cha
public  class Circle extends Shape {
    private double radius;

    public double getArea(){
        return radius*radius*Math.PI;
    }

    // overload: thể hiện tính đa hình - tại thời điểm compile
    @Override
    public void resize(int percent) {
//        this.radius =  ?? tìm công thức để cập nhật lại bán kinh
    }
    public int resize(int percent, String name) {
        return 0;
    }
}
