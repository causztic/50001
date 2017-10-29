package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class TestRoadUsers {
    public static void main(String[] args) {
        Traffic sgTraffic = new Traffic();
        RoadUser u1 = new RoadUser("man", sgTraffic);
        RoadUser u2 = new RoadUser("andrew", sgTraffic);
        sgTraffic.changeCondition("Heavy Traffic on PIE");
        sgTraffic.unregister(u1);
        sgTraffic.changeCondition("Roadworks on Keppel Road");
    }
}
