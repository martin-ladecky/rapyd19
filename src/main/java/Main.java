public class Main {
    public static void main(String[] args) {
        Grid grid = Grid.getInitiliazedGrid();

        grid.traverseAllCombinations(new Grid.Position(0,0));

        System.out.println(grid.printGrid() );
    }

}
