package board.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.BoardVO;

public class asdfdaasasdf 
{
	static int i = 1;
	
	public static void iCount() 
	{
		try 
		{
			Connection conn = DBConnector.getConn();
			String query = " select max(bid) from t_board ";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();		
			while(rs.next())
			{
				i = rs.getInt("max(bid)")+1;				
			}
			DBConnector.close(conn, ps, rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void rewrite(String num, String title, String content) {
		try 
		{
			Connection conn = DBConnector.getConn();
			
			String query = " UPDATE t_board " + 
					"SET " + 
					"btitle= ? ," + 
					"bcontent= ? ," + 
					"brwrtime= sysdate " +
					"WHERE bid= ? ";	
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);			
			ps.setString(3, num);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();	
			DBConnector.close(conn, ps, rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void delete(String num)
	{
		try 
		{
			Connection conn = DBConnector.getConn();
			String query = " DELETE FROM t_board WHERE bid = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, num);
			ps.executeQuery();		
			ResultSet rs = ps.executeQuery();	
			DBConnector.close(conn, ps, rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<BoardVO> getCategory(int category)
	{
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try 
		{
			Connection conn = DBConnector.getConn();
			String query = " select "
					+ "bid,"
					+ "btitle,"
					+ "bcontent,"
					+ "to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "
					+ "from t_board "
					+ "where bcategory = ? "
					+ "order by bid desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, category);
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
				list.add(b);
			}
				
			DBConnector.close(conn, ps, rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<BoardVO> getAllBoardList()
	{
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try 
		{
			Connection conn = DBConnector.getConn();
			String query = " select "
					+ "bid,"
					+ "btitle,"
					+ "bcontent,"
					+ "to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "
					+ "from t_board order by bid desc";
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
				list.add(b);
			}
				
			DBConnector.close(conn, ps, rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<BoardVO> getAllBoardList1()
	{
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try 
		{
			Connection conn = DBConnector.getConn();
			String query = " select "
					+ "bid,"
					+ "btitle,"
					+ "bcontent,"
					+ "to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "
					+ "from t_board order by bid";
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
				list.add(b);
			}
			DBConnector.close(conn, ps, rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public static void write(String title, String content)
	{		
		try 
		{
			iCount();
			Connection conn = DBConnector.getConn();
			String query ="insert into t_board "
					+ " (bid, btitle, bcontent) "
					+ " Values "
					+ " ( ? , ? , ? )";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, i);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();	
			DBConnector.close(conn, ps, rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static ResultSet getBoardList() 
	{
		ResultSet rs = null;
		try 
		{
			Connection conn = DBConnector.getConn();
			String query = "select"
					+ "bid,"
					+ "btitle,"
					+ "bcontent,"
					+ "bregdate,"
					+ "to_char(bregdate, 'YYYY-MM-DD hh24:mi' as bregdate"
					+ "from t_board order by bid desc";
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
