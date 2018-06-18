<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.chatak.pg.util.Constants"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="common.lable.title"/></title>
<!-- Bootstrap -->
<link rel="icon" href="../images/favicon.png" type="image/png">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block Start -->
			<!--Navigation Block Start -->
			<nav class="col-sm-12 nav-bar" id="main-navigation">
				<%-- <jsp:include page="header.jsp"></jsp:include> --%>
				<%@include file="navigation-panel.jsp"%>
			</nav>
			<!--Navigation Block Start -->
			<!--Article Block Start-->
			<article>
					
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text"><spring:message code="show-all-pending-merchants.label.merchant"/></span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text"><spring:message code="show-all-pending-merchants.label.details"/></span>
					</div>
					<!-- Breadcrumb End -->
					<div class="tab-header-container-first active-background">
						<a href="#"><spring:message code="show-all-pending-merchants.label.pendingmerchants"/></a>
					</div>
					<!-- Content Block Start -->
					<div class="main-content-holder">

						<form:form action="processing-transaction-details-pagination" name="paginationForm" method="post">
							<input type="hidden" id="pageNumberId" name="pageNumber" /> 
							<input type="hidden" id="totalRecordsId" name="totalRecords" />
						    <input type="hidden" name="CSRFToken" value="${tokenval}">
						</form:form>

						<form:form action="processing-transaction-details-report" name="downloadReport" method="post">
							<input type="hidden" id="downloadPageNumberId" name="downLoadPageNumber" />
							<input type="hidden" id="downloadTypeId" name="downloadType" />
						    <input type="hidden" name="CSRFToken" value="${tokenval}">
						</form:form>
						
						<form:form action="pending-merchant-show" name="viewPendingMerchant" method="post">
									<input type="hidden" id="merchantViewId" name="merchantViewId" />
									<input type="hidden" name="CSRFToken" value="${tokenval}">
						</form:form>
								
			
						<!-- Search Table Block Start -->
						<div class="search-results-table">
							<table class="table table-striped table-bordered table-condensed" style="margin-bottom: 0px;">
							<!-- Search Table Header Start -->
							<tr>
								<td colspan="6" class="search-table-header-column " style="text-align: left">
									<spring:message code="show-all-pending-merchants.label.pendingmerchantstab"/>
									<span class="pull-right"><spring:message code="common.label.totalcount"/> : <label id="totalCount">${totalRecords}</label></span>
								</td>
							</tr>
						</table>
						<!-- Search Table Header End -->
						<!-- Search Table Content Start -->
						<table id="serviceResults" class="table table-striped table-bordered table-responsive table-condensed tablesorter">
						<thead>
							<tr>
								<th style="display: none;"><spring:message code="show-all-pending-merchants.label.id"/></th>
								<th style="width: 150px;"><spring:message code="show-all-pending-merchants.label.companyname"/></th>
								<th style="width: 150px;"><spring:message code="show-all-pending-merchants.label.address1"/></th>
								<th style="width: 150px;"><spring:message code="show-all-pending-merchants.label.address2"/></th>
								<th style="width: 150px;"><spring:message code="show-all-pending-merchants.label.status"/></th>
								<th style="width: 150px;"><spring:message code="show-all-pending-merchants.label.action"/></th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${!(fn:length(pendingMerchants) eq 0)}">
										<c:forEach items="${pendingMerchants}" var="pendingMerchnats">
											<tr>
												<td id = "merchantViId" style="display: none;">${pendingMerchnats.id}</td>
												<td class="tbl-text-align-left">${pendingMerchnats.businessName}</td>
												<td class="tbl-text-align-left">${pendingMerchnats.address1}</td>
												<td class="tbl-text-align-left">${pendingMerchnats.address2}</td>
												<td  class="tbl-text-align-left">
												<c:if test="${pendingMerchnats.status eq 1}">
												<span><spring:message code="show-all-pending-merchants.label.pending"/></span>
												</c:if>
												<c:if test="${pendingMerchnats.status eq 4}">
												<span><spring:message code="home.label.decline"/></span>
												</c:if>
												<c:if test="${pendingMerchnats.status eq 0}">
												<span><spring:message code="show-all-pending-merchants.label.active"/></span>
												</c:if>
												</td>
												<c:choose>
												<c:when test="${pendingMerchnats.createdBy eq adminId}">	
												<td>	</td>
												</c:when>
												<c:otherwise>
												<c:if test="${pendingMerchnats.status eq 1}">
												<td style="vertical-align:middle;text-align:center;"><input type="Button" value="<spring:message code="home.label.approve"/>" onclick="merchantView('${pendingMerchnats.id}')"></td>
												</c:if>
												<c:if test="${pendingMerchnats.status ne 1}">
												<td>     </td>
												</c:if>
												</c:otherwise>
												</c:choose>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr><td colspan="6" style="color: red; text-align: center;"><spring:message code="home.label.norecordsfound"/></td></tr>
									</c:otherwise>
							</c:choose>
						</tbody>
					</table>
						</div>
						<div>
							<input type="submit" class="form-control button pull-right" style="margin-top: 20px;" value="<spring:message code="show-all-pending-merchants.label.backbutton"/>" onclick="return goToDashboard();">
						</div>
					</div>
					<!-- Search Table Block End -->
				</div>
			</article>
			<!--Article Block End-->
			<div class="footer-container">
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</div>
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<!-- <script src="../js/transactions.js"></script> -->
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
<script src="../js/utils.js"></script>
	<script src="../js/sortable.js"></script>
	<script src="../js/jquery.cookie.js"></script>
	<script src="../js/backbutton.js"></script>
	 <script src="../js/messages.js"></script>
	<script src="../js/common-lib.js"></script>
	<script type="text/javascript" src="../js/browser-close.js"></script>
		<script>
		function merchantView(id){
			get('merchantViewId').value = id;
			document.forms["viewPendingMerchant"].submit();
			
		}
		
		$(document).ready(function() {
			/* Table Sorter includes Start*/
			$(function() {
				
					  // call the tablesorter plugin
					  $('#serviceResults').sortable({
						
						 divBeforeTable: '#divbeforeid',
						divAfterTable: '#divafterid',
						initialSort: false,
						locale: 'th',
						//negativeSort: [1, 2]
					});
			});
			});
		</script>
</body>
</html>