package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.util.generation.LottoGenerator;
import lotto.util.generation.RandomLottoGenerator;
import lotto.util.validation.LottoValidator;
import lotto.util.validation.BasicLottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoValidator lottoValidator() {
        return BasicLottoValidator.getInstance();
    }

    public LottoGenerator lottoGenerator() {
        return RandomLottoGenerator.getInstance();
    }

    public LottoService lottoService() {
        return new LottoService(lottoGenerator(), lottoValidator());
    }

    public LottoController lottoController() {
        return new LottoController(outputView(), inputView(), lottoService(), lottoValidator());
    }
}
