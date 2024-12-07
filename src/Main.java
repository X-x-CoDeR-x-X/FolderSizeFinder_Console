import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static String[] sizeNames =
            {"b", "kb", "Mb", "Gb"};


    public static void main(String[] args) {

        String folderPath = "d:/coding/";
        File file = new File(folderPath);
        Long startTime = System.currentTimeMillis();
        System.out.println(getHumanReadableSize(getFolderSize(file)));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

//        Long startTime = System.currentTimeMillis();
//        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
//        ForkJoinPool pool = new ForkJoinPool();
//        long size = pool.invoke(calculator);
//        System.out.println(size);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time taken: " + (endTime - startTime) + "ms");


//        while (true) {
//            System.out.println("Введите путь к папке или файлу:");
//            String path = new Scanner(System.in).nextLine();
//            File file = new File(path);
//            getFolderSize(file);
//        }
    }

    public static Long getFolderSize(File path) {
        if (path.isFile()) {
            return path.length();
        }
        Long dirSize = 0L;
        File[] files = path.listFiles();
        for (File file : files) {
            dirSize += getFolderSize(file);
        }
        return dirSize;
    }

    public static String getHumanReadableSize(long length) {
        int power = (int) (Math.log(length) / Math.log(1024));
        double value = length / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100.;
        return roundedValue + " " + sizeNames[power];
    }
}
