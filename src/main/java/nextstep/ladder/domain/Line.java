package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private static final String STICK = "|";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private final Points points;

    public Line(Members members) {
        this(Points.of(members));
    }

    Line(List<Boolean> points) {
        this(Points.of(points));
    }

    Line(Points points) {
        this.points = points;
    }

    public String getPoint() {
        return this.points.getPoint() +
                STICK +
                LINE_SEPARATOR;
    }
}
