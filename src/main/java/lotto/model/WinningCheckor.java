package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCheckor {
    List<Integer> preNumbers;
    private Map<Integer, Integer> winningStatics;

    public WinningCheckor(List<Integer> preNumbers) {
        this.preNumbers = preNumbers;
        winningStatics = new HashMap<>();
        winningStatics.put(3, 0);
        winningStatics.put(4, 0);
        winningStatics.put(5, 0);
        winningStatics.put(6, 0);
    }

    //당첨금 통계내기
    public Map<Integer, Integer> makeStatics(LottoTickets lottoTickets) {

        for (int i = 0; i < lottoTickets.getTicketCount(); i++) {
            int winningCount = checkWinning(lottoTickets.oneOf(i).getTicketNumbers());
            int count = winningStatics.containsKey(winningCount) ? winningStatics.get(winningCount) : 0;
            winningStatics.put(winningCount, count + 1);
        }
        return winningStatics;
    }

    //당첨내역 확인하여 Map에 저장하기
    public int checkWinning(List<Integer> lottoTicket) {
        int winningCount = 0;
        for (Integer preNumber : preNumbers) {
            winningCount += hasNumber(lottoTicket, preNumber);
        }
        return winningCount;
    }

    //이전 당첨 번호가 현재 티켓에 있는지 확인하기
    public int hasNumber(List<Integer> lottoTicket, int number) {
        if (lottoTicket.contains(number)) {
            return 1;
        }
        return 0;
    }
}
