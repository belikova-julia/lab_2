package application;

import org.apache.hadoop.io.WritableComparator;

public class AeroportGroupingComparator extends WritableComparator {
    public AeroportGroupingComparator() {
        super(AeroportWritableComparable.class, true);
    }
}
