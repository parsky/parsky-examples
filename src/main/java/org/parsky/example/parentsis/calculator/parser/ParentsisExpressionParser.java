package org.parsky.example.parentsis.calculator.parser;

import org.parsky.example.calculator.model.Expression;
import org.parsky.example.calculator.parser.sequence.BinaryOperationSequenceMatcher;
import org.parsky.example.calculator.parser.sequence.NumberSequenceMatcher;
import org.parsky.example.parentsis.calculator.parser.sequence.ParentsisExpressionSequenceMatcher;
import org.parsky.sequence.ReferenceSequenceMatcher;
import org.parsky.sequence.SequenceMatcher;
import org.parsky.sequence.SequenceMatchers;
import org.parsky.sequence.model.SequenceMatcherRequest;
import org.parsky.sequence.model.SequenceMatcherResult;
import org.parsky.sequence.model.tree.ContentNode;

import java.util.Optional;

import static org.parsky.sequence.SequenceMatchers.typed;

public class ParentsisExpressionParser {
    public Optional<Expression> parse (String input) {
        SequenceMatcherRequest request = new SequenceMatcherRequest(input.toCharArray(), 0);
        ReferenceSequenceMatcher<Expression> sequenceMatcher = new ReferenceSequenceMatcher<>();

        BinaryOperationSequenceMatcher parser = new BinaryOperationSequenceMatcher(typed(SequenceMatchers.<SequenceMatcher>firstOf(
                new NumberSequenceMatcher(),
                new ParentsisExpressionSequenceMatcher(sequenceMatcher)
        )));

        sequenceMatcher.assign(parser);

        SequenceMatcherResult result = parser.matches(request);

        return extractResult(result);
    }

    private Optional<Expression> extractResult(SequenceMatcherResult result) {
        if (result.matched()) {
            return Optional.of(((ContentNode<Expression>) result.getMatchResult().getNode()).getContent());
        }

        return Optional.empty();
    }
}
