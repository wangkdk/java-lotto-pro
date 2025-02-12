package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @DisplayName("로또 번호는 1~45 사이의 숫자만 가능하다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createLottoNumberRangeException(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호는 양수만 가능하다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "-1"})
    void createLottoNumberValidateException(String number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호가 값을 통해 비교되는지 확인한다")
    @Test
    void compareLottoNumber() {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(1);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(1);
        LottoNumber lottoNumber3 = LottoNumber.valueOf(3);

        assertEquals(lottoNumber1, lottoNumber2);
        assertNotEquals(lottoNumber1, lottoNumber3);
    }
}
