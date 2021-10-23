package application;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, AeroportWritableComparable, Text> {
    private static final String DELIMETER = ",";
    private static final int DATA_TYPE = 1;
    private static final int DEST_AEROPORT_ID_COLUMN = 14;
    private static final int ARR_DELAY_COLUMN = 18;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() > 0) {
            String[] line = value.toString().split(DELIMETER);
            String delay = line[ARR_DELAY_COLUMN];
            if (delay.length() != 0 && Float.parseFloat(delay) != 0) {
                int destAeroportID = Integer.parseInt(line[DEST_AEROPORT_ID_COLUMN]);
                context.write(new AeroportWritableComparable(destAeroportID, DATA_TYPE),
                        new Text(delay));
            }
        }
    }
}
