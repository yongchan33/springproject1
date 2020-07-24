<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />      
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--아이콘 CDN-->
<!-- <link
  rel="stylesheet"
  href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
/> -->
<!-- font-awesome -->
<link
  rel="stylesheet"
  href="${contextPath }/webjars/font-awesome/5.13.1/css/all.css"
/>

<!--폰트-->
<link
  href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Noto+Sans+KR:wght@100;400;900&display=swap"
  rel="stylesheet"
/>

<!-- rest css -->
<link rel="stylesheet" href="${contextPath }/css/reset.css">


<!-- jquery -->
<script defer src="${contextPath }/webjars/jquery/3.5.1/jquery.js">

</script>

<!-- bootstrap -->
<script defer
	src="${contextPath }/webjars/bootstrap/4.5.0/js/bootstrap.js"></script>

<!-- popper -->
<script defer
	src="${contextPath }/webjars/popper.js/2.0.2/umd/popper.js"
></script>




<!-- de -->

<script defer src="${contextPath }/webjars/d3js/5.16.0/d3.js">

</script>