package com.calculator.node;

public class NodeVisitor implements IVisitor {
    public NodeVisitor() { }

    public double visit(Node node) {
        if (node instanceof OperatorDivisionNode) {
            return visit((OperatorDivisionNode)(node));
        } else if (node instanceof OperatorMinusNode) {
            return visit((OperatorMinusNode)(node));
        } else if (node instanceof OperatorMultiplicationNode) {
            return visit((OperatorMultiplicationNode)(node));
        } else if (node instanceof OperatorPlusNode) {
            return visit((OperatorPlusNode)(node));
        } else {
            return visit((ValueNode)(node));
        }
    }

    public double visit(OperatorDivisionNode node) {
        return visit(node.left) / visit(node.right);
    }

    public double visit(OperatorMinusNode node) {
        return visit(node.left) - visit(node.right);
    }

    public double visit(OperatorPlusNode node) {
        return visit(node.left) + visit(node.right);
    }

    public double visit(OperatorMultiplicationNode node) {
        return visit(node.left) * visit(node.right);
    }

    public double visit(ValueNode node) {
        return Double.parseDouble(node.value);
    }
}
