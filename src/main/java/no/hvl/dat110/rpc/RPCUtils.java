package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		// TODO - START
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		
		rpcmsg = new byte[payload.length + 1];
		rpcmsg[0] = rpcid;
		System.arraycopy(payload, 0, rpcmsg, 1, payload.length);
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		if (rpcmsg != null && rpcmsg.length > 0) {
	        int payloadLength = rpcmsg.length - 1;
	        payload = new byte[payloadLength];
	        System.arraycopy(rpcmsg, 1, payload, 0, payloadLength);
	    }
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START 
		if (str != null) {
            encoded = str.getBytes(StandardCharsets.UTF_8);
        }
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 
		if(data != null && data.length > 0) {
			decoded = new String(data, StandardCharsets.UTF_8);
		}
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 
		return new byte[0];
		// TODO - END
		
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		if (data == null || data.length == 0) {
	        // Possibly log a warning or throw a specific exception if necessary
	        System.out.println("No data provided or data is empty.");
	        return;
	    }
	    System.out.println("Data received.");
		
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		// TODO - START 
		ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(x);
        encoded = buffer.array();
		// TODO - END
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
		if (data != null && data.length == Integer.BYTES) {
            ByteBuffer buffer = ByteBuffer.wrap(data);
            decoded = buffer.getInt();
        }
		// TODO - END
		
		return decoded;
		
	}
}
