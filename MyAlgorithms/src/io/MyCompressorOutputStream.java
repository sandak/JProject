package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
	
	OutputStream out;
	byte last;
	byte counter;
	
	MyCompressorOutputStream(OutputStream aout)
	{
		out= aout;
	}
	
	@Override
	public void write(int b) throws IOException {
	out.write((byte)b);
	}
	
	public void write(byte[] b) throws IOException {
	byte last;
	byte counter = -1;
	last = b[0];
		for (byte c : b) {
			if 	(c==last)
				counter++;
			else
			{
				out.write(last);
			    out.write(counter);
			    last = c;
			    counter = 0;
			}
		}
	}}
