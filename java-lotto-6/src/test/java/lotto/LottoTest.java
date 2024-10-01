package lotto;

import lotto.domain.Lotto;
import lotto.util.validation.BasicLottoValidator;
import lotto.util.validation.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private LottoValidator lottoValidator;

    @BeforeEach
    void setUp() {
        lottoValidator = BasicLottoValidator.getInstance();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7), lottoValidator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5), lottoValidator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByRangeOver() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 46, 5), lottoValidator))
                .isInstanceOf(IllegalArgumentException.class);
    }
}