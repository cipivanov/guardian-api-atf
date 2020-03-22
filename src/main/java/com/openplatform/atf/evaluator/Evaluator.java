package com.openplatform.atf.evaluator;

import org.codehaus.commons.compiler.CompilerFactoryFactory;
import org.codehaus.commons.compiler.IExpressionEvaluator;

@Deprecated
public class Evaluator {

    public boolean evaluateContent(String queryExpression, String content) {
        try {
            IExpressionEvaluator ee = CompilerFactoryFactory.getDefaultCompilerFactory().newExpressionEvaluator();
            ee.setExpressionType(boolean.class);
            ee.setParameters(new String[]{"content"}, new Class[]{String.class});
            ee.cook(queryExpression);

            return (boolean) ee.evaluate(new Object[]{content});
        } catch (Exception e) {
            return false;
        }
    }
}