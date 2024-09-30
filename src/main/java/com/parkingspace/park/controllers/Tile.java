package com.parkingspace.park.controllers;

import java.io.IOException;
import java.nio.channels.Channel;

public class Tile implements Channel {

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void close() throws IOException {

    }
}
