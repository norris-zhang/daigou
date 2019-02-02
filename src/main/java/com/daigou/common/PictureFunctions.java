package com.daigou.common;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PictureFunctions {
	private static String getPath(Long id, String extension) {
		String folder = ConfigFunctions.getProperty("picture.path.root") + "/" + "pictures/" + (id/1000);
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}
		return  folder + "/" + id + "." + extension;
	}
	public static void savePicture(Long id, String extension, InputStream is) throws IOException {
		Files.copy(is, Paths.get(getPath(id, extension)), REPLACE_EXISTING);
	}
	public static byte[] getPictureData(Long id, String extension) {
		try {
			return Files.readAllBytes(Paths.get(getPath(id, extension)));
		} catch (IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
}
