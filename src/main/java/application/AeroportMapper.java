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
    private static final int DATA_TYPE = 0;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() > 0) {
            String[] line = value.toString()
                    .replace(EXTRA_QUOT, "")
                    .split(DELIMETER);
            int code = Integer.parseInt(line[CODE_COLUMN]);
            String description = line[DESCRIPTION_COLUMN];
            context.write(new AeroportWritableComparable(code, DATA_TYPE), new Text(description));

        }
    }
}
