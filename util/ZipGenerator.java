package co.edu.unbosque.util;

import java.util.zip.*;
import java.awt.Desktop;
import java.io.*;

public class ZipGenerator {

	public void createZipFile(String zipFileName, String fileName) throws IOException {

		FileOutputStream fos = new FileOutputStream(zipFileName);
		ZipOutputStream zos = new ZipOutputStream(fos);

		ZipEntry ze = new ZipEntry(fileName);
		zos.putNextEntry(ze);

		FileInputStream fis = new FileInputStream(fileName);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = fis.read(buffer)) > 0) {
			zos.write(buffer, 0, len);
		}

		fis.close();
		zos.closeEntry();
		zos.close();

		Desktop.getDesktop().open(new File(zipFileName));
	}
}
