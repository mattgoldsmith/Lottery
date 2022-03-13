import java.text.DecimalFormat;
import java.util.LinkedList;

public class Lottery {

    LinkedList<Integer> selection = new LinkedList<>();
    LinkedList<Integer> weeklyDraw = new LinkedList<>();
    int ticketPrice;
    int spent;
    int won;
    int total;
    int match2 = 0;
    int match3 = 0;
    int match4 = 0;
    int match5 = 0;
    int match6 = 0;
    int week = 0;
    boolean jackpot;

    String weekNumber;
    String selectedNumbers;
    String drawnNumbers;
    String matches;
    String moneySpent;
    String moneyWon;
    String moneyTotal;


    public Lottery() throws InterruptedException {
        ticketPrice = 2;
        jackpot = false;
    }

    public void playLottery() throws InterruptedException {
        week++;
        this.weekNumber = "----Week " + formatNumber(week) + "----";
        System.out.println(this.weekNumber);
        pickNumbers();
        drawBalls();
        selectedNumbers = "Selected Numbers: " + selection;
        System.out.println(selectedNumbers);
        drawnNumbers = "Weekly Draw: " + weeklyDraw;
        System.out.println(drawnNumbers);
        verify();
        spent += ticketPrice;
        total = won - spent;
        moneySpent = "Spent: " + formatNumber(spent);
        System.out.println(moneySpent);
        moneyWon = "Won: " + formatNumber(won);
        System.out.println(moneyWon);
        moneyTotal = "Total: " + formatNumber(total);
        System.out.println(moneyTotal);
        matches = "Matches [2:" + match2 + ", 3:" + match3 + ", 4:" + match4 + ", 5:" + match5 + ", 6:" + match6 + "]";
        System.out.println(matches);
//      Thread.sleep(5);
    }

    private void drawBalls() {
        weeklyDraw.clear();
        for (int i = 0; i < 7; i++) {
            generateNumber(weeklyDraw);
        }
    }

    private void pickNumbers() {
        selection.clear();
        for (int i = 0; i < 6; i++) {
            generateNumber(selection);
        }
    }

    private void generateNumber(LinkedList<Integer> list) {
        int max = 59;
        int min = 1;
        int ball = (int)(Math.random() * (max - min)) + min;
        while(list.contains(ball)) {
            ball = (int)(Math.random() * (max - min)) + min;
        }
        list.add(ball);
    }

    private void verify() {
        int match = 0;
        boolean bonus = false;
        for (int number : selection) {
            if(weeklyDraw.contains(number)) {
                match++;
                if(weeklyDraw.indexOf(number) == 6) {
                    bonus = true;
                }
            }
        }
        switch (match) {
            case 2:
                won += ticketPrice;
                match2++;
                break;
            case 3:
                won += 30;
                match3++;
                break;
            case 4:
                won += 140;
                match4++;
                break;
            case 5:
                won += 1750;
                match5++;
                break;
            case 6:
                if(bonus) {
                    won += 1000000;
                }
                else {
                    jackpot = true;
                    System.out.println("JACKPOT!!!");
                }
                match6++;
                break;
        }
    }

    private static String formatNumber(double value) {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(value);
    }

    public boolean getJackpot() {
        return jackpot;
    }

    public String getWeekNumber() {
        return weekNumber;
    }

    public String getSelectedNumbers() {
        return selectedNumbers;
    }

    public String getDrawnNumbers() {
        return drawnNumbers;
    }

    public String getMatches() {
        return matches;
    }

    public String getMoneySpent() {
        return moneySpent;
    }

    public String getMoneyWon() {
        return moneyWon;
    }

    public String getMoneyTotal() {
        return moneyTotal;
    }
}
