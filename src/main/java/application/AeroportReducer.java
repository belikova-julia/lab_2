package application;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AeroportReducer extends Reducer<AeroportWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(AeroportWritableComparable key, Iterable<Text> values, Context context) throws
}
