<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bbs" value="${bbsInfo}" />
<c:set var="session_user_id" value="${userInfo.userid}" scope="session"/>
<c:import url="../common/header.jsp" />
<div class="container">
	<div class="row">
		<h1 style="text-align: center">게시글 읽기</h1>
		<table width="600" style="margin: auto" cellspacing="0"
			cellpadding="2">
			<tr>
				<td height="22">&nbsp;</td>
			</tr>
			<tr>
				<td height="1" bgcolor="#1F4F8F"></td>
			</tr>
			<tr bgcolor="#DFEDFF">
				<td bgcolor="#DFEDFF">
					<div>
						<strong id="title">${bbs.title}</strong>
					</div>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td bgcolor="#F4F4F4">
					<table width="100%" border="0" cellpadding="0" cellspacing="4"
						height="1">
						<tr bgcolor="#F4F4F4">
							<td width="13%" height="7"></td>
							<td width="51%" height="7">글쓴이 : <span id="username">${bbs.writer}</span>
								(<span id="email">${bbs.email}</span>)
							</td>

							<td width="25%" height="7">글번호 : </td>
							<td width="11%" height="7">${bbs.bno}</td>
						</tr>
						<tr bgcolor="#F4F4F4">
							<td width="13%"></td>
							<td width="51%">작성일 : <span id='writeday'>${bbs.writeday}</span></td>
							<td width="25%">조회수 : <span id='readnum'>${bbs.readnum}</span></td>
							<td width="11%"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr align="center">
				<td bgcolor="#1F4F8F" height="1"></td>
			</tr>
			<tr>
				<td style="padding: 20 0 20 0"><br /> <span
					style="color: #333333" id='contents'></span>
					${bbs.content}	
				</td>
			</tr>
			<tr align="center">
				<td class="button" height="1"></td>
			</tr>
			<tr align="center">
				<td bgcolor="#1F4F8F" height="1"></td>
			</tr>
		</table>
		<table width="600" style="margin:auto" border="0" cellpadding="0" cellspacing="5">
        <tr> 
            <td class="text-right">
            	<div>
				  <button type="button" id="btnList" class="btn btn-primary">목록으로</button>&nbsp;
				  <c:if test="${bbs.userid eq session_user_id}">
				  	<button type="button" id="btnUpdate" class="btn btn-success">수정하기</button>&nbsp;
				  	<button type="button" id="btnBbsDelete" class="btn btn-info">삭제하기</button>
				  </c:if>
				  <c:if test="${bbs.userid ne session_user_id}">
				    <button type="button" class="btn btn-success"  disabled="disabled">수정하기</button>&nbsp;
				  	<button type="button" class="btn btn-info" disabled="disabled">삭제하기</button>
				  </c:if>
				</div>
            </td>
        </tr>
    </table>
	</div>
</div>
<script>
	$(function(){
		$.ajax({
			url : "/bbs/readnumUpdate/" + ${bbs.bno},
			type : 'GET'
		});
	});
	$('#btnList').on('click', function(){
		location.href = "/bbs/list";    //목록으로
	});
	$('#btnBbsDelete').on('click', function(){
		if(confirm("정말 삭제하시겠습니까 ? ")){
			location.href = "/bbs/delete?bno=" + ${bbs.bno};
		}else{
			history.go(0);
		}
	});
	$('#btnUpdate').on('click', function(){
		location.href = "/bbs/update?bno=" + ${bbs.bno};
	});
</script>
<c:import url="../common/footer.jsp" />