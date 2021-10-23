package application;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightMapper extends Mapper<LongWritable, Text, AeroportWritableComparable, Text> {
    private static final String DELIMETER = ",";
    private static final int DATA_TYPE = 1;
    private static final int DEST_AEROPORT_ID_COLUMN = 14;
    private static final int 
}
