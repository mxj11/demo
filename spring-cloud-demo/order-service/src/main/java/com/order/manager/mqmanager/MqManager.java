package com.order.manager.mqmanager;

public class MqManager {
    private MqManager() {
    }

    private static class MqManagerHolder {
        private static final MqManager INSTANCE = new MqManager();
    }

    public static MqManager instance() {
        return MqManagerHolder.INSTANCE;
    }

    public void subscribe(String topic) {

    }

    public void consume(String topic) {

    }

}
