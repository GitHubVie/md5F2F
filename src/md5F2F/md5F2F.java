package md5F2F;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5F2F {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub

		File passwd = new File("passwd.txt");
		if (!passwd.exists()) return;
		File passwdMd5 = new File("passwdMd5.txt");
//		if (passwdMd5.exists()) return;
//		else passwdMd5.createNewFile();
		passwdMd5.createNewFile();
		
//		BufferedReader br = new BufferedReader(new FileReader(passwd));
//		BufferedWriter bw = new BufferedWriter(new FileWriter(passwdMd5));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(passwd), "UTF-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(passwdMd5), "UTF-8"));
		String line = "";
		String md5 = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			MessageDigest md = MessageDigest.getInstance("MD5");
			//计算后获得字节数组			
			byte[] buff = md.digest(line.getBytes());
			System.out.println("\t" + bytesToHexString(buff));
			bw.write(bytesToHexString(buff));
			bw.newLine();
		}
		bw.close();
		br.close();
		
	}

	public static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (byte b : bArray) {
			sTemp = Integer.toHexString(0xFF & b);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
			}
		return sb.toString();
	}
	
}
