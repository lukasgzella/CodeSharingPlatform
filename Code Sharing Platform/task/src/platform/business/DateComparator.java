package platform.business;

import java.util.Comparator;

public class DateComparator implements Comparator<Snippet> {

    @Override
    public int compare(Snippet o1, Snippet o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}