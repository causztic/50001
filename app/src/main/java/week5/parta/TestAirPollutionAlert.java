package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class TestAirPollutionAlert {
    public static void main(String[] args) {
        AirPollutionAlert singaporeAlert = new AirPollutionAlert();
        Subscriber man = new Subscriber("man", singaporeAlert);
        Subscriber simon = new Subscriber("simon", singaporeAlert);
        singaporeAlert.setAirPollutionIndex(200);
        singaporeAlert.setAirPollutionIndex(50);
        singaporeAlert.setAirPollutionIndex(120);
        singaporeAlert.unregister(man);
        singaporeAlert.setAirPollutionIndex(300);
    }
}
