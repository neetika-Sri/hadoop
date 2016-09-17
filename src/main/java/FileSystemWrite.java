import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BufferedFSInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.*;
import java.net.URI;

/**
 * Created by neetikasrivastava on 27/08/16.
 */
public class FileSystemWrite {
    public static void main(String[] args) {
        String localPath = args[0];
        boolean create =makeNewDir();
        if(create){
            System.out.println("Directory Created");
            copyFromLocalFile(localPath);
        }
    }

    private static void copyFromLocalFile(String localPath) {
        String dst = "hdfs://localhost:9000/MYDir/SubDir/ABC3.txt";
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(localPath));
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(URI.create(dst),conf);
            /*OutputStream out = fs.create(new Path(dst), new Progressable() {
                public void progress() { // only Java Interface can call this method
                    System.out.println(".....");
                }
            });*/
            FSDataOutputStream out = fs.create(new Path(dst));
            System.out.println("position of file :"+out.getPos());
            IOUtils.copyBytes(in,out,25,true);
            System.out.println("position of file :"+out.getPos());



        }
        catch(IOException io) {

        }


    }

    private static boolean makeNewDir() {
        String path = "hdfs://localhost:9000/MyDir/SubDir";
        boolean created = false;
        Configuration conf = new Configuration();
        try {
            FileSystem fs =  FileSystem.get(conf);
            fs.mkdirs(new Path(path));
            created = true;
        }
        catch(IOException io) {
            //TODO:HAndle Exception
        }
        return created;
    }

}
