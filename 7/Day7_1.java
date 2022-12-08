import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

class FileEntry {
    String name;
    int size = 0;

    public FileEntry(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public long size() {
        return size;
    }

    public void printAllFiles() {
        System.out.println(name + ":" + size());
    }
}

class DirectoryEntry extends FileEntry {
    DirectoryEntry parent;
    Map<String, FileEntry> children;

    public DirectoryEntry(String name, DirectoryEntry parent) {
        super(name, 0);
        this.parent = parent;
        this.name = name;
        children = new HashMap<String, FileEntry>();
    }

    public Collection<FileEntry> getFiles() {
        List<FileEntry> allFiles = new ArrayList<>();
        for (FileEntry f : children.values()) {
            allFiles.add(f);
            if (f instanceof DirectoryEntry)
                allFiles.addAll(((DirectoryEntry) f).getFiles());
        }
        return allFiles;
    }

    public void addFile(FileEntry file) {
        children.put(file.name, file);
    }

    public long size() {
        long res = 0;
        for (FileEntry f : children.values()) {
            res += f.size();
        }
        return res;
    }

    public void printAllFiles() {
        for (FileEntry f : this.getFiles()) {
            if (f instanceof DirectoryEntry) {
                System.out.println(name);
            }
            f.printAllFiles();
        }
    }
}

public class Day7_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        DirectoryEntry root = new DirectoryEntry("/", null);
        DirectoryEntry currentDir = root;
        String line;
        while ((line = input.readLine()) != null) {
            String tokens[] = line.split(" ");
            if (tokens[0].equals("$")) {
                if (tokens[1].equals("cd")) {
                    if (tokens[2].equals("/")) {
                        currentDir = root;
                    } else if (tokens[2].equals("..")) {
                        currentDir = currentDir.parent;
                    } else {
                        currentDir = (DirectoryEntry) currentDir.children.get(tokens[2]);
                    }
                }
            } else if (tokens[0].equals("dir")) {
                currentDir.addFile(new DirectoryEntry(tokens[1], currentDir));
            } else if (tokens[0].equals("ls")) {
                continue;
            } else {
                currentDir.addFile(new FileEntry(tokens[1], Integer.valueOf(tokens[0])));
            }
        }
        int sizeSum = 0;
        for (FileEntry f : root.getFiles()) {
            if (f instanceof DirectoryEntry && f.size() <= 100000) {
                sizeSum += f.size();
            }
        }
        System.out.println(sizeSum);
        input.close();
    }
}