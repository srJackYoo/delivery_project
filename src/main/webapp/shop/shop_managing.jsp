<%@page import="delivery_project.com.vo.CategoryVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/public/js/shop_ajax_managing.js" defer="defer"></script>
<%
List<CategoryVo> cate_list = (List<CategoryVo>)request.getAttribute("cate_list");
%>
</head>
<body>
	<%@ include file="/header_nav.jsp" %>
	<div class="container-lg">
		<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
		  	<li class="nav-item" role="presentation">
		    	<button class="nav-link active" id="pills-list-tab" data-bs-toggle="pill" data-bs-target="#pills-list" type="button" role="tab" aria-controls="pills-list" aria-selected="true">
		    	가맹점 리스트
		    	</button>
		  	</li>
		  	<li class="nav-item" role="presentation">
		    	<button class="nav-link" id="pills-insert-tab" data-bs-toggle="pill" data-bs-target="#pills-insert" type="button" role="tab" aria-controls="pills-insert" aria-selected="false">
		    	신규 등록
		    	</button>
		  	</li>
		  	<li class="nav-item" role="presentation">
		    	<button class="nav-link" id="pills-modify-tab" data-bs-toggle="pill" data-bs-target="#pills-modify" type="button" role="tab" aria-controls="pills-modify" aria-selected="false">
		    	정보 수정
		    	</button>
		  	</li>
		</ul>
		<div class="tab-content" id="pills-tabContent">
			<!-- List -->
		  	<div class="tab-pane fade show active" id="pills-list" role="tabpanel" aria-labelledby="pills-list-tab">
		  		<table class="table table-dark table-hover">
					<thead>
						<tr>
							<th>No.</th>
							<th>ID</th>
							<th>상호명</th>
							<th>지역</th>
							<th>연락처</th>
							<th>등록 달</th>
							<th>영업 시작</th>
							<th>영업 종료</th>
							<th>분류</th>
						</tr>
					</thead>
					<tbody id="shopList">
						<tr id="shopClone">
							<td class="shop_num"></td>
							<td class="seller_id"></td>
							<td>
								<a class="shop_name" href="javascript:void(0)" onclick="modifyLoad(event)" data-num=""></a>
							</td>
							<td class="location"></td>
							<td class="shop_phone"></td>
							<td class="update_month"></td>
							<td class="open_time"></td>
							<td class="close_time"></td>
							<td class="sell_type"></td>
						</tr>
					</tbody>
				</table>
		  	</div>
		  	<!-- insert -->
		  	<div class="tab-pane fade" id="pills-insert" role="tabpanel" aria-labelledby="pills-insert-tab">
		  		<!-- Modal -->
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
				</div><!-- modal close -->
		  		<!-- insert form -->
		  		<form action="" name="shopForm">
		  			<p class="input-group">
		  				<label for="shopFormSellerId" class="input-group-text">점주 아이디</label>
		  				<input name="seller_id" type="text" class="form-control" id="shopFormSellerId" value="killBill">
		  			</p>
		  			<p class="input-group">
		  				<label for="shopFormShopName" class="input-group-text">상호명</label>
		  				<input name="shop_name" type="text" class="form-control" id="shopFormShopName" value="LA RIB">
		  			</p>
		  			<p class="input-group">
		  				<label for="shopFormLocation" class="input-group-text">지역</label>
		  				<select name="location" class="form-control" id="shopFormLocation">
		  					<option value="강원도">강원도</option>
		  					<option value="경기도">경기도</option>
		  					<option value="경상남도">경상남도</option>
		  					<option value="경상북도">경상북도</option>
		  					<option value="광주광역시">광주광역시</option>
		  					<option value="대구광역시">대구광역시</option>
		  					<option value="대전광역시">대전광역시</option>
		  					<option value="부산광역시">부산광역시</option>
		  					<option value="서울특별시">서울특별시</option>
		  					<option value="울산광역시">울산광역시</option>
		  					<option value="인천광역시">인천광역시</option>
		  					<option value="전라남도">전라남도</option>
		  					<option value="전라북도">전라북도</option>
		  					<option value="제주도">제주도</option>
		  					<option value="충청남도">충청남도</option>
		  					<option value="충청북도">충청북도</option>
		  				</select>
		  			</p>
		  			<p class="input-group">
		  				<label for="shopFormShopPhone" class="input-group-text">전화 번호</label>
		  				<input name="shop_phone" type="text" class="form-control" id="shopFormShopPhone" value="02-123-4567">
		  			</p>
		  			<p class="input-group">
		  				<label for="shopFormUpdateMonth" class="input-group-text">등록한 달</label>
		  				<input name="update_month" type="number" class="form-control" id="shopFormUpdateMonth" max="12" min="1"> 월
		  			</p>
		  			<p class="input-group">
		  				<label for="shopFormOpenTime" class="input-group-text">영업 시작 시간</label>
		  				<input name="open_time" type="text" class="form-control" id="shopFormOpenTime" value="08:30">
		  			</p>
		  			<p class="input-group">
		  				<label for="shopFormCloseTime" class="input-group-text">영업 종료 시간</label>
		  				<input name="close_time" type="text" class="form-control" id="shopFormCloseTime" value="23:00">
		  			</p>
		  			<p class="input-group">
		  				<label for="shopFormSellType" class="input-group-text">판매 분류</label>
		  				<select name="sell_type" class="form-control" id="shopFormSellType">
		  					<%for(CategoryVo c: cate_list){ %>
		  					<option value="<%=Integer.toString(c.getCate_num())%>">(<%=c.getCate_num() %>)<%=c.getSell_type() %></option>
		  					<%} %>
		  				</select>
		  			</p>
		  			<p class="d-grid gap-2 d-md-flex justify-content-md-end">
					    <button class="btn btn-outline-warning" type="reset">초기화</button>
					    <button class="btn btn-outline-primary" type="submit">등록</button>
					</p>
		  		</form><!-- insert form close -->
		  	</div><!-- insert close -->
		  	
		  	<!-- modify -->
		  	<div class="tab-pane fade" id="pills-modify" role="tabpanel" aria-labelledby="pills-modify-tab">
		  	
		  		<!-- modal2 -->
		  		<div class="modal" id="updateModar" tabindex="-1">
				    <div class="modal-dialog">
					    <div class="modal-content">
					        <div class="modal-header">
						        <h5 class="modal-title">아이템 수정</h5>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					        </div>
					        <div class="modal-body">
					        	<p id="updateMsg"></p>
					        </div>
					        <div class="modal-footer">
			   			        <button type="button" id="listReloadBtn2"  class="btn btn-primary">ITEM 리스트 GO!</button>
						        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					        </div>
					    </div>
				    </div>
				</div><!-- modal2 close -->
				
				<!-- modify form -->
				<form action="" name="shopModifyForm">
					<p class="input-group">
		  				<label for="shopModifyFormShopNum" class="input-group-text">번호</label>
		  				<input name="shop_num" type="text" class="form-control" id="shopModifyFormShopNum" readonly>
		  			</p>
		  			<p class="input-group">
		  				<label for="shopModifyFormSellerId" class="input-group-text">점주 아이디</label>
		  				<input name="seller_id" type="text" class="form-control" id="shopModifyFormSellerId" readonly>
		  			</p>
		  			<p class="input-group">
		  				<label for="shopModifyFormShopName" class="input-group-text">상호명</label>
		  				<input name="shop_name" type="text" class="form-control" id="shopModifyFormShopName" >
		  			</p>
		  			<p class="input-group">
		  				<label for="shopModifyFormLocation" class="input-group-text">지역</label>
		  				<select name="location" class="form-control" id="shopModifyFormLocation">
		  					<option value="강원도">강원도</option>
		  					<option value="경기도">경기도</option>
		  					<option value="경상남도">경상남도</option>
		  					<option value="경상북도">경상북도</option>
		  					<option value="광주광역시">광주광역시</option>
		  					<option value="대구광역시">대구광역시</option>
		  					<option value="대전광역시">대전광역시</option>
		  					<option value="부산광역시">부산광역시</option>
		  					<option value="서울특별시">서울특별시</option>
		  					<option value="울산광역시">울산광역시</option>
		  					<option value="인천광역시">인천광역시</option>
		  					<option value="전라남도">전라남도</option>
		  					<option value="전라북도">전라북도</option>
		  					<option value="제주도">제주도</option>
		  					<option value="충청남도">충청남도</option>
		  					<option value="충청북도">충청북도</option>
		  				</select>
		  			</p>
		  			<p class="input-group">
		  				<label for="shopModifyFormShopPhone" class="input-group-text">전화 번호</label>
		  				<input name="shop_phone" type="text" class="form-control" id="shopModifyFormShopPhone" placeholder="02-***-****">
		  			</p>
		  			<p class="input-group">
		  				<label for="shopModifyFormUpdateMonth" class="input-group-text">등록한 달</label>
		  				<input name="update_month" type="number" class="form-control" id="shopModifyFormUpdateMonth" max="12" min="1" readonly> 월
		  			</p>
		  			<p class="input-group">
		  				<label for="shopModifyFormOpenTime" class="input-group-text">영업 시작 시간</label>
		  				<input name="open_time" type="text" class="form-control" id="shopModifyFormOpenTime" >
		  			</p>
		  			<p class="input-group">
		  				<label for="shopModifyFormCloseTime" class="input-group-text">영업 종료 시간</label>
		  				<input name="close_time" type="text" class="form-control" id="shopModifyFormCloseTime" >
		  			</p>
		  			<p class="input-group">
		  				<label for="shopModifyFormSellType" class="input-group-text">판매 분류</label>
		  				<select name="sell_type" class="form-control" id="shopModifyFormSellType">
		  					<%for(CategoryVo c: cate_list){ %>
		  					<option value="<%=Integer.toString(c.getCate_num())%>">(<%=c.getCate_num() %>)<%=c.getSell_type() %></option>
		  					<%} %>
		  				</select>
		  			</p>
		  			<p class="d-grid gap-2 d-md-flex justify-content-md-end">
		  				<a class="btn btn-outline-danger" href="javascript:void(0)">삭제</a>
					    <button class="btn btn-outline-warning" type="reset">초기화</button>
					    <button class="btn btn-outline-primary" type="submit">등록</button>
					</p>
		  		</form>
		  	</div><!-- modify close -->
		</div>
	</div>
</body>
</html>