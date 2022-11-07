package ladder.domain;

import ladder.strategy.LineCreateStrategy;
import ladder.strategy.RandomLineCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> lines;

    public Ladder(int countOfMember, LadderHeight ladderHeight) {
        this.lines = create(countOfMember, ladderHeight, new RandomLineCreateStrategy());
    }

    private static List<LadderLine> create(int countOfMember, LadderHeight ladderHeight, LineCreateStrategy lineCreateStrategy) {
        List<LadderLine> values = new ArrayList<>();
        IntStream.range(0, ladderHeight.height())
                .forEach(count -> values.add(new LadderLine(countOfMember, lineCreateStrategy)));
        return values;
    }

    public List<LadderLine> lines() {
        return lines;
    }
}
