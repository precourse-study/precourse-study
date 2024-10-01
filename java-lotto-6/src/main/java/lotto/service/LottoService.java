package lotto.service;

import static lotto.constants.ErrorType.*;
import static lotto.constants.NumberConst.DEFAULT;
import static lotto.constants.NumberConst.FIVE_BONUS_MATCHES_PRIZE;
import static lotto.constants.NumberConst.FIVE_MATCHES_PRIZE;
import static lotto.constants.NumberConst.FOUR_MATCHES_PRIZE;
import static lotto.constants.NumberConst.PRICE;
import static lotto.constants.NumberConst.SIX_MATCHES_PRIZE;
import static lotto.constants.NumberConst.THREE_MATCHES_PRIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.util.generation.LottoGenerator;
import lotto.util.validation.LottoValidator;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoValidator lottoValidator;

    public LottoService(LottoGenerator lottoGenerator, LottoValidator lottoValidator) {
        this.lottoGenerator = lottoGenerator;
        this.lottoValidator = lottoValidator;
    }

    public int calculateLottoCount(int amount) {
        if (amount % PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE.getMessage());
        }
        return amount / PRICE;
    }

    public List<Lotto> generateLotto(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoGenerator.generate(), lottoValidator))
                .toList();
    }

    public LottoResultDto getResult(List<LottoDto> lottoDtos, List<Integer> winningNum, int bonusNum) {
        List<Integer> result = initializeResultList();
        for (LottoDto lottoDto : lottoDtos) {
            int matchCount = calculateMatchCount(lottoDto.lotto(), winningNum);
            boolean isBonusMatched = lottoDto.lotto().contains(bonusNum);
            updateMatchResult(result, matchCount, isBonusMatched);
        }
        int count = lottoDtos.size();
        double revenue = calculateTotalRevenue(result, count);

        return new LottoResultDto(result, revenue);
    }

    private List<Integer> initializeResultList() {
        return new ArrayList<>(List.of(DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT));
    }

    private int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void updateMatchResult(List<Integer> result, int matchCount, boolean isBonusMatched) {
        if (matchCount < 3) {
            return;
        } else if (matchCount == 6) {
            result.set(4, result.get(4) + 1);
            return;
        } else if (matchCount == 5) {
            int index = 2;
            if (isBonusMatched) {
                index = 3;
            }
            result.set(index, result.get(index) + 1);
            return;
        }

        result.set(matchCount - 3, result.get(matchCount - 3) + 1);
    }

    private double calculateTotalRevenue(List<Integer> result, int count) {
        double totalRevenue = (result.get(0) * THREE_MATCHES_PRIZE) +
                (result.get(1) * FOUR_MATCHES_PRIZE) +
                (result.get(2) * FIVE_MATCHES_PRIZE) +
                (result.get(3) * FIVE_BONUS_MATCHES_PRIZE) +
                (result.get(4) * SIX_MATCHES_PRIZE);

        int totalInvest = count * PRICE;
        double rateOfReturn = (totalRevenue / totalInvest) * 100;
        return Math.round(rateOfReturn * 100.0) / 100.0;
    }

}