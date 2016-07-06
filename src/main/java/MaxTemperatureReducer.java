import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by neetikasrivastava on 05/07/16.
 */
public class MaxTemperatureReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int maxValue = Integer.MIN_VALUE;
        for(IntWritable value : values  ){
            maxValue = Math.max(maxValue, value.get());

        }
        context.write(key, new IntWritable(maxValue));
    }
}
