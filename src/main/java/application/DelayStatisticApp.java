package application;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;


import java.io.IOException;

public class DelayStatisticApp {
    public static void main(String[] args) throws IOException, InterruptedException, ClassCastException {
        if (args.length != 3) {
            System.err.println("");
            System.exit(-1);
        }
        JobConf job = new JobConf(new Configuration(), Job.class);
        job.setJarByClass(DelayStatisticApp.class);
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
    }
}
