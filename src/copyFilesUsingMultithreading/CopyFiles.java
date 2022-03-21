package copyFilesUsingMultithreading;

import java.io.File;

public class CopyFiles implements Runnable{
//    private File source = new File("FileTree");
//    private File destination = new File("FileTreeCopy");

      private File source;
      private File destination;

    public CopyFiles(File source, File destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        CopyFilesImplementation.copyDirectory(source,destination);
    }

}
