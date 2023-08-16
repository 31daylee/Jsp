<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FarmStory:: admin</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/style_admin.css">
    <style>

    </style>
</head>
<body>
    <div id="container">
        <header>
          <a href="./index.html" class="logo"><img src="../images_admin/admin_logo.jpg" alt="로고"></a>
          <p>
            <a href="/FarmStory/index.html">HOME |</a>
            <a href="#">로그아웃 |</a>
            <a href="#">고객센터</a>
          </p>
        </header>
       <main>
        <aside>
            <h3>주요기능</h3>
            <ul>
                <li class="on"><a href="./productList.html">상품관리</a></li>
                <li><a href="./orderList.html">주문관리</a></li>
                <li><a href="./userList.html">회원관리</a></li>
            </ul>
        </aside>
        <section id="productList">
            <nav><h3>상품목록</h3></nav>
            <article>
                <table>
                    <tbody>
                        <tr>
                            <th><input type="checkbox" name="all"></th>
                            <th>사진</th>
                            <th>상품번호</th>
                            <th>상품명</th>
                            <th>구분</th>
                            <th>가격</th>
                            <th>재고</th>
                            <th>등록일</th>
                        </tr>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td><img src="../images_admin/sample_item1.jpg" alt="샘풀1" class="thumb"></td>
                            <td>1011</td>
                            <td>사과 500g</td>
                            <td>과일</td>
                            <td>4,000원</td>
                            <td>100</td>
                            <td>2023-01-01</td>
                        </tr>
                    </tbody>
                </table>
                <p>
                    <a href="#" class="productDelete">선택삭제</a>           
                    <a href="./productRegister.html" class="productRegister">상품등록</a>           
                </p>
                <p class="paging">
                    <a href="#"> < </a>
                    <a href="#" class="on">[1]</a>
                    <a href="#">[2]</a>
                    <a href="#">[3]</a>
                    <a href="#">[4]</a>
                    <a href="#">[5]</a>
                    <a href="#">></a>
                </p>
            </article>
        </section>
       </main>
        <footer>
            <p>
                Copyright(C)Farmstory All rights reserved. FARMSTORY ADMINISTRATOR Version 1.0.1
            </p>
        </footer>
    </div>
</body>
</html>