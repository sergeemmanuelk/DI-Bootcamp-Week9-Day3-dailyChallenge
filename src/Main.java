import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Interval arr1[] = { new Interval(1, 3),
                new Interval(7, 9),
                new Interval(4, 6),
                new Interval(10, 13) };
        int n1 = arr1.length;

        if (isIntersect(arr1, n1))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");

        Interval arr2[] = { new Interval(6, 8),
                new Interval(1, 3),
                new Interval(2, 4),
                new Interval(4, 7) };
        int n2 = arr2.length;

        if (isIntersect(arr2, n2))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
    }

    // An interval has start time and end time
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end)
        {
            super();
            this.start = start;
            this.end = end;
        }
    };

    // Function to check if any two intervals overlap
    static boolean isIntersect(Interval arr[], int n) {

        // Sort intervals in increasing order of start time
        Arrays.sort(arr, (i1, i2) -> {
            return i1.start - i2.start;
        });

        // In the sorted array, if start time of an interval
        // is less than end of previous interval, then there
        // is an overlap
        for(int i = 1; i < n; i++)
            if (arr[i - 1].end > arr[i].start)
                return true;

        // If we reach here, then no overlap
        return false;
    }

}