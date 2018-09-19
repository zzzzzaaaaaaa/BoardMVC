package board.service;

import static board.common.DBConnector.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.ws.Closeable;

import board.BoardVO;
import board.common.BoardDAO;


public class BoardListService {	
	
	public ArrayList<BoardVO> getBoardList(int btype){
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getAllBoardList(btype);
		try {
			Connection con = getConn();
		}
		catch(SQLException e) {System.out.println("Exception - board.service.BoardListService - SQL Exception");}
		catch(Exception e) { System.out.println("Exception - board.service.BoardListService - Exception"); }

		for(BoardVO d : result) {
			System.out.print("bid : " + d.getBid() + "	");
			System.out.println("btitle : " + d.getBtitle());
			
		}
		
		return result;
	}

	
}
