package kr.farmstory1.db;

public class SQL {

	// select
	public static final String SELECT_TERMS = "SELECT * FROM `Terms`";
	
	public static final String SELECT_USER = "SELECT * FROM `User` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	
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
