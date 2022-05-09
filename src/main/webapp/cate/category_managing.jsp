<%@page import="delivery_project.com.vo.CategoryVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 관리 페이지</title>
<script src="<%=request.getContextPath()%>/public/js/category_ajax_managing2.js" defer="defer"></script>
<%
List<CategoryVo> cate_list = (List<CategoryVo>)request.getAttribute("cate_list");
%>
</head>
<body>
<%@include file="/header_nav.jsp" %>
<div class="container-lg">
	<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
	  	<li class="nav-item" role="presentation">
	    	<button class="nav-link active" id="pills-list-tab" data-bs-toggle="pill" data-bs-target="#pills-list" type="button" role="tab" aria-controls="pills-list" aria-selected="true">
	    	카테고리 목록
	    	</button>
	  	</li>
	  	<li class="nav-item" role="presentation">
	    	<button class="nav-link" id="pills-insert-tab" data-bs-toggle="pill" data-bs-target="#pills-insert" type="button" role="tab" aria-controls="pills-insert" aria-selected="false">
	    	카테고리 등록
	    	</button>
	  	</li>
	  	<li class="nav-item" role="presentation">
	    	<button class="nav-link" id="pills-modify-tab" data-bs-toggle="pill" data-bs-target="#pills-modify" type="button" role="tab" aria-controls="pills-modify" aria-selected="false">
	    	정보 수정
	    	</button>
	  	</li>
	</ul>
	<!-- 탭 콘텐츠 내용 -->
	<div class="tab-content" id="pills-tabContent">
	  	<!-- list start -->
	  	<div class="tab-pane fade show active" id="pills-list" role="tabpanel" aria-labelledby="pills-list-tab">
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<th>No.</th>
						<th>판매 상세 분류</th>
						<th>sub</th>
					</tr>
				</thead>
				<tbody id="cateList">
					<tr id="cateClone">
						<td class="cate_num"></td>
						<td>
							<a class="sell_type" href="javascript:void(0)" onclick="modifyLoad(event)" data-num=""></a>
						</td>
						<td class="sub"></td>
					</tr>
				</tbody>
			</table>
		</div> <!-- list end -->
		<!-- insert start -->
	  	<div class="tab-pane fade" id="pills-insert" role="tabpanel" aria-labelledby="pills-insert-tab">
			<!-- insert modal -->
			<div class="modal" id="insertModar" tabindex="-1">
				<div class="modal-dialog">
				    <div class="modal-content">
				        <div class="modal-header">
					        <h5 class="modal-title">가맹점 등록</h5>
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				    	</div>
				        <div class="modal-body">
				        	<p id="insertMsg"></p>
				        </div>
				    	<div class="modal-footer">
		   			        <button type="button" id="listReloadBtn" class="btn btn-primary">리스트로 이동</button>
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
				        </div>
			        </div>
			    </div>
			</div><!-- insert modal end -->
			<!-- insert form -->
			<form action="" name="cateForm">
				<p class="input-group">
	  				<label for="cateFormSellType" class="input-group-text">판매 상세 분류</label>
	  				<input name="seller_type" type="text" class="form-control" id="cateFormSellType" value="짜장면">
				</p>
				<p class="input-group">
	  				<label for="caetFormSub" class="input-group-text">sub</label>
	  				<select name="sub" class="form-control" id="caetFormSub">
	  				<%for (CategoryVo c: cate_list){ %>
	  					<option value="<%=Integer.toString(c.getCate_num())%>">(<%=c.getCate_num() %>)<%=c.getSell_type() %></option>
	  				<%} %>
					</select>
				</p>
			</form><!-- insert form end -->
		</div>
	</div><!-- 탭 컨텐츠 종료 -->
</div>
</body>
</html>