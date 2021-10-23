package application;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;
import java.io.IOException;

public class DelayStatisticApp {
    public static void main(String[] args) throws IOException, InterruptedException, ClassCastException {
        if (args.length != 3) {
            System.err.println("");
            System.exit(-1);
        }
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Delay statistics");
        job.setJarByClass(DelayStatisticApp.class);
        MultipleInputs.addInputPath(job, new Path(args[0]),
                TextInputFormat.class, FlightMapper.class);
    }
}
