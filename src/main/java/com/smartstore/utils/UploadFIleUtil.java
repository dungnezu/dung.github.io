package com.smartstore.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadFIleUtil {
	public static String root = "D:\\thuctap\\smartstore\\smartstore\\src\\main\\webapp\\template\\web\\img\\";
	public static String fileURL;

	public static void writeOrUpdate(byte[] bytes, String path) {

		File file = new File(root);
		String fileURL1 = root + path;
		int a = fileURL1.indexOf("template");
		String b = fileURL1.substring(a);
		b = "/" + b.replace("\\", "/");
		fileURL = b;
		if (!file.exists()) {
			file.mkdir();
		}
		try (FileOutputStream fileOutputStream = new FileOutputStream(new File(root + path))) {
			fileOutputStream.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
