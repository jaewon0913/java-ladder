package ladder.view;

import ladder.domain.Line;
import ladder.domain.Player;

import java.util.List;

public class ResultView {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String SPACE_HORIZONTAL_LINE = "     ";
    private static final String SPACE_START_HORIZONTAL_LINE = "    ";
    private static final String VERTICAL_LINE = "|";
    private static final String NAME_LENGTH_FIVE_FORMAT_PATTERN = "%5s";
    private static final String RESULT_TEXT = "실행결과";

    public ResultView() {}

    public void printResult(List<Player> players, List<Line> lines) {
        printResultText();
        printPlayerName(players);
        printLadderLine(lines);
    }

    private void printResultText() {
        System.out.println(RESULT_TEXT);
    }

    private void printPlayerName(List<Player> playerList) {
        StringBuilder sb = new StringBuilder();

        playerList.stream()
                .map(Player::getName)
                .forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));

        System.out.println(sb.toString());
    }

    private void printLadderLine(List<Line> lines) {
        lines.forEach(line -> System.out.println(getLineText(line.getPoints())));
    }

    private String getLineText(List<Boolean> pointList) {
        StringBuilder sb = new StringBuilder();

        sb.append(SPACE_START_HORIZONTAL_LINE);
        pointList.forEach(hasHorizontalLine -> addHorizontalLine(sb, hasHorizontalLine));
        sb.append(VERTICAL_LINE);

        return sb.toString();
    }

    private void addHorizontalLine(StringBuilder sb, boolean hasHorizontalLine) {
        sb.append(VERTICAL_LINE);
        if (hasHorizontalLine) {
            sb.append(HORIZONTAL_LINE);
        }
        if (!hasHorizontalLine) {
            sb.append(SPACE_HORIZONTAL_LINE);
        }
    }
}
