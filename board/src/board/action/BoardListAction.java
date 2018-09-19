package board.action;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import board.*;
import board.common.*;
import board.service.BoardListService;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		BoardListService service = new BoardListService();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		ArrayList<BoardVO> data = service.getBoardList(btype);
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		
		
		
//		Connection conn = DBConnector.getConn();
//		if(conn == null&&!data.isEmpty())
//		{
//			System.out.println("Aa");
//		}
//		else {
//			System.out.println("notnull");
//		}
		
		
		return forward;
	}

	
}
