import java.util.ArrayList;
import java.util.List;

public class Grid {
    public static final int GRID_SIZE = 2;
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

        return result.toString();
    }

    public boolean isEnd(int i, int j) {
        if (i == GRID_SIZE - 1 && j == GRID_SIZE - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void traverseAllCombinations(int positionX, int positionY) {
        if (isEnd(positionX, positionY)) {
            System.out.println(printGrid());
            return;
        }
        gridArray.get(positionX).get(positionY).setValue(true);
        int positionX1 = next(positionX, positionY);
        int positionY1 = next(positionX, positionY);
        traverseAllCombinations(positionX1, positionY1);
        if (isEnd(positionX, positionY)) {
            System.out.println(printGrid());
            return;
        }

        gridArray.get(positionX).get(positionY).setValue(false);
        positionX1 = next(positionX);
        positionY1 = next(positionY);

        traverseAllCombinations(positionX1, positionY1);
        if (isEnd(positionX, positionY)) {
            System.out.println(printGrid());
            return;
        }
    }

    public class Position {
        public int x;
        public int y;

        public void next() {

        }
    }
}
