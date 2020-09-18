package com.spring.hotelspace.common.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service("fileService")
public class FileServiceImpl implements FileService {

		@Autowired
		private ServletContext context;

		// 파일 서버에 업로드
		public FileVO uploadFile(String memberId, MultipartFile file) throws Exception {
			String originalName = file.getOriginalFilename();
			byte[] fileData = file.getBytes();
			String extension = originalName.substring(originalName.lastIndexOf(".")+1);
			// (JPG, PNG, GIF)
			if(MediaTypeUtils.getMediaType(extension) == null){
				return null;
			}
			String savePath = "/resources/images/" + memberId +"/";
			String realPath = context.getRealPath(savePath); 
			
			UUID uid = UUID.randomUUID();
			String saveName = uid.toString().replace("-", "") + originalName;
			makeDir(realPath);
			File target = new File(realPath, saveName);
			FileCopyUtils.copy(fileData, target);
			
			FileVO nfile = new FileVO(saveName, originalName, "resources/images/" + memberId +"/", extension);
			return nfile;
			
		}
		
		// 여러 파일 서버에 업로드
		public List<FileVO> uploadFiles(String memberId, MultipartHttpServletRequest files) throws IOException, Exception{
			
			List<MultipartFile> fileList = files.getFiles("files");
			List<FileVO> fileVOList = new ArrayList<FileVO>();
			
			for (MultipartFile file : fileList) {
				FileVO test = this.uploadFile(memberId, file);
				if (test != null) {
					fileVOList.add(test);					
				}
			}
			return fileVOList;
		}
		
		
		// 여러파일 서버에 업로드 - iterator 사용
		public List<FileVO> uploadFilesToIterator(String memberId, MultipartHttpServletRequest files) throws IOException, Exception {
			Iterator<String> filesIterator = files.getFileNames(); 
			List<FileVO> fileVOList = new ArrayList<FileVO>();
		    MultipartFile mfile = null; 
		    String fieldName = "";
		    while (filesIterator.hasNext()) { 
		        fieldName = (String) filesIterator.next(); //파일이름, 위에서 file1과 file2로 보냈으니 file1, file2로 나온다.
		        mfile = files.getFile(fieldName);  //저장된 파일 객체
		        FileVO file = this.uploadFile(memberId, mfile);
		        if (file != null) {
		        	fileVOList.add(file);					
				}
		    }
		    return fileVOList;
		}
		
		// 파일 저장 위치 리턴
		public String getFilePath(FileVO file) {
			return context.getRealPath("/") + file.getSavePath() + file.getFileName();
		}
		
 		// 파일 업로드 시 디렉토리 생성
		private void makeDir(String realPath){
			File imagePath = new File(context.getRealPath("/resources/images/"));
			if(new File(realPath).exists()){
				return;
			}
			File dirPath = new File(realPath);
			if (!imagePath.exists()) {
				imagePath.mkdir();
			}
			if(!dirPath.exists()){
				dirPath.mkdir();
			}
		}
		
		// 업로드된 파일 삭제
	     public void removeFile(String memberId, String fileName) {
		      
	    	  String folderPath = "/resources/images/"+ memberId +"/";
	    	  File folder = new File(context.getRealPath(folderPath));
	    	  
	    	  if(folder.isDirectory()) {
	    		  File file = new File(folder, fileName);
	    		  if (file.exists()) {
	    			  file.delete();
	    		  } else {
	    			  return;
	    		  }
	    	  } else {
	    		  return;
	    	  }
		            
	    }

	
}
