package String_Matching;

import java.util.*;

class AhoCorasickNode {
    Map<Character, AhoCorasickNode> children;
    AhoCorasickNode failureLink;
    List<String> output;

    public AhoCorasickNode() {
        children = new HashMap<>();
        failureLink = null;
        output = new ArrayList<>();
    }
}

public class AhoCorasick {
    private AhoCorasickNode root;

    public AhoCorasick() {
        root = new AhoCorasickNode();
    }

    public void addPattern(String pattern) {
        AhoCorasickNode currNode = root;
        for (char c : pattern.toCharArray()) {
            currNode.children.putIfAbsent(c, new AhoCorasickNode());
            currNode = currNode.children.get(c);
        }
        currNode.output.add(pattern);
    }

    public void buildFailureLinks() {
        Queue<AhoCorasickNode> queue = new LinkedList<>();
        for (AhoCorasickNode childNode : root.children.values()) {
            childNode.failureLink = root;
            queue.add(childNode);
        }

        while (!queue.isEmpty()) {
            AhoCorasickNode currNode = queue.remove();
            for (char c : currNode.children.keySet()) {
                AhoCorasickNode childNode = currNode.children.get(c);
                queue.add(childNode);

                AhoCorasickNode failureLinkNode = currNode.failureLink;
                while (failureLinkNode != null && !failureLinkNode.children.containsKey(c)) {
                    failureLinkNode = failureLinkNode.failureLink;
                }
                childNode.failureLink = (failureLinkNode == null) ? root : failureLinkNode.children.get(c);

                childNode.output.addAll(childNode.failureLink.output);
            }
        }
    }

    public List<String> search(String text) {
        List<String> foundPatterns = new ArrayList<>();
        AhoCorasickNode currNode = root;

        for (char c : text.toCharArray()) {
            while (currNode != root && !currNode.children.containsKey(c)) {
                currNode = currNode.failureLink;
            }

            if (currNode.children.containsKey(c)) {
                currNode = currNode.children.get(c);
            }

            foundPatterns.addAll(currNode.output);
        }

        return foundPatterns;
    }

    public static void main(String[] args) {
        AhoCorasick ac = new AhoCorasick();
        ac.addPattern("he");
        ac.addPattern("she");
        ac.addPattern("his");
        ac.addPattern("hers");

        ac.buildFailureLinks();

        String text = "ushers";
        List<String> foundPatterns = ac.search(text);

        System.out.println("Found patterns in the text:");
        for (String pattern : foundPatterns) {
            System.out.println(pattern);
        }
    }
}
