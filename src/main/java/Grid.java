import java.util.ArrayList;
import java.util.List;

public class Grid {
    public static final int GRID_SIZE = 9;
    public List<List<Point>> gridArray;

    public static long gridNumber = 1;

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
        grid.gridArray.get(1).get(0).setDependsOn(grid.gridArray.get(2).get(0));
        grid.gridArray.get(2).get(0).setDependsOn(grid.gridArray.get(3).get(0));

        grid.gridArray.get(0).get(1).setDependsOn(grid.gridArray.get(0).get(2));
        grid.gridArray.get(0).get(2).setDependsOn(grid.gridArray.get(0).get(3));
        grid.gridArray.get(0).get(3).setDependsOn(grid.gridArray.get(0).get(4));
        grid.gridArray.get(0).get(4).setDependsOn(grid.gridArray.get(0).get(5));
        grid.gridArray.get(0).get(5).setDependsOn(grid.gridArray.get(1).get(5));
        grid.gridArray.get(1).get(5).setDependsOn(grid.gridArray.get(2).get(5));

        grid.gridArray.get(2).get(4).setDependsOn(grid.gridArray.get(1).get(4));
        grid.gridArray.get(1).get(4).setDependsOn(grid.gridArray.get(1).get(3));
        grid.gridArray.get(1).get(3).setDependsOn(grid.gridArray.get(1).get(2));
        grid.gridArray.get(1).get(2).setDependsOn(grid.gridArray.get(1).get(1));

        grid.gridArray.get(2).get(3).setDependsOn(grid.gridArray.get(2).get(2));
        grid.gridArray.get(2).get(2).setDependsOn(grid.gridArray.get(2).get(1));

        grid.gridArray.get(3).get(2).setDependsOn(grid.gridArray.get(3).get(1));
        grid.gridArray.get(3).get(1).setDependsOn(grid.gridArray.get(4).get(1));
        grid.gridArray.get(4).get(1).setDependsOn(grid.gridArray.get(5).get(1));

        grid.gridArray.get(3).get(3).setDependsOn(grid.gridArray.get(3).get(4));
        grid.gridArray.get(3).get(4).setDependsOn(grid.gridArray.get(3).get(5));


        grid.gridArray.get(4).get(2).setDependsOn(grid.gridArray.get(4).get(3));
        grid.gridArray.get(4).get(3).setDependsOn(grid.gridArray.get(4).get(4));
        grid.gridArray.get(4).get(4).setDependsOn(grid.gridArray.get(4).get(5));

        grid.gridArray.get(5).get(0).setDependsOn(grid.gridArray.get(4).get(0));
        grid.gridArray.get(6).get(0).setDependsOn(grid.gridArray.get(5).get(0));
        grid.gridArray.get(7).get(0).setDependsOn(grid.gridArray.get(6).get(0));

        grid.gridArray.get(5).get(2).setDependsOn(grid.gridArray.get(5).get(3));
        grid.gridArray.get(5).get(3).setDependsOn(grid.gridArray.get(5).get(4));

        grid.gridArray.get(0).get(6).setDependsOn(grid.gridArray.get(1).get(6));
        grid.gridArray.get(0).get(7).setDependsOn(grid.gridArray.get(0).get(6));
        grid.gridArray.get(1).get(7).setDependsOn(grid.gridArray.get(0).get(7));

        grid.gridArray.get(4).get(6).setDependsOn(grid.gridArray.get(3).get(6));
        grid.gridArray.get(4).get(7).setDependsOn(grid.gridArray.get(4).get(6));
        grid.gridArray.get(4).get(8).setDependsOn(grid.gridArray.get(4).get(7));

        grid.gridArray.get(5).get(5).setDependsOn(grid.gridArray.get(5).get(6));
        grid.gridArray.get(5).get(6).setDependsOn(grid.gridArray.get(5).get(7));
        grid.gridArray.get(5).get(7).setDependsOn(grid.gridArray.get(5).get(8));

        grid.gridArray.get(6).get(6).setDependsOn(grid.gridArray.get(6).get(7));

        grid.gridArray.get(7).get(6).setDependsOn(grid.gridArray.get(7).get(5));
        grid.gridArray.get(7).get(5).setDependsOn(grid.gridArray.get(6).get(5));
        grid.gridArray.get(6).get(5).setDependsOn(grid.gridArray.get(6).get(4));
        grid.gridArray.get(6).get(4).setDependsOn(grid.gridArray.get(6).get(3));
        grid.gridArray.get(6).get(3).setDependsOn(grid.gridArray.get(6).get(2));
        grid.gridArray.get(6).get(2).setDependsOn(grid.gridArray.get(6).get(1));

        grid.gridArray.get(8).get(2).setDependsOn(grid.gridArray.get(7).get(2));
        grid.gridArray.get(7).get(2).setDependsOn(grid.gridArray.get(7).get(3));
        grid.gridArray.get(7).get(3).setDependsOn(grid.gridArray.get(7).get(4));

        grid.gridArray.get(2).get(7).setDependsOn(grid.gridArray.get(2).get(6));
        grid.gridArray.get(3).get(7).setDependsOn(grid.gridArray.get(2).get(7));

        grid.gridArray.get(8).get(1).setDependsOn(grid.gridArray.get(7).get(1));

        grid.gridArray.get(8).get(3).setDependsOn(grid.gridArray.get(8).get(4));

        grid.gridArray.get(8).get(5).setDependsOn(grid.gridArray.get(8).get(6));
        grid.gridArray.get(8).get(6).setDependsOn(grid.gridArray.get(8).get(7));
        grid.gridArray.get(8).get(7).setDependsOn(grid.gridArray.get(7).get(7));
        grid.gridArray.get(7).get(7).setDependsOn(grid.gridArray.get(7).get(8));

        grid.gridArray.get(0).get(8).setDependsOn(grid.gridArray.get(1).get(8));
        grid.gridArray.get(1).get(8).setDependsOn(grid.gridArray.get(2).get(8));


    }

    public String printGrid() {
        StringBuilder result = new StringBuilder();
        for (List<Point> pointList : gridArray) {
            for (Point point : pointList) {
                result.append(point.getValue()).append("\t");
            }
            result.append("\n");
        }
        result.append("=== ").append(gridNumber).append(" ==\n");
        return result.toString();
    }

    public boolean isEnd(Position position) {
        return position.x >= GRID_SIZE - 1 && position.y >= GRID_SIZE - 1;
    }

    public void traverseAllCombinations(Position position) {
        final Point point = gridArray.get(position.x).get(position.y);
        if (isEnd(position)) {
            point.setValue(true);
//            System.out.println(printGrid());
            gridNumber++;
            if (gridNumber % 100_000_000 == 0) {
                System.out.println(printGrid());
            }
            point.setValue(false);
//            System.out.println(printGrid());
            gridNumber++;

            if (gridNumber % 100_000_000 == 0) {
                System.out.println(printGrid());
            }
            return;
        }
        point.setValue(true);
        if (allDependesOnTrue(point)) {
            traverseAllCombinations(position.next());
        }

        point.setValue(false);
        if (allDependeesFalse(point)) {
            traverseAllCombinations(position.next());
        }
    }

    private boolean allDependeesFalse(Point point) {
        if (point == null) {
            return true;
        }
        if (point.getValue() == null) {
            point.setValue(false);
        }
        boolean result;
        if (!point.getValue()) {
            result = allDependeesFalse(point.getDependee());
        } else {
            result = false;
        }
        return result;
    }

    private boolean allDependesOnTrue(Point point) {
        if (point == null) {
            return true;
        }
        if (point.getValue() == null) {
            point.setValue(true);
        }
        boolean result;
        if (point.getValue()) {
            result = allDependesOnTrue(point.getDependsOn());
        } else {
            result = false;
        }
        return result;
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
