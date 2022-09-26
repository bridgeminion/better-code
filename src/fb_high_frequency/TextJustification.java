package fb_high_frequency;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int begin = 0;
        while(begin < words.length){
            int end = findWordsForLine(begin, maxWidth, words);
            ans.add(justifyLine(begin, end, maxWidth, words));
            begin = end + 1;
        }
        return ans;
    }
    private int findWordsForLine(int begin, int maxWidth, String[] words){
        int end = begin;
        int width = words[end++].length();
        while(end < words.length && width + 1 + words[end].length() <= maxWidth)
            width += (1 + words[end++].length());
        return end - 1;
    }
    private String justifyLine(int begin, int end, int maxWidth, String[] words){
        StringBuilder line = new StringBuilder();
        if(begin == end)
            return line.append(words[begin]).append(multiSpace(maxWidth - line.length())).toString();
        boolean lastLine = (end == words.length - 1);
        int numSpaceSlot = end - begin;
        int totalSpace = maxWidth - wordsLength(begin, end, words);
        String spaceForSlot = lastLine ? " " : multiSpace(totalSpace / numSpaceSlot);
        int remainder = lastLine ? 0 : totalSpace % numSpaceSlot;
        for(int i=begin; i<=end; i++){
            line.append(words[i])
                    .append(i == end ? "" : spaceForSlot)
                    .append(remainder-- > 0 ? " " : "");
        }
        return lastLine ? line.append(multiSpace(maxWidth - line.length())).toString() : line.toString();
    }
    private int wordsLength(int begin, int end, String[] words){
        int length = 0;
        for(int i=begin; i<=end; i++)
            length += words[i].length();
        return length;
    }
    private String multiSpace(int length){
        StringBuilder space = new StringBuilder();
        for(int i=0; i<length; i++)
            space.append(" ");
        return space.toString();
    }

    public static void main(String[] args) {
        TextJustification app = new TextJustification();
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        List<String> result = app.fullJustify(words, 16);
    }
}
