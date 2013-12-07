package myskylineapp;

/**
 *
 * @author kostas livieratos 
 */
public class SkylineAlg1 {

    public SkylineAlg1() {

    }

    public void dominating(ListDoublePoints MyList) {
        DoublePoint p = MyList.first;
        DoublePoint q = (MyList.first).next;

        while (p != null) {
            DoublePoint tempP = p.next;
            while (q != null) {

                DoublePoint tempQ = q.next;
                    if (p.dominate(q) == p) {
                        MyList.delete(q);
                    } else if(q.dominate(p) == q) {
                        MyList.delete(p);
                    }

                q = tempQ;
            }
            q = MyList.first;
            p = tempP;

        }
    }

}
