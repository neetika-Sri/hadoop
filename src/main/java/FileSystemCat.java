import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by neetikasrivastava on 20/08/16.
 */
public class FileSystemCat {
    public static void main(String[] args) throws Exception{
        System.out.println("System CAT:");
        readFile(args[0]);
        System.out.println("System Double CAT using seeking:");
        readFileUsingSeek(args[0]);
System.out.println("Read file in parts :");
        readPartsOfFile(args[0]);

    }

    private static void readFile(String arg) throws IOException {
        String uri = arg;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        InputStream is = null;
        try {
            is = fs.open(new Path(uri));
            IOUtils.copyBytes(is, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(is);

        }
    }

    private static void readFileUsingSeek(String arg) throws IOException {
        String uri = arg;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        FSDataInputStream is = null;
        try {
            is = fs.open(new Path(uri));
            IOUtils.copyBytes(is, System.out, 4096, false);
            is.seek(0);
            IOUtils.copyBytes(is, System.out, 4096, false);

        } finally {
            IOUtils.closeStream(is);

        }
    }
    private static void readPartsOfFile(String arg) throws IOException {
        String uri = arg;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        FSDataInputStream is = null;
        try {
            is = fs.open(new Path(uri));
            byte[] buffer = new byte[100];
            int count = 0;
            int offset = 3; //TODO: what is the use of offset
            int position =0;
            int temp = 0;
            int length = 21;
            //read method
            while(true) {

                try{
                   // offset = offset + count;
                   count = is.read(position,buffer,offset,length);
                    System.out.println("Bytes read "+new String(buffer));
                    System.out.println("Count is "+count);
                    position = position + length;
                    if(count < length) {
                        System.out.println("Count is less than length");
                        break;
                    }
                    //buffer = new byte[100];


                }
                catch (EOFException eo){
                    break;
                }
            }

            //read Fully for an offset
           System.out.println("Read Bytes with Read Fully method");
            position = 0;

            while(true) {

                try{
                    // offset = offset + count;
                    is.readFully(position,buffer,offset,length);
                    System.out.println("Bytes read "+new String(buffer));
                   // System.out.println("Count is "+count);
                    position = position + length;
                  /*  if(count < length) {
                        System.out.println("Count is less than length");
                        break;
                    }*/
                    //buffer = new byte[100];


                }
                catch (EOFException eo){
                    System.out.println("End of file exception");
                    break;
                }
            }

            //read Fully
            System.out.println("Read Fully in  buffer where length = buffer.length ");
            buffer = new byte[100];
            position = 0;
           try{
                is.readFully(position,buffer);
                System.out.println("Bytes read "+ new String(buffer));
               // System.out.println("Count is "+count);
            }
            catch (EOFException eo){
                System.out.println("End of file Exception");


            }

        } finally {
            IOUtils.closeStream(is);

        }
    }

   // public static void write

}
