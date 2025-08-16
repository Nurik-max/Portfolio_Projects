public class BookSystem {
    private CinemaHall cinemaHall;

    public BookSystem(CinemaHall cinemaHall){
        this.cinemaHall = cinemaHall;
    }
    public void bookSeat(int row, int number){
        CinemaTikets seat = cinemaHall.getCinemaTikets(row, number);
        if(seat != null){
            if(!seat.status()){
                seat.book();
                System.out.println("Место: " + row + "-" + number + "occupied");
            }
            else {
                System.out.println("Error" + row + "-" + number + "занято");
            }
        }
        else {
            System.out.println("Error!");
        }
    }
    public void showSeatingPlan(){
        cinemaHall.displaySeatingPlan();
    }
}
