package myskylineapp;

/**
 *
 * @author kostas livieratos
 */
public class SkylineAlg2 {

    public void sorting(ListDoublePoints list) {

        DoublePoint p = list.first;
        DoublePoint q = list.first.next;

        while (p != null) {
            DoublePoint tempP = p.next;
            while (q != null) {

                DoublePoint tempQ = q.next;
                if (p.dominate(q) == p) {
                    list.delete(q);
                }  else if(q.dominate(p) == q) {
                    list.delete(p);
                    }
                q = tempQ;
            }
            q = p.next;
            p = tempP;

        }

    }
}
