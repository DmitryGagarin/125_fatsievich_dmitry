package task;

//Добавляет список значений, сделаем это через перечисление
public enum Direction {
    North ("north"), West("west"), South("south"), East("east");
    private String direct;
    Direction(String direct){
        this.direct = direct;
    }

    //метод перемещения, который связан с Vector2.java
    public Vector2 move(Vector2 start, double distance) {
        //набор привытных переменных
        double startX = start.getX();
        double startY = start.getY();

        switch (direct) {
            case "north" -> {
                startY -= distance;
                return new Vector2(startX, startY);
            }
            case "west" -> {
                startX -= distance;
                return new Vector2(startX, startY);
            }
            case "east" -> {
                startX += distance;
                return new Vector2(startX, startY);
            }
            case "south" -> {
                startY += distance;
                return new Vector2(startX, startY);
            }
        }
        return start;
    }
}