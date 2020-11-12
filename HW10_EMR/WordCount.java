import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {
    // This static TokenizerMapper Class extends the Mapper Parent Class and maps key/value pairs that the Reducer will use as input.
    // The map method, which is overridden from the Parent, is called once for each key/value pair in the data.
    // It processes one line at a time, as provided by the specified TextInputFormat, then splits the line into tokens to emit the key/value pairs.
    //
    // "The Mapper’s job is to process the input data. 
    //  Generally the input data is in the form of file or directory and is stored in the Hadoop file system (HDFS). 
    //  The input file is passed to the mapper function line by line. 
    //  The mapper processes the data and creates several small chunks of data." 
    // source: https://www.tutorialspoint.com/hadoop/hadoop_mapreduce.htm
    public static class TokenizerMapper extends Mapper < Object, Text, Text, IntWritable > {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                context.write(word, one);
            }
        }
    }

    // This static IntSumReducer Class extends the Reducer Parent Class.
    // The reduce method, which is overridden from the Parent, is called once for each key in the mapped data.
    // It sums the values, which are the occurrence counts for each key.
    //
    // "The Reducer’s job is to process the data that comes from the mapper. 
    //  After processing, it produces a new set of output, which will be stored in the HDFS."
    // source: https://www.tutorialspoint.com/hadoop/hadoop_mapreduce.htm
    public static class IntSumReducer extends Reducer < Text, IntWritable, Text, IntWritable > {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable < IntWritable > values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val: values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    // This is the main executable method in the WordCount Class.
    // It is passed two params as args when excuted:
    //  hadoop jar /usr/lib/hadoop-mapreduce/hadoop-mapreduce-examples.jar wordcount /input /output
    //  args[0] = /input
    //  args[1] = /output
    // 
    // Step 1: Instantiate an Instance of an org.apache.hadoop.conf.Configuration Object (conf)
    // Step 2: Instantiate an Instance of an org.apache.hadoop.mapreduce.Job Object (job)
    // Step 3: set property values on job Object 
    // Step 4: set FileInputFormat and FileOutputFormat Object paths using parm values passed as args
    // Step 5: Execute job
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(WordCount.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}