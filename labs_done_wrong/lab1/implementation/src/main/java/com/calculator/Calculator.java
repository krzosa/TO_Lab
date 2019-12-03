package com.calculator;

import com.calculator.node.*;

import java.util.function.Predicate;

public class Calculator implements ICalculator {
    private Node mainNode;
    private NodeVisitor visitor;
    private Predicate<String> isWhitespace = (str) -> str.equals(" ");
    private Predicate<String> isOperand = (str) -> ("+-**/").contains(str);
    private Predicate<String> isDigit = (str) -> str.matches("-?\\d+(\\.\\d+)?");

    public Calculator() {
        mainNode = null;
        visitor = new NodeVisitor();
    }

    public void readInput(String input) {
        Node currentNode = null;
        Node before = null;

        for (int i = 0; i < input.length(); i++) {
            if (isWhitespace.test(String.valueOf(input.charAt(i)))) {
                continue;
            } else if (isOperand.test(String.valueOf(input.charAt(i)))) {
                Node temp;

                switch (input.charAt(i)) {
                    case '+':
                        temp = new OperatorPlusNode();
                        break;
                    case '-':
                        temp = new OperatorMinusNode();
                        break;
                    case '*':
                        temp = new OperatorMultiplicationNode();
                        break;
                    case '/':
                        temp = new OperatorDivisionNode();
                        break;
                    default:
                        return; // never happens
                }

                temp.left = before;

                if (currentNode == null) {
                    currentNode = temp;
                    mainNode = temp;
                } else {
                    currentNode.right = temp;
                }

                currentNode = temp;
            } else if (isDigit.test(String.valueOf(input.charAt(i)))) {
                StringBuilder number = new StringBuilder();

                while (i != input.length() && isDigit.test(String.valueOf(input.charAt(i)))) {
                    number.append(input.charAt(i));
                    i++;
                }

                i--;

                before = new ValueNode(number.toString());

                if (i == input.length() - 1) {
                    currentNode.right = before;
                }
            }
        }

        /*Node nodeDoubleBefore = null;
        Node nodeBefore = mainNode;
        currentNode = mainNode;

        while (true) {
            if (currentNode instanceof ValueNode) {
                break;
            }

            if ((nodeBefore instanceof OperatorMultiplicationNode || nodeBefore instanceof OperatorDivisionNode) && (currentNode instanceof OperatorPlusNode || currentNode instanceof OperatorMinusNode)) {
                if (nodeDoubleBefore == null) {
                    Node temp = currentNode.right; // copy this properly to work

                    mainNode = currentNode;
                    mainNode.left = currentNode.right;
                    mainNode.right = nodeBefore;
                    nodeBefore.right = nodeBefore.left;
                    nodeBefore.left = temp;
                } else {
                    nodeDoubleBefore.right = currentNode;
                    nodeBefore.right = nodeBefore.left;
                    nodeBefore.left = currentNode.left;
                    currentNode.left = currentNode.right;
                    currentNode.right = nodeBefore.right;
                }
            }

            if (nodeBefore != mainNode) {
                nodeDoubleBefore = nodeBefore;
            }

            nodeBefore = currentNode;
            currentNode = currentNode.right;
        }*/
    }

    public double calc() {
        double ret = visitor.visit(mainNode);

        try {
            return ret;
        } finally {
            mainNode = null;
        }
    }
}
