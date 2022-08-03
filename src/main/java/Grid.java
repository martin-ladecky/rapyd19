import java.util.ArrayList;
import java.util.List;

public class Grid {
    public static final int GRID_SIZE = 3;
    public List<List<Point>> gridArray;

    public static Grid getInitiliazedGrid() {
        var grid = new Grid();
        grid.gridArray = new ArrayList<>(GRID_SIZE);
        for (int i = 0; i < GRID_SIZE; i++) {
            var pointList = new ArrayList<Point>(GRID_SIZE);
            grid.gridArray.add(pointList);
            for (int j = 0; j < GRID_SIZE; j++) {
                Point point = new Point();
                pointList.add(point);
            }
        }
        setupDependees(grid);
        return grid;
    }

    private static void setupDependees(Grid grid) {
        grid.gridArray.get(0).get(0).setDependsOn(grid.gridArray.get(1).get(0));
    }

    public String printGrid() {
        StringBuilder result = new StringBuilder();
        for (List<Point> pointList : gridArray) {
            for (Point point : pointList) {
                result.append(point.getValue()).append("\t");
            }
            result.append("\n");
        }
        result.append("=====\n");
        return result.toString();
    }

    public boolean isEnd(Position position) {
        return position.x >= GRID_SIZE - 1 && position.y >= GRID_SIZE - 1;
    }

    public void traverseAllCombinations(Position position) {
        if (isEnd(position)) {
            gridArray.get(position.x).get(position.y).setValue(true);
            System.out.println(printGrid());
            gridArray.get(position.x).get(position.y).setValue(false);
            System.out.println(printGrid());
            return;
        }
        gridArray.get(position.x).get(position.y).setValue(true);
        traverseAllCombinations(position.next());

        gridArray.get(position.x).get(position.y).setValue(false);
        traverseAllCombinations(position.next());
    }

    public static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position next() {
            final int x1 = (this.x + 1) % GRID_SIZE;
            int y1 = this.y;
            if (x1 == 0) {
                y1 = (this.y + 1) % GRID_SIZE;
            }
            return new Position(x1, y1);
        }
    }
}
