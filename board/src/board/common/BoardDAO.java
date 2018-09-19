package board.common;


import static board.common.DBConnector.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import board.BoardVO;


public class BoardDAO 
{
	private static BoardDAO dao;
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	public static ArrayList<BoardVO> getAllBoardList(int btype) 
	{
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();			
		try 
		{
			Connection conn = getConn();
			String query = String.format(" select "
					+ "bid,"
					+ "btitle,"
					+ "bcontent,"
					+ "to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "
					+ "from t_board%d order by bid desc", btype);
			PreparedStatement ps = conn.prepareStatement(query);			
			ResultSet rs = ps.executeQuery();		
			while(rs.next())
			{
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				String bcontent = rs.getString("bcontent");
				
				BoardVO b = new BoardVO();
				b.setBid(bid);				
				b.setBtitle(btitle);
				b.setBregdate(bregdate);
				b.setBcontent(bcontent);
				result.add(b);
			}
				
			DBConnector.close(conn, ps, rs);
		}
		catch(SQLException e) {System.out.println("Exception - board.common.BoardDAO - SQL Exception");}		
		catch(NamingException e) {System.out.println("Exception - board.common.BoardDAO - Naming Exception");}
		catch(Exception e) { System.out.println("Exception - board.common.BoardDAO - Exception"); }
		
//		catch(Exception e) { e.printStackTrace(); }
		
		return result;
	}
	
	public static ArrayList<BoardVO> getBoardList(int btype){
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();			
		try 
		{
			Connection conn = getConn();
			
				
			DBConnector.close(conn);
		}
		catch(SQLException e) {System.out.println("Exception - board.common.BoardDAO - SQL Exception");}		
		catch(NamingException e) {System.out.println("Exception - board.common.BoardDAO - Naming Exception");}
		catch(Exception e) { System.out.println("Exception - board.common.BoardDAO - Exception"); }
		return result;
	}
	
}
