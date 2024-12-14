import java.io.File;
import java.util.ArrayList;

public class Node {
    private long sizeLimit =50*1024*1024;
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;

    public Node(File folder) {
        this.folder = folder;
        children = new ArrayList<>();
//        this.sizeLimit = sizeLimit;
    }

    public File getFolder() {
        return folder;
    }

    public void addChild(Node node) {
        node.setLevel(level + 1);
        children.add(node);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public long getSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(long sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String readableSize = SizeCalculator.getHumanReadableSize(getSize());
        if (size > getSizeLimit()) {
            builder.append(folder.getName() + " - " + readableSize + "\n");
            for (Node child : children) {
                builder.append("  ".repeat(level + 1) + child.toString());
            }
        }
        return builder.toString();
    }
}
