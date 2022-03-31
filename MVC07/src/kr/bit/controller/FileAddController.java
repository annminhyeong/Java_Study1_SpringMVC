package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileAddController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//업로드 디렉터리
		String UPLOAD_DIR = "file_repo";
		
		//업로드 디렉터리 실제경로 
		//File.seperator :운영체제의 맞는 경로 구분자를 설정
		String UploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		System.out.println("UploadPath:"+UploadPath);
		
		//업로드될 File 객체 만들기
		File currentDirPath =new File(UploadPath);
		
		//업로드폴더가 존재하면
		if(!currentDirPath.exists()) {
			//업로드폴더를 만들어라
			currentDirPath.mkdir();
		}
		
		//파일업로드할때 저장될 임시 저장 경로
		//파일 업로드시 필요한 API - commons-fileupload, commons-io
		
		//파일 여러개를 저장될 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//실제파일이 저장될 디렉터리 설정
		factory.setRepository(currentDirPath);
		
		//저장할 용량
		factory.setSizeThreshold(1024*1024);
		
		String FileName = null;
		
		//클라이언트에서 넘어온 데이터 받기	
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			//요청한 파일 정보 읽어오기
			// items --> [파일1 정보], [파일2 정보	], [파일3 정보]
			List<FileItem> items=upload.parseRequest(request); //request에 여러 파일이 업로드된 경우 고려	
			
			for (int i=0; i<items.size(); i++) {
				
				//하나의 파일정보가 담겨있음
				FileItem fileItem= items.get(i);
				
				//파일인지 파라미터인지 구분
				//isFormFielId는 파라미터인지 아닌지 구분
				if(fileItem.isFormField()) {
					//파라미터이면 필드이름과 값을 출력
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
				}else {
					//파일이면
					
					//파일사이즈가 0보다 크면
					if(fileItem.getSize()>0) {
						//선택한 파일 전체 경로를 fileItem.getName()으로 얻어 와서 lastIndexOf로 \\ 일치하는 인덱스 값을 가져옴
						int idx = fileItem.getName().lastIndexOf("\\"); //  (\\ window)
						
						//경로가 없으면
						if(idx ==-1) {
							idx = fileItem.getName().lastIndexOf("/"); //  (/ linux)
						}
						
						//파일 이름 넣기
						FileName= fileItem.getName().substring(idx+1); // ( \\ 다음이 파일이름이므로 idx +1을 함)
						
						//파일겍체 생성
						File uploadFile = new File(currentDirPath+"\\"+FileName);
						
						//파일 중복 체크
						if(uploadFile.exists()) {
							//파일이 중복되면 파일이름 앞에 시분초를 붙여 중복 방지
							FileName = System.currentTimeMillis()+"_"+FileName;
							
							//바꿘이름으로 다시 파일겍체 생성
							uploadFile = new File(currentDirPath+"\\"+FileName);
						}
						
						//임시경로 -> 새로운경로에  파일쓰기
						fileItem.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//$.ajax() 쪽으로 업로드된 최종 파일이름을 전송해준다.
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(FileName);
		
		return null;
	}

}
