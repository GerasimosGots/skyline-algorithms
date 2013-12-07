package myskylineapp;

/**
 *
 * @author kostas livieratos
 */
public class DoublePoint {

    public double x, y;                     //the coordinates of each point
    public DoublePoint next, node;          //next link in list

    public DoublePoint() {
        //if called with empty contructor, then two random numbers in radius (0,10) are set to x and y.
        x = (int) (Math.random() * ((10) + 1));
        y = (int) (Math.random() * ((10) + 1));
    }
    
    public DoublePoint(double diastasi1, double diastasi2) {
        x = diastasi1;
        y = diastasi2;
    }

    public DoublePoint dominate(DoublePoint q) {
        if ((this.x <= q.x && this.y < q.y) || (this.x < q.x && this.y <= q.y) || (this.x < q.x && this.y < q.y)) {
            return this;
        }
        return null;
    }

    public void displayNode() {
        System.out.println("{" + this.x + "," + this.y + "}");
    }


}
