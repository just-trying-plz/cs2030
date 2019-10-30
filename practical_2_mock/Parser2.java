import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Parser {
    private List<String> lines;

    private Parser(List lines) {
        this.lines = new ArrayList<String>();

        for (Object line : lines) {
            this.lines.add(String.valueOf(line));
        }
    }

    public static Parser parse(List lines) {
        return new Parser(lines.subList(0, lines.size()));
    }

    public Parser linecount() {
        return new Parser(List.of(this.lines.size()));
    }

    public Parser wordcount() {
        int words = 0;

        for (String line : this.lines) {
            if (!line.isEmpty() && !line.isBlank()) {
                words += line.split(" ").length;
            }
        }

        return new Parser(List.of(words));
    }


    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < this.lines.size(); i++) {
            output += this.lines.get(i);
            
            if (i < this.lines.size() - 1) {
                output += "\n";
            }
        }

        return output;
    }
}
