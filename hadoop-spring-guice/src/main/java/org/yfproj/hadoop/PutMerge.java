/*
 * Copyright (c) 2012-2013 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by yi-Ware team.
 * Software code and design for the team, copy rights reserved.
 */

package org.yfproj.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2013-03-03 7:24 PM
 * @since JDK 1.5
 */
public class PutMerge {

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        FileSystem hdfs = FileSystem.get(configuration);
        FileSystem local = FileSystem.getLocal(configuration);

        Path inputDir = new Path(args[0]);

        Path hdfsDir = new Path(args[1]);

        FileStatus[] inputFiles = local.listStatus(inputDir);

        FSDataOutputStream out = hdfs.create(hdfsDir);

        for (FileStatus inputFile : inputFiles) {
            System.out.println(inputFile.getPath().getName());
            FSDataInputStream in = local.open(inputFile.getPath());
            byte buffer[] = new byte[256];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0){
                out.write(buffer,0,bytesRead);
            }
            in.close();
        }
        out.close();

    }
}
