package application;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;


import java.io.IOException;

public class DelayStatisticApp {
    public static void main(String[] args) throws IOException, InterruptedException, ClassCastException, ClassNotFoundException {
        if (args.length != 3) {
            System.err.println("");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(DelayStatisticApp.class);
        MultipleInputs.addInputPath(job, new Path(args[0]),
                TextInputFormat.class, FlightMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]),
                TextInputFormat.class, AeroportMapper.class);
        job.setPartitionerClass(AeroportPartitioner.class);
        job.setGroupingComparatorClass(AeroportGroupingComparator.class);
        job.setReducerClass(AeroportReducer.class);
        job.setMapOutputKeyClass(AeroportWritableComparable.class);
        job.setMapOutputValueClass(Text.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
