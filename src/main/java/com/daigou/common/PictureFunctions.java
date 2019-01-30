package com.daigou.common;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PictureFunctions {
	public static String getPath(Long id, String extension) {
		return "pictures/" + (id/1000) + "/" + id + "." + extension;
	}
	public static void savePicture(Long id, String extension, InputStream is) throws IOException {
		Files.copy(is, Paths.get(ConfigFunctions.getProperty("picture.path.root") + "/" + getPath(id, extension)), REPLACE_EXISTING);
	}
	public static byte[] getPictureData(Long id, String extension) {
		try {
			return Files.readAllBytes(Paths.get(ConfigFunctions.getProperty("picture.path.root") + "/" + getPath(id, extension)));
		} catch (IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
	
}
