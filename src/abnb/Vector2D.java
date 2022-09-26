package abnb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vector2D {

    Iterator<Integer> row;
    Iterator<int[]> vector;
    public Vector2D(int[][] vec) {
        vector = Arrays.stream(vec).iterator();
    }

    public int next() {
        if (hasNext()) {
            return row.next();
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        while ((row == null || !row.hasNext()) && vector.hasNext()) {
            row = Arrays.stream(vector.next()).iterator();
        }
        return row != null && row.hasNext();
    }

}
