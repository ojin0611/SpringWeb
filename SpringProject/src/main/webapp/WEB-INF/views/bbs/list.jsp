<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../common/header.jsp" />
<div class="container">
	<div class="row">
		<h1 class="text-center">회원 게시판</h1>
		
		<table class="table">
			<tr>
				<td class="text-left">[<a href="/bbs/write">글쓰기</a>]</td>
				<td class="text-right">(${bbslist.size()})</td>
			</tr>
		</table>
		<table class="table table-bordered">
  			<thead>
  				<tr class="success">
  					<th class="text-center" style="width:10%">글번호</th>
  					<th class="text-center" style="width:15%">작성자</th>
  					<th class="text-center" style="width:50%">제목</th>
  					<th class="text-center" style="width:15%">작성날짜</th>
  					<th class="text-center" style="width:10%">조회수</th>
  				</tr>
  			</thead>
  			<tbody>
  				<c:if test="${bbslist.size() == 0}">
  					<tr>
  						<td colspan="5" class="text-center danger">No Data</td>
  					</tr>
  				</c:if>
  				<c:if test="${bbslist.size() > 0}">
  					<c:forEach items="${bbslist}" var="bbs">
  						<tr>
  							<td class="text-center">${bbs.bno}</td>
  							<td class="text-center">
  								<c:if test="${empty bbs.email}">
  									${bbs.writer}
  								</c:if>
  								<c:if test="${not empty bbs.email}">
  									<a href="mailto:${bbs.email}">${bbs.writer}</a>
  								</c:if>
  							</td>
  							<td class="text-center">
  								<a href="/bbs/read?bno=${bbs.bno}">${bbs.title}</a>
  							</td>
  							<td class="text-center">${bbs.writeday}</td>
  							<td class="text-center">${bbs.readnum}</td>
  						</tr>
  					</c:forEach>
  				</c:if>
  			</tbody>
		</table>
	</div>
</div>


<c:import url="../common/footer.jsp" />