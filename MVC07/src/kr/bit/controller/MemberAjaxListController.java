package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberAjaxListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberVO>list= dao.memberList();
		
		//ArrayList를 json으로 바꿔주는  Gson API
		Gson g = new Gson();
		String json = g.toJson(list);
		System.out.println(json); //[{   },{   },{   }]
		
		//$.jax() 리턴값을 콜백함수에 json형태로 전달
		response.setContentType("text/json;charset=euc-kr");
		response.getWriter().print(json);
		return null;
	}

}
