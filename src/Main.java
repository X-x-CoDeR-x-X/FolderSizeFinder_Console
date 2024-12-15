import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        ParametersBag bag = new ParametersBag(args);
        long sizeLimit = bag.getLimit();
        String folderPath = bag.getPath();

        File file = new File(folderPath);
        Node root = new Node(file, sizeLimit);


        long startTime = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);

        long endTime = System.currentTimeMillis();
        System.out.println("ForkJoin time taken: " + (endTime - startTime) + "ms");
    }
}
