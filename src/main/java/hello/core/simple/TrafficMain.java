package hello.core.simple;


import hello.core.AppConfig;

public class TrafficMain {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Traffic traffic = appConfig.traffic();

        traffic.go();
    }


}
