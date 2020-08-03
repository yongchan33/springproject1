<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 공통 모듈 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>게시글 작성</title>

<link rel="stylesheet" href="${contextPath }/css/board/board.css">
<link rel="stylesheet" href="${contextPath }/css/board/writeForm.css">
<script defer src="${contextPath }/js/board/writeForm.js"></script>
</head>
<body>
	<!-- 최상위메뉴 -->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>

	<!-- header -->
	<!--%@ include file="/WEB-INF/views/include/header.jsp" %-->

	<!-- 메뉴 -->
	<%@ include file="/WEB-INF/views/include/menu.jsp"%>

	<!-- 본문 -->
	<main>
		<div class="container">
			<div class="content">
				<form:form id="writeForm" method="post"
					action="${contextPath }/board/write" enctype="multipart/form-data"
					modelAttribute="boardVO">
					<legend>게시글 작성</legend>
					<ul>
						<li>
							<form:label path="boardCategoryVO.cid">분류</form:label>
								<form:select path="boardCategoryVO.cid">
									<form:option value="0">==선택==</form:option>
									<form:option value="1001">SPRING</form:option>
									<form:option value="1002">DATABASE</form:option>
									<form:option value="1003">JAVA</form:option>
								</form:select>
								<span class="client_msg" id="boardCategoryVO.cid.error"></span>
								<form:errors cssClass="svr_msg" id="boardCategoryVO.cid.error"/>
								
						</li>
						<li>
							<form:label path="btitle">제목</form:label>
							<form:input type="text" path="btitle" />
							<form:errors cssClass="svr_msg" path="btitle"/>
							<span class="client_msg" id="btitle.error"></span>
						</li>
						<li>
							<form:label path="bid">작성자</form:label>
							<form:input type="text" path="bid" />
							<form:errors cssClass="svr_msg" path="bid"/>
							<span class="client_msg" id="bid.error"></span>
						</li>
						<li>
							<form:label path="bcontent">내용</form:label>
							<form:textarea path="bcontent" rows="10"></form:textarea>
							<form:errors cssClass="svr_msg" path="bcontent"/>
							<span class="client_msg" id="bcontent.error"></span>
						</li>
						<li>
							<form:label path="">첨부</form:label>
							<form:input type="file" path="files" multiple="multiple" />
							<span class="client_msg" id="files.error"></span>
							<form:errors cssClass="svr_msg" path="files"/>
						</li>

						<li>
							<form:button type="button" id="writeBtn"
											class="btn btn-outline-success">등록
							</form:button>
							<form:button type="button" id="cancelBtn"
											class="btn btn-outline-danger">취소
							</form:button>
							<form:button type="button" id="listBtn"
											class="btn btn-outline-warning">목록
							</form:button>
							
						</li>
					</ul>
				</form:form>
			</div>
		</div>
	</main>


	<!-- 푸터 -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>




