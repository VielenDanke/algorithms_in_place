package strings.medium.java_solutions;

import java.util.*;

public class FindDuplicateFileInSystem_609 {

    static class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            Map<String, List<String>> map = new HashMap<>();

            for (String path : paths) {
                /*
                1. split by " "
                2. take [1:] parts
                3. group them by file content
                */
                String[] dirFiles = path.split(" ");
                for (int i = 1; i < dirFiles.length; i++) {
                    String file = dirFiles[i];
                    int left = file.indexOf("(");
                    int right = file.indexOf(")");
                    String content = file.substring(left + 1, right);
                    map.putIfAbsent(content, new LinkedList<>());
                    map.get(content).add(dirFiles[0] + "/" + file.substring(0, left));
                }
            }
            List<List<String>> result = new LinkedList<>();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getValue().size() > 1) {
                    result.add(entry.getValue());
                }
            }
            return result;
        }
    }

    static class SolutionTwo {
        private static class File {
            String content;
            String name;

            public File(String nameAndContent) {
                int startContentIdx = nameAndContent.indexOf("(");
                this.content = nameAndContent.substring(startContentIdx + 1, nameAndContent.indexOf(")"));
                this.name = nameAndContent.substring(0, startContentIdx);
            }
        }

        private static class Directory {
            String path;
            List<File> files;

            public Directory(String path) {
                this.path = path;
                this.files = new LinkedList<>();
            }
        }

        public List<List<String>> findDuplicate(String[] paths) {
            Map<String , List<String>> l = new HashMap<>();
            for (String path : paths) {
                String[] dirPaths = path.split(" ");
                Directory directory = new Directory(dirPaths[0]);
                for (int i = 1; i < dirPaths.length; i++) {
                    File file = new File(dirPaths[i]);
                    l.putIfAbsent(file.content, new LinkedList<>());
                    l.get(file.content).add(directory.path + "/" + file.name);
                }
            }
            List<List<String >> result = new LinkedList<>();
            for (Map.Entry<String, List<String>> entry : l.entrySet()) {
                if (entry.getValue().size() > 1) {
                    result.add(entry.getValue());
                }
            }
            return result;
        }
    }
}
