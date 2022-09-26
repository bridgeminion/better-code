package fb_high_frequency;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionTreeWithEvaluateFunction {

    abstract class Node {
        public abstract int evaluate();
//        public static Node fromString(String s) {
//            switch (s) {
//                case "+": return new AdditionNode();
//                case "-": return new SubtractionNode();
//                case "*": return new MultiplicationNode();
//                case "/": return new DivisionNode();
//                default: return new NumericNode(s);
//            }
//        }
    }

    class NumericNode extends Node {
        String s;

        public NumericNode(String s) {
            this.s = s;
        }

        public int evaluate() {
            return Integer.parseInt(s);
        }
    }

    abstract class OperationNode extends Node {
        Node left, right;

        public void setNodes (Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    class AdditionNode extends OperationNode {
        @Override
        public int evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    class SubtractionNode extends OperationNode {
        @Override
        public int evaluate() {
            return left.evaluate() - right.evaluate();
        }
    }

    class MultiplicationNode extends OperationNode {
        @Override
        public int evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }

    class DivisionNode extends OperationNode {
        @Override
        public int evaluate() {
            return left.evaluate() / right.evaluate();
        }
    }

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Deque<Node> stack = new LinkedList<>();
            for (String str : postfix) {
                Node node = fromString(str);
                if (node instanceof NumericNode) {
                    stack.push(node);
                } else if (node instanceof OperationNode) {
                    OperationNode op = (OperationNode) node;
                    Node node1 = stack.pop();
                    Node node2 = stack.pop();
                    op.setNodes(node2, node1);
                    stack.push(op);
                } else {
                    throw new IllegalArgumentException("");
                }
            }

            return stack.pop();
        }

        private Node fromString(String s) {
            switch (s) {
                case "+": return new AdditionNode();
                case "-": return new SubtractionNode();
                case "*": return new MultiplicationNode();
                case "/": return new DivisionNode();
                default: return new NumericNode(s);
            }
        }

    }
}
