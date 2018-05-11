package com.focus.rm02;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class JobRun {
	
	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://node1:9000");
		conf.set("mapred.job.tracker", "node1:9001");
		conf.set("mapred.jar", "C:\\Users\\Administrator\\Desktop\\qq.jar");
		
		try {
			
			
/*			Job job = new Job(conf);
			job.setJarByClass(JobRun.class);
			job.setMapperClass(WcMapper.class);
			job.setReducerClass(WcReduce.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);
			
			//job.setNumReduceTasks(1);//设置reduce任务的个数，默认为1
			
			//输入数据所在文件或者目录
			FileInputFormat.addInputPath(job, new Path("/usr/input/wc"));
			//输出数据所在目录
			FileOutputFormat.setOutputPath(job, new Path("/usr/output/wc"));
			System.exit(job.waitForCompletion(true) ? 0 : 1);*/
			
			Job job = new Job(conf);
			job.setJobName("qq");
			job.setJarByClass(JobRun.class);
			job.setMapperClass(Test2Mapper.class);
			job.setReducerClass(Test2Reduce.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);
			
			//job.setNumReduceTasks(1);//设置reduce任务的个数，默认为1
			
			//输入数据所在文件或者目录
			FileInputFormat.addInputPath(job, new Path("/usr/input/qq"));
			//输出数据所在目录
			FileOutputFormat.setOutputPath(job, new Path("/usr/output/qq"));
			System.exit(job.waitForCompletion(true) ? 0 : 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
