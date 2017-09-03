package org.parsky.example.calculator.parser.sequence;

import org.parsky.character.CharacterMatchers;
import org.parsky.example.calculator.model.Expression;
import org.parsky.example.calculator.model.NumberExpression;
import org.parsky.sequence.SequenceMatchers;
import org.parsky.sequence.TransformSequenceMatcher;
import org.parsky.sequence.transform.Transformations;

public class NumberSequenceMatcher extends TransformSequenceMatcher<Expression> {
    public NumberSequenceMatcher() {
        super(SequenceMatchers.matchedText(
                SequenceMatchers.oneOrMore(
                        SequenceMatchers.match(
                                CharacterMatchers.range('0', '9')
                        )
                )
        ), Transformations.fromString(input -> new NumberExpression(Integer.parseInt(input.getValue()))));
    }
}
