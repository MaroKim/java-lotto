package lotto;

import lotto.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    int ticketCount;
    List<Integer> preNumbers;
    @BeforeEach
    void setUp(){
        ticketCount = 14;
        preNumbers = new ArrayList<>();
        preNumbers.add(1);
        preNumbers.add(2);
        preNumbers.add(3);
        preNumbers.add(4);
        preNumbers.add(5);
        preNumbers.add(6);
    }

    @Test
    @DisplayName("티켓 생성 테스트 ")
    public void ticketTest(){
        LottoTickets lottoTickets = LottoTickets.of(10);

        assertThat(lottoTickets.getTicketCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("번호 당첨 테스트 ")
    public void checkWinningTest(){
        Lotto lotto = new Lotto(1);
        LottoTicket testTicket = new LottoTicket(preNumbers);
        int winningCount = lotto.checkWinning(testTicket.getTicketNumbers(),preNumbers);

        assertThat(winningCount).isEqualTo(6);
    }

    @Test
    @DisplayName("번호 contains 테스트 ")
    public void containsTest(){
        Lotto lotto = new Lotto(10);
        assertThat(lotto.hasNumber(preNumbers,1)).isEqualTo(1);
    }

    @Test
    @DisplayName("정상 테스트")
    public void test(){
        Lotto lotto = new Lotto(14);
        Map<Integer, Integer> test = lotto.makeStatics(preNumbers);

        System.out.println(test.toString());

        ResultView resultView = new ResultView(14);
        resultView.showWinningResult(test);
    }
}
