package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.util.validation.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final static String WINNING_NUMBER_SEPARATOR = ",";

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;
    private final LottoValidator lottoValidator;

    public LottoController(OutputView outputView, InputView inputView, LottoService lottoService,
                           LottoValidator basicLottoValidator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoService = lottoService;
        this.lottoValidator = basicLottoValidator;
    }

    public void run() {
        int count = getPurchasedCount();
        outputView.printPurchase(count);

        List<Lotto> lottoList = lottoService.generateLotto(count);
        List<LottoDto> lottoDtos = convertToDto(lottoList);
        outputView.printLottoNumList(lottoDtos);

        List<Integer> winningNum = pickWinningNum();
        int bonusNum = pickBonusNum(winningNum);

        outputView.printWinningStatMsg();
        LottoResultDto resultDto = lottoService.getResult(lottoDtos, winningNum, bonusNum);
        outputView.printWinningDetail(resultDto);
        outputView.printRevenueResult(resultDto);
    }

    private int getPurchasedCount() {
        return retryUntilValidInput(() -> {
            outputView.printStartMsg();
            int amount = parseInt(inputView.readInput());
            return lottoService.calculateLottoCount(amount);
        });
    }

    private int parseInt(String input) {
        lottoValidator.validateFormat(input);
        return Integer.parseInt(input);
    }

    private int validateInput(String input) {
        int parsed = parseInt(input);
        lottoValidator.validateLottoNum(parsed);
        return parsed;
    }

    private List<LottoDto> convertToDto(List<Lotto> lottoList) {
        return lottoList.stream().map(lotto -> new LottoDto(lotto.getNumbers())).toList();
    }

    private List<Integer> pickWinningNum() {
        return retryUntilValidInput(() -> {
            outputView.printWinningNumMsg();
            String input = inputView.readInput();
            List<Integer> winningNum = Arrays.stream(input.split(WINNING_NUMBER_SEPARATOR))
                    .map(String::trim)
                    .map(this::validateInput)
                    .toList();
            lottoValidator.validateWinningNum(winningNum);
            lottoValidator.validateNoDuplicate(winningNum);
            return winningNum;
        });
    }

    private int pickBonusNum(List<Integer> winningNum) {
        return retryUntilValidInput(() -> {
            outputView.printBonusNumMsg();
            String input = inputView.readInput();
            int bonus = validateInput(input);
            lottoValidator.validateBonusNum(winningNum, bonus);
            return bonus;
        });
    }

    private <T> T retryUntilValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
