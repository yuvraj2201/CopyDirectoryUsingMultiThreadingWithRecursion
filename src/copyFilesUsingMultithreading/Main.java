package copyFilesUsingMultithreading;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        File srcFolder = new File("/home/yuvrajsingh/Downloads");
        File destinationFolder = new File("FileTreeCopy");
        Long startTime = System.currentTimeMillis();
//        ExecutorService executor = Executors.newFixedThreadPool(10);// TRY : creating a pool of 10 threads
//        for (int i = 0; i < 10; i++) {
//            CopyFiles copyFiles = new CopyFiles(srcFolder,destinationFolder);
//            executor.execute(copyFiles);

        CopyFiles copyFiles = new CopyFiles(srcFolder,destinationFolder);
        Thread copyThread = new Thread(copyFiles);
        copyThread.start();
//        copyThread.join();
        System.out.println("TotalTime = "+(System.currentTimeMillis() - startTime) );
        }
//        executor.shutdown();
//        while (!executor.isTerminated()) {   }
//        System.out.println("Finished all threads");



    }
