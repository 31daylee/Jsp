<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jboard::list</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
    <div id="container">
        <header>
            <h3>Board System v1.0</h3>
            <p>
                OOO님 반갑습니다.
                <a href="#" class="logout">[로그아웃]</a>
            </p>
        </header>
        <main>
            <section class="list">
                <h3>글목록</h3>
                <article>
                    <table border="0">
                        <tbody>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>글쓴이</th>
                                <th>날짜</th>
                                <th>조회</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td><a href="./view.html">테스트 제목입니다.&nbsp;[3]</a></td>
                                <td>길동이</td>
                                <td>20-05-12</td>
                                <td>12</td>
                            </tr>
                        </tbody>
                    </table>
                </article>
                <div class="paging">
                    <a href="#" class="prev">이전</a>
                    <a href="#" class="current">1</a>
                    <a href="#" class="num">2</a>
                    <a href="#" class="num">3</a>
                    <a href="#" class="next">다음</a>
                </div>
                <a href="./write.html" class="btnWrite">글쓰기</a>
            </section>
        </main>
        <footer>
            <p>ⓒCopyright 이현정.com</p>
        </footer>
    </div>
    
</body>
</html>