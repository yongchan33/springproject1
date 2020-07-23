<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 공통 모듈 -->
<%@ include file="/WEB-INF/views/include/common.jsp" %>
<title>내정보</title>
<link rel="stylesheet" href="${contextPath }/css/main.css">
<style>
  /* 메뉴 영역 */
  nav{}
  nav > .container-n{ height:50px; background-color: #9e00c5; }
  nav > .container-n > ul{ display:flex; list-style-type: none; height:50px; width:500px; margin: 0px auto; line-height: 50px; }
  nav > .container-n > ul > li { width:100px; text-align: center; font-size:0.8rem; }
  nav > .container-n > ul > li > a{ color:white; text-decoration: none; font-weight: bold; }
  nav > .container-n > ul > li > a:hover{ text-decoration: underline; }
</style>
</head>
<body>
	<!-- 최상위메뉴 -->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp" %>

  <!-- header -->
  <%--@ include file="/header.jsp" --%>

  <!-- 메뉴 -->
  <%@ include file="/WEB-INF/views/member/menu.jsp" %>
	  
	<main>
		<div class="container">
			<div class="content">
				<section>
					내정보
				</section>
			</div>
		</div>
	</main>

  <!-- 푸터 -->
  <%@ include file="/WEB-INF/views/include/footer.jsp" %>  
</body>
</html>  