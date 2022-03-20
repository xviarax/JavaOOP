package shape;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        super.setArea(this.calculateArea());
        super.setPerimeter(this.getPerimeter());
    }

    @Override
    public double calculatePerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public double calculateArea() {
        super.setArea(width * height);
        return super.getArea(); // др начин за взимането, moje bez super
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }
}
