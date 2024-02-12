package no.hvl.dat110.messaging;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

import java.nio.ByteBuffer;

public class MessageUtils {

    public static final int SEGMENTSIZE = 128;

    public static int MESSAGINGPORT = 8080;
    public static String MESSAGINGHOST = "localhost";

    public static byte[] encapsulate(Message message) {
        byte[] segment;
        byte[] data = message.getData();

        segment = new byte[SEGMENTSIZE];
        int size = data.length;
        segment[0] = (byte) size;
        for(int i = 0; i < size; i++) {
        	segment[i + 1] = data[i];
        }
        return segment;
    }

    public static Message decapsulate(byte[] segment) {
    	int size = segment[0];
    	byte[] data = new byte[size];
    	for(int i = 1; i <= size; i++) {
    		data[i - 1] = segment[i];
    	}
        Message message = new Message(data);
        return message;
    }

}

