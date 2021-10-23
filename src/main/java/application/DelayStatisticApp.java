package application;

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

        Job job = Job.getInstance();
        job.setJarByClass(DelayStatisticApp.class);
        job.setJobName("Delay statistics");
        MultipleInputs.addInputPath(
                job,
                new Path(args[0]),
                TextInputFormat.class,
                FlightMapper.class));
    }
}
