<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <center>
    <br/><br/><br/><br/><br/>
    <h2> test 페이지 </h2>
    
    <table border=1>
    <tr height=20 >
    	<td width=200>아이디</td>
    	<td width=200>비번</td>
    	<td width=200>나이</td>
    </tr>
	    <c:forEach var="memdto" items="${memList }" >
	    <tr>
	    	<td>${memdto.id }</td>
	    	<td>${memdto.pw }</td>
	    	<td>${memdto.age }</td>
	    </tr>
	    </c:forEach>
    </table>
    </center>
    
    
    
