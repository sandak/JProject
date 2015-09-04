package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	InputStream in;
	
	public MyDecompressorInputStream(InputStream ain)
	{
		in = ain;
	}
	
	@Override
	public int read() throws IOException {
		return (int)in.read();
	}
	
	@Override
	public int read(byte[] b) throws IOException {
		byte last;
		byte counter;
		int fsize = in.available();
		int i,k;
		int j = 0;
		for (k=0;k<fsize;k+=2)
		{
			if (b.length<=j)
				break;
		last = (byte)in.read();
		counter = (byte)in.read();
		for(i=0;i<counter;i++)
		{
			if (b.length<=j)
				break;
			b[j++]=last;
		}
			
		}
		return fsize-k;
	}

}
