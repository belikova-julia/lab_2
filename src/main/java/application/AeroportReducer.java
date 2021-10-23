package application;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AeroportReducer extends Reducer<AeroportWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(AeroportWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iterator = values.iterator();
        Text aeroport = new Text(iterator.next());
        float max = Float.MAX_VALUE;
        float min = Float.MIN_VALUE;
        float sum = 0;
        int count = 0;
        
        while (iterator.hasNext()) {
            float dalay = Float.parseFloat(iterator.next().toString());

        }
    }
}
