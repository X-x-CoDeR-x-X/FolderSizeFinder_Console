import java.io.File;
import java.util.Scanner;

public class Main {
    private static String[] sizeNames =
            {"b", "kb", "Mb", "Gb"};

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите путь к папке или файлу:");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            getFolderSize(file);
        }
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
