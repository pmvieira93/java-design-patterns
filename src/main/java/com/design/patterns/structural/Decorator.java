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
public class Decorator {

    //
    //  Notifier System
    //
    interface Notifier {

        void send(String message);
    }

    class BaseDecorator implements Notifier {

        Notifier wrappee;

        public BaseDecorator(Notifier wrappee) {
            this.wrappee = wrappee;
        }

        @Override
        public void send(String message) {
            System.out.println(this.getClass().getName());
            this.wrappee.send(message);
        }

    }

    class SMSDecorator extends BaseDecorator {

        public SMSDecorator(Notifier wrappee) {
            super(wrappee);
        }

        @Override
        public void send(String message) {
            System.out.println(this.getClass().getName());
            super.send(message);
            this.sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("SendSMS - " + message);
        }

    }

    class FacebookDecorator extends BaseDecorator {

        public FacebookDecorator(Notifier wrappee) {
            super(wrappee);
        }

        @Override
        public void send(String message) {
            System.out.println(this.getClass().getName());
            super.send(message);
            this.sendFacebookNotification(message);
        }

        private void sendFacebookNotification(String message) {
            System.out.println("SendFacebookNotification - " + message);
        }
    }

    class SlackDecorator extends BaseDecorator {

        public SlackDecorator(Notifier wrappee) {
            super(wrappee);
        }

        @Override
        public void send(String message) {
            System.out.println(this.getClass().getName());
            super.send(message);
            this.sendSlackMessage(message);
        }

        private void sendSlackMessage(String message) {
            System.out.println("SendSlackMessage - " + message);
        }
    }

    //
    //  ENCRYPTION & COMPRESSION
    //
    interface DataSource {

        void writeData(Object data);

        Object readData();
    }

    class FileDataSource implements DataSource {

        String filename;

        public FileDataSource(String filename) {
            this.filename = filename;
        }

        @Override
        public void writeData(Object data) {
            System.out.println("Write Data to FILE=" + this.filename);
        }

        @Override
        public Object readData() {
            System.out.println("Read Data from FILE=" + this.filename);
            return null;
        }

    }

    class DataSourceDecorator implements DataSource {

        DataSource wrappee;

        public DataSourceDecorator(DataSource wrappee) {
            this.wrappee = wrappee;
        }

        @Override
        public void writeData(Object data) {
            this.wrappee.writeData(data);
        }

        @Override
        public Object readData() {
            return this.wrappee.readData();
        }

    }

    class EncryptionDecorator extends DataSourceDecorator {

        public EncryptionDecorator(DataSource wrappee) {
            super(wrappee);
        }

        @Override
        public void writeData(Object data) {
            System.out.println("Encrypt Data");
            Object encrypted = encryptData(data);
            super.writeData(encrypted);
        }

        @Override
        public Object readData() {
            System.out.println("Decrypt Data");
            Object encrypted = super.readData();
            return decryptData(encrypted);
        }

        private Object encryptData(Object data) {
            Object newData = data;
            return newData;
        }

        private Object decryptData(Object encrypted) {
            Object newData = encrypted;
            return newData;
        }

    }

    class CompressionDecorator extends DataSourceDecorator {

        public CompressionDecorator(DataSource wrappee) {
            super(wrappee);
        }

        @Override
        public void writeData(Object data) {
            System.out.println("Compress Data");
            Object compressed = compressData(data);
            super.writeData(compressed);
        }

        @Override
        public Object readData() {
            System.out.println("Uncompress Data");
            Object compressed = super.readData();
            return uncompressData(compressed);
        }

        private Object compressData(Object data) {
            Object newData = data;
            return newData;
        }

        private Object uncompressData(Object compressed) {
            Object newData = compressed;
            return newData;
        }
    }

    // Example 1
    class Application {

        void dumbUsageExample() {
            DataSource source = new FileDataSource("somefile.dat");
            Object salaryRecords = new String("Salary Records");
            source.writeData(salaryRecords);

            source = new CompressionDecorator(source);
            source.writeData(salaryRecords);

            source = new EncryptionDecorator(source);
            source.writeData(salaryRecords);
        }
    }

    // Example 2
    class SalaryManager {

        DataSource source;

        public SalaryManager(DataSource source) {
            this.source = source;
        }

        Object load() {
            return source.readData();
        }

        void save(Object data) {
            source.writeData(data);
        }
    }

    class ApplicationConfigurator {

        void configurationExample() {
            DataSource source = new FileDataSource("salary.dat");
            boolean enabledEncryption = Boolean.valueOf(System.getProperty("data.encrypted"));
            boolean enabledCompression = Boolean.valueOf(System.getProperty("data.compressed"));
            if (enabledEncryption) {
                source = new EncryptionDecorator(source);
            }
            if (enabledCompression) {
                source = new CompressionDecorator(source);
            }

            SalaryManager logger = new SalaryManager(source);
            Object salary = logger.load();

        }
    }
}
