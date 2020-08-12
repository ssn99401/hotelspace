package com.spring.hotelspace.common.file;

public class FileVO {

	private String fileName;
	private String originName;
	private String savePath;
	private String extension;

	public FileVO(String fileName, String originName, String savePath, String extension) {
		this.fileName = fileName;
		this.originName = originName;
		this.savePath = savePath;
		this.extension = extension;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "FileVO [fileName=" + fileName + ", originName=" + originName + ", savePath=" + savePath + ", extension="
				+ extension + "]";
	}

	
}
