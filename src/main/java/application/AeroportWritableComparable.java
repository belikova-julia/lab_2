package application;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AeroportWritableComparable implements WritableComparable {
    private int aeroportID;
    private int dataType;

    public AeroportWritableComparable(int aeroportID, int dataType) {
        this.aeroportID = aeroportID;
        this.dataType = dataType;
    }

    @Override
    public int compareTo(Object obj) {
        AeroportWritableComparable other = (AeroportWritableComparable)obj;
        if (this.aeroportID == other.aeroportID)
            return Integer.compare(this.dataType, other.dataType);
        if (this.aeroportID < other.aeroportID)
            return -1;
        return 1;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(aeroportID);
        dataOutput.writeInt(dataType);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.aeroportID = dataInput.readInt();
        this.dataType = dataInput.readInt();

    }
}
