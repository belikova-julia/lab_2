package application;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AeroportMapper extends Mapper<LongWritable, Text, AeroportWritableComparable, Text> {
    private static final String DELIMETER = ",";
    private static final int CODE_COLUMN = 0;
    private static final int DESCRIPTION_COLUMN = 1;
    private static final String EXTRA_QUOT = "\"";


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() > 0) {
            String[] line = value.toString().replace("").split(DELIMETER)

        }
    }
}
