package application;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AeroportMapper extends Mapper<LongWritable, Text, AeroportWritableComparable, Text> {
    private static final String DELIMETER = ",";
    private static final int CODE_COLOUMN

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() > 0) {

        }
    }
}
