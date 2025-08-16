public class CinemaHall {
    private CinemaTikets[][] seats;

    public CinemaHall(int row, int columns){
        seats = new CinemaTikets[row][columns];
        for (int i =0; i < row; i++){
            for(int j = 0; j < columns; j++){
                seats[i][j] = new CinemaTikets(i + 1,j + 1);

            }
        }
    }

    public CinemaTikets getCinemaTikets(int row,int  number){
        if(row > 0 && row <= seats.length && number > 0 && number <= seats[0].length){
            return  seats[row-1][number-1];
        }
        return null;
    }
    public void displaySeatingPlan(){
        for(CinemaTikets[] row: seats){
            for (CinemaTikets seat: row){
                seat.displayInfo();
            }
            System.out.println();
        }
    }
}
