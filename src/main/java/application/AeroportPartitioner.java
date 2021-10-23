package application;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AeroportPartitioner extends Partitioner<AeroportWritableComparable, Text> {

    @Override
    public int getPartition(AeroportWritableComparable aeroportWritableComparable, Text text, int partitionIdx) {
        return aeroportWritableComparable;
    }
}
