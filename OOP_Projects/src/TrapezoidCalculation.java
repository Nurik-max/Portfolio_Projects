public class TrapezoidCalculation {

// Конструкции Джава
    private float bases_1;
    private float bases_2;
    private float height;

    public TrapezoidCalculation(float bases_1, float bases_2, float height){
        this.bases_1 = bases_1;
        this.bases_2 = bases_2;
        this.height = height;

        System.out.println(" First bases trap = " + bases_1 + "\n Second bases trap = " + bases_2 + "\n Height trap = " + height);

        float res = (bases_1 + bases_2) * height / 2;
        System.out.println("Square trapezoid = " + res);
    }
    }
//    public void setValues(float bases_1, float bases_2, float height) {
//
//        this.bases_1 = bases_1;
//        this.bases_2 = bases_2;
//        this.height = height;
//
//        System.out.println(" First bases trap = " + bases_1 + "\n Second bases trap = " + bases_2 + "\n Height trap = " + height);
//
//
//    }
//    public float CalculationArea(){
//        float res = (bases_1 + bases_2) * height / 2;
//        return res;
//    }


