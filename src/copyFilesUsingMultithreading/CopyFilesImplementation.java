package copyFilesUsingMultithreading;

import java.io.*;

public class CopyFilesImplementation {
    File sourceDirectory ;
    File destinationDirectory;

    public static void copyDirectory(File sourceDirectory, File destinationDirectory){
        try {
            if (!destinationDirectory.exists()) {
                destinationDirectory.mkdir();
            }
            for(String f : sourceDirectory.list())
                copyDirectoryCompatibityMode(new File(sourceDirectory, f), new File(destinationDirectory, f));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void copyDirectoryCompatibityMode(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            copyDirectory(source, destination);
        } else {
            Thread T1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("I am into Copy File Thread"+Thread.currentThread().getId());
                        copyFile(source, destination);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            T1.start();
//            copyFile(source, destination);
        }
    }

    private static void copyFile(File sourceFile, File destinationFile)
            throws IOException {
        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(destinationFile)) {
            byte[] byteArray = new byte[1024];
            int length;
            while ((length = in.read(byteArray)) > 0) {
                out.write(byteArray, 0, length);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
