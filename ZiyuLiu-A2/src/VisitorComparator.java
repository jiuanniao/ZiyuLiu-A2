import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First sort by age in ascending order
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }
        // If ages are the same, sort by Fast Pass status in descending order (Fast Pass holders first)
        return Boolean.compare(v2.hasFastPass(), v1.hasFastPass());
    }
}