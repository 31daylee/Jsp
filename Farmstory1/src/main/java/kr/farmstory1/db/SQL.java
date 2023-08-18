package kr.farmstory1.db;

public class SQL {

	///////////////////////////////////////////////////////
	//////////////////////User & Terms/////////////////////
	
	//SELECT 
	public static final String SELECT_TERMS = "SELECT * FROM `Terms`";
	
	public static final String SELECT_USER = "SELECT * FROM `User` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	
	//INSERT 
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
	
	//SELECT 
	public final static String SELECT_ARTICLE ="SELECT * FROM `Article` WHERE `no`=?";
	
	public final static String SELECT_ARTICLES = "SELECT "
												+ "a.*, "
												+ "b.`nick` "
												+ "FROM `Article` AS a "
												+ "JOIN `User` AS b ON a.writer = b.uid "
												+ "WHERE `parent`=0 AND `cate`=? "
												+ "ORDER BY `no` DESC "
												+ "LIMIT ?, 10";

	public final static String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `Article` WHERE `parent`=0 AND `cate`=?";
	
	//댓글조회 하기 !!! 
	public final static String SELECT_COMMENTS = "SELECT "
												+ "a.*, "
												+ "b.`nick` "
												+ "FROM `Article` AS a "
												+ "JOIN `User` AS b ON a.writer = b.uid "
												+ "WHERE `parent`=?";
	
	//INSERT 
	public static final String INSERT_ARTICLE = "INSERT INTO `Article` SET "
												+"`cate`=?, "
												+"`title`=?, "
												+"`writer`=?, "
												+"`content`=?, "
												+"`regip`=?, "
												+"`rDate`=NOW()";

	public static final String INSERT_COMMENT = "INSERT INTO `Article` SET "
												+"`parent` =?, "
												+"`content` =?, "
												+"`writer` =?, "
												+"`regip` =?, "
												+"`rDate` =NOW()";
												
	// UPDATE
	public static final String UPDATE_ARTICLE = "UPDATE `Article` SET `title`=?,`content`=? WHERE `no`=?";
	
	
	// DELETE
	public static final String DELETE_ARTICLE = "DELETE FROM `Article` WHERE `no`=? OR `parent`=?";

}
