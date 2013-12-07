package myskylineapp;

/**
 *
 * @author kostas livieratos
 */
public class ListDoublePoints {

    public DoublePoint first;     //reference to first link of list

    public ListDoublePoints() {
        first = null;
    }

    /**
     *
     * @param diastash1
     * @param diastasi2
     */
    public void insertFirst(double diastasi1, double diastasi2) {
        DoublePoint newPoint = new DoublePoint(diastasi1, diastasi2);
        newPoint.next = first;
        first = newPoint;
    }

    public DoublePoint delete(DoublePoint node) {
        DoublePoint current = first;
        DoublePoint previous = first;

        while (current != node) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;

    }
    
    public DoublePoint extractFirst() {
        return first;
    }
    
    public void append(DoublePoint result) {
        first = result;
    }

    public void displayList() {
        System.out.println("List (first-->last):");
        DoublePoint current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public DoublePoint mergeSort(DoublePoint node) {
        if (node == null || node.next == null) {
            return node;
        }
        DoublePoint a = node;
        DoublePoint b = node.next;
        while (b != null && b.next != null) {
            node = node.next;
            b = b.next.next;
        }
        b = node.next;
        node.next = null;
        return merge(mergeSort(a), mergeSort(b));
    }

    public DoublePoint merge(DoublePoint a, DoublePoint b) {
        DoublePoint temp = new DoublePoint();
        DoublePoint head = temp;
        DoublePoint c = head;

        while (a != null && b != null) {
            if (a.x + a.y <= b.x + b.y) {
                c.next = a;
                c = a;
                a = a.next;
            } else {
                c.next = b;
                c = b;
                b = b.next;
            }
        }

        c.next = (a == null) ? b : a;
        return head.next;
    }

}
