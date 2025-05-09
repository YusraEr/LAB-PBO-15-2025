public class TimeMachine {
    String model;

    public TimeMachine() {
        this.model = "Model Biasa";
    }

    public TimeMachine(String model) {
        this.model = model;
    }

    public void tampilkanTimeMachine(){
        System.out.println("Mesin Waktu : " + model);
    }
}
