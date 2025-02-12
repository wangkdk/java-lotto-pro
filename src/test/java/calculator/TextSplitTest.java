package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextSplitTest {
    @DisplayName("기본 구분자를 기준으로 split test")
    @Test
    void split() {
        String[] numbersByComma = TextSplit.split("1,2,3");
        assertThat(numbersByComma).containsExactly("1", "2", "3");

        String[] numbersByColon = TextSplit.split("1:2:3");
        assertThat(numbersByColon).containsExactly("1", "2", "3");

        String[] numbersByMix = TextSplit.split("1,2:3");
        assertThat(numbersByMix).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자를 기준으로 split test")
    @Test
    void splitCustomDelimiter() {
        String[] numbersBySemiColon = TextSplit.split("//;\n1;2;3");
        assertThat(numbersBySemiColon).containsExactly("1", "2", "3");

        String[] numbersByDash = TextSplit.split("//-\n1-2-3");
        assertThat(numbersByDash).containsExactly("1", "2", "3");
    }
}
