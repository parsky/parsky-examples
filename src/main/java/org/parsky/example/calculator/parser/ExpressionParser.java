package org.parsky.example.calculator.parser;

import org.parsky.example.calculator.model.Expression;
import org.parsky.example.calculator.parser.sequence.BinaryOperationSequenceMatcher;
import org.parsky.example.calculator.parser.sequence.NumberSequenceMatcher;
import org.parsky.sequence.model.SequenceMatcherRequest;
import org.parsky.sequence.model.SequenceMatcherResult;
import org.parsky.sequence.model.tree.ContentNode;

import java.util.Optional;

public class ExpressionParser {
    public Optional<Expression> parse (String input) {
        SequenceMatcherRequest request = new SequenceMatcherRequest(input.toCharArray(), 0);

        BinaryOperationSequenceMatcher parser = new BinaryOperationSequenceMatcher(new NumberSequenceMatcher());

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
