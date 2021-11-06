package lotto.domain;

import java.util.regex.Pattern;

public class LottoMoney {
    public static final String NON_POSITIVE_NUMBER_MESSAGE = "금액에 음수나 문자열은 사용할 수 없습니다.";
    public static final String WRONG_LOTTO_AMOUNT_UNIT = "로또 구매는 1000원 단위로 가능합니다.";
    public static final int LOTTO_AMOUNT_UNIT = 1000;
    public static final int PROFIT_RATIO_SCALE = 100;
    public static final int LOTTO_AMOUNT_UNIT_MODULO = 0;
    private static final Pattern ONLY_POSITIVE_NUMBER = Pattern.compile("[0-9]+");

    private final int amount;

    public LottoMoney(String amount) {
        validatePositiveNumber(amount);
        this.amount = Integer.parseInt(amount);
        validateAmountUnit();
    }

    private void validatePositiveNumber(String amount) {
        if (!ONLY_POSITIVE_NUMBER.matcher(amount).matches()) {
            throw new IllegalArgumentException(NON_POSITIVE_NUMBER_MESSAGE);
        }
    }

    private void validateAmountUnit() {
        if (this.amount < LOTTO_AMOUNT_UNIT || this.amount % LOTTO_AMOUNT_UNIT != LOTTO_AMOUNT_UNIT_MODULO) {
            throw new IllegalArgumentException(WRONG_LOTTO_AMOUNT_UNIT);
        }
    }

    public int countOfPossibleLotto() {
        return amount / LOTTO_AMOUNT_UNIT;
    }

    public double profitRatio(int profitAmount) {
        double profitRatio = (double)profitAmount / amount;
        return Math.floor(profitRatio * PROFIT_RATIO_SCALE) / PROFIT_RATIO_SCALE;
    }
}
