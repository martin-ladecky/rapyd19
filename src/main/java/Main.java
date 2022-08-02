public class Main {
    public static void main(String[] args) {
        Grid grid = Grid.getInitiliazedGrid();

        grid.traverseAllCombinations(0,0);

        System.out.println(grid.printGrid() );
    }

}
