public class Main {

    public static void main(String[] args) throws InterruptedException {
        Gui gui = new Gui();
        Lottery lotto = new Lottery();
        while(!lotto.getJackpot()) {
            lotto.playLottery();
            gui.getTitle().setText(lotto.getWeekNumber());
            gui.getSelected().setText(lotto.getSelectedNumbers());
            gui.getDraw().setText(lotto.getDrawnNumbers());
            gui.getMatches().setText(lotto.getMatches());
            gui.getSpent().setText(lotto.getMoneySpent());
            gui.getWon().setText(lotto.getMoneyWon());
            gui.getTotal().setText(lotto.getMoneyTotal());
            gui.getFrame().repaint();
        }
    }
}
