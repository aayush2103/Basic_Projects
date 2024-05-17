package solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Single Responsibility Principle
//      - a class should have only 1 reason to change
//      - Separation Of Concerns : different classes handling different, independent tasks/problems
public class SRP {
    public static void main(String[] args) throws Exception {
        // 1.
        Journal j = new Journal();
        j.addEntry("first ever entry");
        j.addEntry("second entry");
        System.out.println(j);

        // 2.
        Persistence p = new Persistence();
        p.saveToFile(j, "some-filename.txt", true);
    }
}

class Journal {
    private int count = 0;
    private List<String> entries = new ArrayList<>();

    public void addEntry(String entry) {
        entries.add("" + (++count) + ": " + entry);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    // 1. here we break the SRP by including methods which are not to be handled by this Journal class
    public void save(String fileName) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(fileName)) {
            out.println(toString());
        }
    }
    public void load(String filename) {}
    public void load(URL url) {}
}

// 2. the file saving etc methods should be part of some other class which should have the
//    'Single Responsibility Principle' to handle operations related to files etc as class
//    'Journal' only has the 'SRP' to handle journal entry related features
class Persistence {
    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }
    public void load(Journal journal, String filename) {}
    public void load(Journal journal, URL url) {}
}
