import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

/**
 * Map Reduce job to find the max temperature in a given year.
 */
public class TemperatureMapReduce 
{
    /**
     * Contains Map and Reduce algorithms.
     */
    public static class MaxTemperatureMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> 
    {    
        // Value occurs if temperature is missing from data set.
        private static final int MISSING = 9999;
            
        /**
         * @see org.apache.hadoop.mapred.Mapper#map(java.lang.Object, java.lang.Object, org.apache.hadoop.mapred.OutputCollector, org.apache.hadoop.mapred.Reporter)
         */
        @Override
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException 
        {         
            String line = value.toString();
            String year = line.substring(14, 18);
            int airTemperature = 0;
            try
            {
                airTemperature = Integer.parseInt(line.substring(26, 30));
            }
            catch (NumberFormatException e)
            {
            }
            
            output.collect(new Text(year), new IntWritable(airTemperature));
        }
    }
    
    static class MaxTemperatureReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> 
    {
        @Override
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException 
        {              
          int maxValue = Integer.MIN_VALUE;
          while (values.hasNext()) 
          {
              maxValue = Math.max(maxValue, values.next().get());
          }
          output.collect(key, new IntWritable(maxValue));
        }
    }
    
	/**
	 * @param args - command line args
	 */
	public static void main(String[] args) 
	{
	    if (args.length != 2) 
	    {
	        System.err.println("Usage: TemperatureMapReduce <input path> <output path>");
	        System.exit(-1);
	    }
	    
    	JobClient client = new JobClient();
    	JobConf conf = new JobConf(TemperatureMapReduce.class);
    	
        FileInputFormat.addInputPath(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));       
    	
    	conf.setMapperClass(TemperatureMapReduce.MaxTemperatureMapper.class);
    	conf.setCombinerClass(TemperatureMapReduce.MaxTemperatureReducer.class); 
    	conf.setReducerClass(TemperatureMapReduce.MaxTemperatureReducer.class); 

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        
    	client.setConf(conf);
    	try 
    	{
    	    JobClient.runJob(conf);
    	} 
    	catch (Exception e) 
    	{
    	    e.printStackTrace();
    	}
	}
}