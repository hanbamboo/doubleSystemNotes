package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class text2 {
		
//		public  DBTest(){};
//		public  DBTest(String a){};
		//ip+port
		static String URL ="jdbc:mysql://139.224.48.87:3306/mg?serverTimezone=GMT";//���������ݿ�
//		static String URL ="jdbc:mysql://1592ba7b93d216.gz.cdb.myqcloud.com:7107/e_market";//��Ѷ�����ݿ�
		//uid
		static String userName="mg"; //Ĭ��root mysql  û��ȥ����
		//pwd
		static String userPassword="Qhx010394";	//���������Լ�������
		//mysql SQL;
		static String SQL="select * from USERINFO";	
		//mysql connection 
		static Connection conn =null;
		//prestatement
		static PreparedStatement pst = null;
		//resultSet 
		static ResultSet rs = null;
		
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("�������سɹ���");
			} catch (ClassNotFoundException e) {
				System.out.println("û���ҵ�������");
				e.printStackTrace();
			}
		}
		public static void conectDB(String URL,String userName,String userPassword){
			try {
				conn = DriverManager.getConnection(URL, userName, userPassword);
				System.out.println("��������"+URL+"��\n���ݿ�"+conn);
			} catch (SQLException e) {
				System.out.println("��ȡ����ʧ��");
				e.printStackTrace();
			}
		}
		public static void querryByid(String SQL){
			try {
				pst = conn.prepareStatement(SQL);
				System.out.println("ִ�в�ѯ��");
				rs = pst.executeQuery();
				while(rs.next()){
					System.out.println("id"+"uname"+"upwd\n"+
							rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
				}
			} catch (SQLException e) {
				System.out.println("��ѯʧ��");
				e.printStackTrace();
			}
		}
		
		public static void close(Connection conn,PreparedStatement pst, ResultSet rs){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					if(pst!=null){
						try {
							pst.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally{
							if(conn!=null){
								try {
									conn.close();
									System.out.println("���ݿ������ѹرգ���Դ���ͷ�");
								} catch (SQLException e) {
									e.printStackTrace();
								}finally{
									conn=null;
									pst= null;
									rs = null;
								}
							}
						}
					}
				}
			}
		}
		
		public static void main(String[] args) {
			text2 dbUtil = new text2();
			dbUtil.conectDB(URL, userName, userPassword);
			dbUtil.querryByid(SQL);
			dbUtil.close(conn, pst, rs);
		}
	}





