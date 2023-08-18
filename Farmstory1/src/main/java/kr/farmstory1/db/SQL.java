package kr.farmstory1.db;

public class SQL {

	// select
	public static final String SELECT_TERMS = "SELECT * FROM `Terms`";
	
	public static final String SELECT_USER = "SELECT * FROM `User` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	
	public final static String SELECT_ARTICLE ="SELECT * FROM `Article` WHERE `no`=?";
	
	public final static String SELECT_ARTICLES = "SELECT "
												+ "a.*, "
												+ "b.`nick` "
												+ "FROM `Article` AS a "
												+ "JOIN `User` AS b ON a.writer = b.uid "
												+ "WHERE `parent`=0 AND `cate`=? "
												+ "ORDER BY `no` DESC "
												+ "LIMIT ?, 10";

	// insert
	public static final String INSERT_USER = "INSERT INTO `User` SET "
											+ "`uid`=?, "
											+ "`pass`=SHA2(?,256), "
											+ "`name`=?,"
											+ "`nick`=?,"
											+ "`email`=?,"
											+ "`hp`=?,"
											+ "`zip`=?,"
											+ "`addr1`=?,"
											+ "`addr2`=?,"
											+ "`regip`=?,"
											+ "`regDate`=NOW()";




	//////////////////////////////////////////////////
	//////////////////////Article/////////////////////
	
	public static final String INSERT_ARTICLE = "INSERT INTO `Article` SET "
												+"`cate`=?, "
												+"`title`=?, "
												+"`writer`=?, "
												+"`content`=?, "
												+"`regip`=?, "
												+"`rDate`=NOW()";



	
	

}
