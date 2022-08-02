public class Point {
//    who is dependent on this Node
    private Point dependee = null;
//    This node depends on. No dependsOn means it is a bulb
    private Point dependsOn = null;

    public Point getDependee() {
        return dependee;
    }

    private Boolean value = null;

    public void setDependee(Point dependee) {
        this.dependee = dependee;
    }

    public Point getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(Point dependsOn) {
        this.dependsOn = dependsOn;
        dependsOn.setDependee(this);
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
