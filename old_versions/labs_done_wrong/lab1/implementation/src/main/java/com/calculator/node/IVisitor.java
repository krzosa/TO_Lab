package com.calculator.node;

public interface IVisitor {
    double visit(Node node);

    double visit(OperatorDivisionNode node);
    double visit(OperatorMinusNode node);
    double visit(OperatorPlusNode node);
    double visit(OperatorMultiplicationNode node);

    double visit(ValueNode node);
}
