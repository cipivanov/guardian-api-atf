package com.openplatform.atf.evaluator;

import com.fathzer.soft.javaluator.AbstractEvaluator;
import com.fathzer.soft.javaluator.BracketPair;
import com.fathzer.soft.javaluator.Operator;
import com.fathzer.soft.javaluator.Parameters;

import java.util.Arrays;
import java.util.Iterator;

public class TextualBooleanEvaluator extends AbstractEvaluator<Boolean> {

    private final static Operator OR = new Operator("OR", 2, Operator.Associativity.LEFT, 1);
    private final static Operator AND = new Operator("AND", 2, Operator.Associativity.LEFT, 2);
    private final static Operator NOT = new Operator("NOT", 1, Operator.Associativity.RIGHT, 3);

    private static final Parameters PARAMETERS;
    private EvaluationType evaluationType;

    static {
        PARAMETERS = new Parameters();
        PARAMETERS.add(OR);
        PARAMETERS.add(AND);
        PARAMETERS.add(NOT);
        PARAMETERS.addExpressionBracket(BracketPair.PARENTHESES);
    }

    public TextualBooleanEvaluator(EvaluationType evaluationType) {
        super(PARAMETERS);
        this.evaluationType = evaluationType;
    }

    @Override
    protected Boolean toValue(String literal, Object evaluationContext) {
        return evaluationType.getPredicate().test(String.valueOf(evaluationContext), literal);
    }

    @Override
    public Boolean evaluate(Operator operator,
                            Iterator<Boolean> operands, Object evaluationContext) {
        if (operator == NOT) {
            return !operands.next();
        } else if (operator == OR) {
            Boolean o1 = operands.next();
            Boolean o2 = operands.next();
            return o1 || o2;
        } else if (operator == AND) {
            Boolean o1 = operands.next();
            Boolean o2 = operands.next();
            return o1 && o2;
        } else {
            return super.evaluate(operator, operands, evaluationContext);
        }
    }

    @Override
    protected Iterator<String> tokenize(String expression) {
        return Arrays.asList(expression.split("\\s")).iterator();
    }
}