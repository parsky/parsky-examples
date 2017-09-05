package org.parsky.example.parentsis.calculator.parser.sequence;

import org.parsky.example.calculator.model.Expression;
import org.parsky.sequence.SequenceMatchers;
import org.parsky.sequence.TransformSequenceMatcher;
import org.parsky.sequence.TypedSequenceMatcher;
import org.parsky.sequence.transform.Transformations;

public class ParentsisExpressionSequenceMatcher extends TransformSequenceMatcher<Expression> {
    public ParentsisExpressionSequenceMatcher(TypedSequenceMatcher<Expression> expressionSequenceMatcher) {
        super(SequenceMatchers.sequence(
                SequenceMatchers.skipWhitespaces(SequenceMatchers.string("(")),
                expressionSequenceMatcher,
                SequenceMatchers.skipWhitespaces(SequenceMatchers.string(")"))
        ), Transformations.fromContentList(input -> input.get(1)));
    }
}
