/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.structural;

/**
 *
 * @author pedro.vieira
 */
public class Bridge {

    interface Device {

        public boolean isEnabled();

        public void enable();

        public void disable();

        public int getVolume();

        public void setVolume(int volume);

        public int getChannel();

        public void setChannel(int channel);
    }

    class RemoteControl {

        public Device device;

        public RemoteControl() {
        }

        public RemoteControl(Device device) {
            this.device = device;
        }

        public void togglePower() {
            if (this.device.isEnabled()) {
                this.device.disable();
            } else {
                this.device.enable();
            }
        }

        public void volumeDown() {
            this.device.setVolume(this.device.getVolume() - 10);
        }

        public void volumeUp() {
            this.device.setVolume(this.device.getVolume() + 10);
        }

        public void channelDown() {
            this.device.setChannel(this.device.getChannel() - 1);
        }

        public void channelUp() {
            this.device.setChannel(this.device.getChannel() + 1);
        }
    }

    class AdvancedRemoteControl extends RemoteControl {

        public AdvancedRemoteControl() {
        }

        AdvancedRemoteControl(Device device) {
            super(device);
        }

        void mute() {
            this.device.setVolume(0);
        }

    }

    class TV implements Device {

        boolean enable;
        int volume;
        int channel;

        public TV() {
            this.enable = false;
            this.volume = 0;
            this.channel = 0;
        }

        @Override
        public boolean isEnabled() {
            return this.enable;
        }

        @Override
        public void enable() {
            this.enable = true;
        }

        @Override
        public void disable() {
            this.enable = false;
        }

        @Override
        public int getVolume() {
            return this.volume;
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
        }

        @Override
        public int getChannel() {
            return this.channel;
        }

        @Override
        public void setChannel(int channel) {
            this.channel = channel;
        }

    }

    class Radio implements Device {

        boolean enable;
        int volume;
        int channel;

        Radio() {
            this.enable = false;
            this.volume = 0;
            this.channel = 0;
        }

        @Override
        public boolean isEnabled() {
            return this.enable;
        }

        @Override
        public void enable() {
            this.enable = true;
        }

        @Override
        public void disable() {
            this.enable = false;
        }

        @Override
        public int getVolume() {
            return this.volume;
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
        }

        @Override
        public int getChannel() {
            return this.channel;
        }

        @Override
        public void setChannel(int channel) {
            this.channel = channel;
        }
    }

    class Application {

        public void main() {
            TV tv = new TV();
            RemoteControl remote = new RemoteControl(tv);
            remote.togglePower();

            Radio radio = new Radio();
            remote = new AdvancedRemoteControl(radio);

        }
    }

}
