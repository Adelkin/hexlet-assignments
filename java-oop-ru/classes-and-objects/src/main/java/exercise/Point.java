package exercise;

// BEGIN
public class Point {
    private int x;
    private int y;

    // Конструктор, который принимает координаты x и y
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Метод для получения координаты по оси x
    public int getX() {
        return x;
    }

    // Метод для получения координаты по оси y
    public int getY() {
        return y;
    }
}
// END
