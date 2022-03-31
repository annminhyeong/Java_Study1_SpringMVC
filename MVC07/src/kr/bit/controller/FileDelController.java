package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class FileDelController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");
		int num = Integer.parseInt(request.getParameter("num"));
		
		//파일 한글깨짐 방지
		filename = URLEncoder.encode(filename, "utf-8");
		
		//파일 공백이 +으로 들어가는 경우  +를 공백처리
		filename = filename.replace("+", " ");
		
		//업로드된 파일이 저장되어 있는 폴더
		String UPLOAD_DIR = "file_repo";
		
		//업로드 디렉터리 실제경로 
		//File.seperator :운영체제의 맞는 경로 구분자를 설정
		String UploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		
		//파일 객체 생성
		File f =  new File(UploadPath+"\\"+ filename);
		
		if(f.exists()) {
			f.delete();
			System.out.println("디렉토리에 파일 삭제");
		}
		
		//DB에서도 파일이름 null 처리(update)
		MemberDAO dao = new MemberDAO();
		dao.memberDeleteFile(num);
		
		return "redirect:/memberContent.do?num="+num;
	}

}
