package com.pingqc.exls.forlxm;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by pingqc on 2016/8/16.
 */
public class Main {

	public static void main(String[] args) throws Exception{
		// Thread.sleep(10000L);

		// readFile();
		writeFile();
	}

	private static void readFile() throws Exception {
		FileInputStream fis = new FileInputStream(new File("D:/user_info_2.txt"));
		int len = -1;
		while ((len = fis.read()) != -1) {
		}
	}

	private static void writeFile() throws Exception {
		Thread.sleep(20000L);
		String[] strings = new String[398378];

		for (int i = 0; i < strings.length; i++) {
			strings[i] = System.currentTimeMillis() + "";
		}

		Thread.sleep(100000L);
	}

}
