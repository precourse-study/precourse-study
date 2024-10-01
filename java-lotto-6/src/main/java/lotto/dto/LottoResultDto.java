package lotto.dto;

import java.util.List;

public record LottoResultDto(
        List<Integer> result,
        double revenue
) {
}
