package kr.bit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileGetController implements Controller {

	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");
		System.out.println("filename:"+filename);
		
		//업로드 디렉터리
		String UPLOAD_DIR = "file_repo";
		
		//업로드 디렉터리 실제경로 
		//File.seperator :운영체제의 맞는 경로 구분자를 설정
		String UploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		
		//파일 객체 생성
		File f = new File(UploadPath+"\\"+filename);
		
		//클라이언트로 부터 넘어오는 파일이름에 한글이 있는 경우 깨지지 않게 하기 위함  
		filename = URLEncoder.encode(filename, "UTF-8");
		
		//크롬브라우저인경우에는 파일 공백이 +으로 들어가므로 +를 공백처리
		filename = filename.replace("+", " ");
		
		//다운로드 준비로 서버에서 클라이언트에게 다운로드준비를 시키는 부분(다운로드 창을 띄운다)
		response.setContentLength((int)f.length());
		response.setContentType("application/x-msdownload;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+filename+";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		//실제 다운로드를 하는 부분
		
		//업로드된 폴더안에서 파일을 읽어오는 객체 생성
		FileInputStream in = new FileInputStream(f);
		
		//출력 스트림 생성
		OutputStream out =response.getOutputStream();
		
		//바이트 버퍼 생성
		byte[] buffer = new byte[1024];
		
		while(true) {
			//객체에서 파일 읽어옴
			int count = in.read(buffer);
			
			//읽을 데이터가 없다면
			if(count == -1) {
				break;
			}
			
			out.write(buffer, 0, count); //다운로드 되는 부분
		}//end while
		
		in.close();
		out.close();
		
		return null;
	}

}
