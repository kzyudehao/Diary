package com.focus.rm02;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WcMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	
	//重写map方法
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		StringTokenizer st = new StringTokenizer(line);
		
		while(st.hasMoreTokens()){
			String word = st.nextToken();
			context.write(new Text(word), new IntWritable(1));
		}
		
	}
	
}
