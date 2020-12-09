package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.Rank;

import java.util.EnumMap;

public class ResultView {
    private final String results = "당첨 통계\n---------";

    public EnumMap<Rank, Integer> showWinningResult(EnumMap<Rank, Integer> winningStatics) {
        System.out.println(results);
        for(Rank rank : Rank.values()){
            printExceptNomatch(rank, winningStatics);
        }

        return winningStatics;
    }

    public void printNumberOfLottos(Lotto lotto, int manualCount){
        int autoCount = lotto.getLottoTickets().getTicketCount() - manualCount;
        System.out.println("수동으로"+autoCount+"장, 자동으로 "+manualCount+"개를 구매했습니다.");

    }

    public void printExceptNomatch(Rank rank, EnumMap<Rank, Integer> winningStatics){
        if(rank.getMoney() !=0){
            int count = winningStatics.get(rank) / rank.getMoney();
            System.out.println(rank.getWinningCount()+"개 일치 ("+rank.getMoney()+"원)- "+count+"개");
        }
    }

    public void printBenefits(double price, int money){
        System.out.println("수익금 : "+ price);
        System.out.println("총 수익률은 "+(price / money)+"입니다.");
    }


}
