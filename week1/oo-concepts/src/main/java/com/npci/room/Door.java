package com.npci.room;

import java.util.ArrayList;
import java.util.List;

public class Door {

    List<DoorListener> listeners = new ArrayList<>(); // data-structure to hold listeners

    public void addListener(DoorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(DoorListener listener) {
        listeners.remove(listener);
    }

    public void open() {
        System.out.println("Door Opened");
        for (DoorListener listener : listeners) {
            listener.on(); // notify all listeners
        }
    }

    public void close() {
        System.out.println("Door Closed");
        for (DoorListener listener : listeners) {
            listener.off(); // notify all listeners
        }
    }
}
