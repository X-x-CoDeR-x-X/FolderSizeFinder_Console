import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        String folderPath = "D:/10tons";
        File file = new File(folderPath);
        Node root = new Node(file);

        long fstartTime = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);

        long fendTime = System.currentTimeMillis();
        System.out.println("ForkJoin time taken: " + (fendTime - fstartTime) + "ms");
    }
}
