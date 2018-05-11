package com.focus.rm01;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JobRun {
	
	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://node1:9000");
		conf.set("mapred.job.tracker", "node1:9001");
		conf.set("mapred.jar", "c:\\Users\\Administrator\\Desktop\\wc-1.jar");
		
		try {
			Job job = new Job(conf);
			job.setJarByClass(JobRun.class);
			
			job.setMapperClass(WcMapper.class);
			job.setReducerClass(WcReducer.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);
			
//			job.setNumReduceTasks(1);	//设置reduce任务的个数，默认为1
			
			
			//mapreduce 输入数据所在目录或者文件
		    FileInputFormat.addInputPath(job, new Path("/usr/input/wc"));
		    
		    //mr执行后的输出数据的目录
		    FileOutputFormat.setOutputPath(job, new Path("/usr/output/wc"));
		    
		    //等待任务完成
		    System.exit(job.waitForCompletion(true) ? 0 : 1);
		    
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
