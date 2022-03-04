package TrafficLights;

public class Light {
        private Color color;

    public Light(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeTheColor(){
        if (color == Color.GREEN){
            color = Color.YELLOW;
        } else if (color == Color.RED){
            color = Color.GREEN;
        } else if (color == Color.YELLOW){
            color = Color.RED;
        }
    }
}
