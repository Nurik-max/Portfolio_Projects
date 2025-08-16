public class CinemaTikets {
    private int row;
    private int number;
    private boolean status;

    public CinemaTikets (int row, int number){
        this.row = row;
        this.number = number;
        this.status = false;
    }
    public boolean status(){


        return status;
    }
    public void book(){
        status = true;

    }
    public void displayInfo(){
        System.out.println("Status seat: " + status + "\nRow: " + row + "\nNumber: " + number);
    }

}
