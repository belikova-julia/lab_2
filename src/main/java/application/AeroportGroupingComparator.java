package application;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AeroportGroupingComparator extends WritableComparator {

    public AeroportGroupingComparator() {
        super(AeroportWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable aeroport1, WritableComparable aeroport2) {
        AeroportWritableComparable a1 = (AeroportWritableComparable)aeroport1;
        AeroportWritableComparable a2 = (AeroportWritableComparable)aeroport2;

        return Integer.compare(a1.getAeroportID(), a2.getAeroportID());
    }
}
