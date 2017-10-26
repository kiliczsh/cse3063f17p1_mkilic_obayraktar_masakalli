import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class ArrayComparator implements Comparator<Comparable[]> {
    private final int columnToSort;
    private final boolean ascending;

    public ArrayComparator(int columnToSort, boolean ascending) {
        this.columnToSort = columnToSort;
        this.ascending = ascending;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public int compare(Comparable[] c1, Comparable[] c2) {
        int cmp = c1[columnToSort].compareTo(c2[columnToSort]);
        return ascending ? cmp : -cmp;
    }
}