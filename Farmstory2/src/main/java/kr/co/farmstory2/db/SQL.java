package kr.co.farmstory2.db;

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
	
	
	// UPDATE
	public static final String UPDATE_USER = "UPDATE `User` SET "
											+ "`pass`=SHA2(?,256), "
											+ "`name`=?,"
											+ "`nick`=?,"
											+ "`email`=?,"
											+ "`hp`=?,"
											+ "`zip`=?,"
											+ "`addr1`=?,"
											+ "`addr2`=?,"
											+ "`regip`=? "
											+ "WHERE `uid`=? ";
											



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
	public static final String UPDATE_COMMENT = "UPDATE `Article` SET `content`=? WHERE `no`=?";
	public static final String UPDATE_ARTICLE_FOR_COMMENT_PLUS = "UPDATE `Article` SET `comment`= `comment` + 1 WHERE `no`=?";
	public static final String UPDATE_ARTICLE_FOR_COMMENT_MINUS = "UPDATE `Article` SET `comment`= `comment` - 1 WHERE `no`=?";
	
	
	// DELETE
	public static final String DELETE_ARTICLE = "DELETE FROM `Article` WHERE `no`=? OR `parent`=?";
	public static final String DELETE_COMMENT = "DELETE FROM `Article` WHERE `no`=?";

	
	
	//////////////////////////////////////////////////
	///////////////////////Index//////////////////////
	
	public final static String SELECT_LATESTS = "SELECT `no`,`title`,`rdate` "
												+ "FROM `Article` "
												+ "WHERE `parent`=0 AND `cate`=? "
												+ "Order BY `no` DESC LIMIT ?";
	
	
	
	//////////////////////////////////////////////////
	//////////////////////Product/////////////////////
	
	public final static String INSERT_PRODUCT = "INSERT INTO `Product` SET "
												+ "`type`=?, "
												+ "`pName`=?, "
												+ "`price`=?, "
												+ "`delivery`=?, "
												+ "`stock`=?, "
												+ "`thumb1`=?, "
												+ "`thumb2`=?, "
												+ "`thumb3`=?, "
												+ "`seller`=?, "
												+ "`etc`=?, "
												+ "`rdate`=NOW() ";
			
	public final static String SELECT_PRODUCT = "SELECT * FROM `Product` WHERE `pNo`=?";
	public final static String SELECT_PRODUCTS_ALL = "SELECT * FROM `Product` WHERE `stock` > 0 LIMIT ? ,10";
	public final static String SELECT_PRODUCTS_TYPE = "SELECT * FROM `Product` WHERE `stock` > 0 AND `type`=? LIMIT ? ,10";
	
	public final static String SELECT_COUNT_PRODUCTS_TOTAL_ALL = "SELECT COUNT(*) FROM `Product` WHERE `stock` > 0";
	public final static String SELECT_COUNT_PRODUCTS_TOTAL_TYPE = "SELECT COUNT(*) FROM `Product` WHERE `stock` > 0 AND `type`=?";
	
	
	//////////////////////////////////////////////////
	//////////////////////Order/////////////////////
	public final static String INSERT_ORDER = "INSERT INTO `Order` SET"
											+ "`orderProduct`=?, "
											+ "`orderCount`=?, "
											+ "`orderDelivery`=?, "
											+ "`orderPrice`=?, "
											+ "`orderTotal`=?, "
											+ "`receiver`=?, "
											+ "`hp`=?, "
											+ "`zip`=?, "
											+ "`addr1`=?, "
											+ "`addr2`=?, "
											+ "`orderEtc`=?, "
											+ "`orderUser`=?, "
											+ "`orderDate`=NOW() ";
	
	
	public static final String SELECT_ORDERS = "SELECT "
											+ "a.*,"
											+ "b.`pName`,"
											+ "b.`thumb1` "
											+ "FROM `Order` AS a "
											+ "JOIN `Product` AS b "
											+ "ON a.orderProduct = b.pNo "
											+ "LIMIT ?, 10";
	public final static String SELECT_COUNT_ORDERS_TOTAL_ALL = "SELECT COUNT(*) FROM `Order`";
	public final static String SELECT_ORDER_DETAIL = "SELECT a.pNo, a.pName, a.price, b.orderCount, a.delivery, b.orderTotal, c.name " 
										            +"FROM Product AS a " 
										          	+"JOIN `Order` AS b ON a.pNo = b.orderProduct " 
										          	+"JOIN `User` AS c ON b.orderUser = c.uid "
													+"WHERE b.orderNo =? ";
	
	
	
	
	
	
	
	
	
	
}
