<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.chatak.pg.util.Constants"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ipsidy Acquirer Admin</title>
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
<script src="../js/utils.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/feeprogram.js"></script>
	<script src="../js/validation.js"></script>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block Start -->
			<!--Navigation Block Start -->
			<%-- <jsp:include page="header.jsp"></jsp:include> --%>
			<%@include file="navigation-panel.jsp"%>
			<!--Navigation Block Start -->
			<!--Article Block Start-->

			<article>
			<form:form action="getPartnerFeeDetails" name="paginationForm"
						method="post">
						<input type="hidden" id="pageNumberId" name="pageNumber" /> <input
							type="hidden" id="totalRecordsId" name="totalRecords" />
							<input type="hidden" name="CSRFToken" value="${tokenval}">
					</form:form>
					
					<form:form action="showChatakPartnerFeeEdit" name="showChatakPartnerFeeEdit">
						<input type="hidden" id="getMerchantId" name="getMerchantId" />
						<input type="hidden" name="CSRFToken" value="${tokenval}">
					</form:form>

					<form:form action="editFeeProgram" name="editFeeProgramForm"
						method="post">
						<input type="hidden" id="getFeeProgramId"
							name="getFeeProgramId" />
							<input type="hidden" name="CSRFToken" value="${tokenval}">
					</form:form>
					<form:form action="chatak-acquirer-fee-show" name="getAcquirerFeesForm">
						<input type="hidden" id="partnerId" name="partnerId" />
						<input type="hidden" name="CSRFToken" value="${tokenval}">
					</form:form>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text">Fee Code</span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text">Search</span>
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<div></div>
					<div class="tab-header-container-first active-background">
						<a href="#">Search</a>
					</div>
					<!-- <div class="tab-header-container">
						<a href="chatak-partner-fee-create-page">Create</a>
					</div> -->
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder padding0">
						<div class="row">
							<!--Success and Failure Message Start-->
							<div class="col-xs-12">
								<div class="discriptionErrorMsg col-xs-12">
									<span class="red-error">&nbsp;${error}</span> 
									<span class="green-error">&nbsp;${sucess}</span>
								</div>
							</div>
							<!--Success and Failure Message End-->
							<div class="">
								<form:form action="chatak-partner-fee-search">
								<input type="hidden" name="CSRFToken" value="${tokenval}">
									<div class="col-sm-1"></div>
									<fieldset class="col-sm-8">
										<label data-toggle="tooltip" data-placement="top" title="">Merchant Code<input class="form-control"
											type="text" name="merchantCode" />
											&nbsp;</input>
											<span>&nbsp;</span></label>
										<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
											<span class="red-error">&nbsp;</span>
										</div>
									</fieldset>
									
									<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7" style="width: 53.33333%">
												<input type="submit" style="width: 90px;"
											class=" form-control button pull-right"
											value="Search">
											<a type="button"
								class="form-control button pull-right"
								href="chatak-partner-fee-show">Reset</a>
											</div>
										</div>
									
									<!-- <fieldset class="col-sm-4">
										<div><input type="submit"
											class="form-action-buttons form-control button"
											value="Create"></div>
									</fieldset>
									<fieldset class="col-sm-4"></fieldset> -->
								</form:form>
							</div>
						</div>
					</div>

					<c:if test="${flag eq true}">
						<div class="main-content-holder padding0" id="showFeeDivId">
							<form:form action="chatak-partner-fee-create"
								commandName="partnerFeeCodeDTO" method="post">
								<input type="hidden" name="CSRFToken" value="${tokenval}">
								<form:hidden path="accountNumber" />
								<input type="hidden" name="merchantCode" id="merchantCode" />
								<form:hidden path="createdBy" />
								<table id="tab_logic"
									class="table table-striped table-bordered table-condensed table-program">
									<!-- Search Table Content Start -->
									<tr id="tableheader0">
										<th class="vertical-middle">Partner Name</th>
										<th class="vertical-middle"><spring:message code="fee-program-edit.label.%value"/></th>
										<th class="vertical-middle"><spring:message code="fee-program-edit.label.flatfee"/></th>
									</tr>
									<tr class="vertical-middle">
										<td><form:input path="partnerName" readonly="true" /></td>
										<td><form:input path="percentageOfTxn" /></td>
										<td><form:input path="flatFee" /></td>
									</tr>
									<!-- Search Table Content End -->
								</table>
								<div class=" form-action-buttons">
									<div class="col-sm-12">
										<input type="submit" class="form-control button pull-right"
											value="Submit">
									</div>

								</div>
							</form:form>
						</div>
					</c:if>
									<!-- Search Table Block End -->
				<div class="search-results-table">
						<table class="table table-striped table-bordered table-condensed" style="margin: 1px;">
							<!-- Search Table Header Start -->
							<tr>
								<td colspan="10" class="search-table-header-column"><span
									class="glyphicon glyphicon-search search-table-icon-text"></span>
									<span>Search</span></td>
							</tr>
							<!-- Search Table Header End -->
							<!-- Search Table Content Start -->
							</table>
							<table id="serviceResults" class="table table-striped table-bordered table-responsive table-condensed tablesorter">
							<thead>
							<tr>
								<th style="width: 200px;">Merchant Name</th>
								<th style="width: 150px;">Merchant Code</th>
								<!-- <th>% Value</th>
								<th>Flat fee</th>
								<th>Edit</th> -->
								<th class="sorter-false tablesorter-header tablesorter-headerUnSorted" style="width: 120px;">Processing Fees</th>
							</tr>
							</thead>
							<c:choose>
								<c:when test="${!(fn:length(partnerFeeList) eq 0) }">
									<c:forEach items="${partnerFeeList}" var="parnerFeeCode">
										<tr>
											<td>${parnerFeeCode.businessName }</td>
											<td>${parnerFeeCode.merchantCode }</td>
										<%-- 	<td>${parnerFeeCode.percentageOfTxn }</td>
											<td>${parnerFeeCode.flatFee }</td>
											<td><a href="javascript:editPartnerFee('${parnerFeeCode.merchantCode }')"
														title="Edit" class="table-actionicon-margin"><span
														class="glyphicon glyphicon-pencil"></span></a></td> --%>
														<td><button onclick="getAcquirerFees('${parnerFeeCode.merchantCode}')"
														title="getAcquirerFees" class="table-actionicon-margin">Processing Fees</button></td>
											
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3" style="color: red;">No Merchants found</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</table>
							<table class="table table-striped table-bordered table-condensed">

							<c:if test="${ !(fn:length(partnerFeeList) eq 0)}">
								<tr class="table-footer-main">
									<td colspan="10" class="search-table-header-column">
										<div class="col-sm-12">
											<div class="col-sm-3">
												<div class="btn-toolbar" role="toolbar">
													<div class="btn-group custom-table-footer-button">
														<%-- <a
															href="javascript:downloadReport('${portalListPageNumber}', '<%=Constants.XLS_FILE_FORMAT%>')">
															<button type="button" class="btn btn-default">
																<img src="../images/excel.png">
															</button>
														</a> <a
															href="javascript:downloadReport('${portalListPageNumber}', '<%=Constants.PDF_FILE_FORMAT%>')">
															<button type="button" class="btn btn-default">
																<img src="../images/pdf.png">
															</button>
														</a> --%>
													</div>
												</div>
											</div>
											<div class="col-sm-9">
												<ul class="pagination custom-table-footer-pagination">
													<c:if test="${portalListPageNumber gt 1}">
														<li><a
															href="javascript:getPortalOnPageWithRecords('1','${totalRecords}')">
																&laquo;</a></li>
														<li><a
															href="javascript:getPortalPrevPageWithRecords('${portalListPageNumber }','${totalRecords}')">
																&lsaquo; </a></li>
													</c:if>

													<c:forEach var="page" begin="${beginPortalPage }"
														end="${endPortalPage}" step="1" varStatus="pagePoint">
														<c:if test="${portalListPageNumber == pagePoint.index}">
															<li
																class="${portalListPageNumber == pagePoint.index?'active':''}">
																<a href="javascript:">${pagePoint.index}</a>
															</li>
														</c:if>
														<c:if test="${portalListPageNumber ne pagePoint.index}">
															<li class=""><a
																href="javascript:getPortalOnPageWithRecords('${pagePoint.index }','${totalRecords}')">${pagePoint.index}</a>
															</li>
														</c:if>
													</c:forEach>

													<c:if test="${portalListPageNumber lt portalPages}">
														<li><a
															href="javascript:getPortalNextPageWithRecords('${portalListPageNumber }','${totalRecords}')">
																&rsaquo;</a></li>
														<li><a
															href="javascript:getPortalOnPageWithRecords('${portalPages }','${totalRecords}')">&raquo;
														</a></li>
													</c:if>
												</ul>
											</div>
										</div>
									</td>
								</tr>
							</c:if>
							<!-- Search Table Content End -->
						</table>
					</div>
				</div>

			</article>
			<footer class="footer">
				<jsp:include page="footer.jsp"></jsp:include>
			</footer>
		</div>
	</div>
</body>
<script src="../js/sortable.js"></script>
	<script type="text/javascript" src="../js/browser-close.js"></script>
<script type="text/javascript">
$(function() {
	//	$("#main-navigation").load("header.jsp");
		highlightMainContent();
	});
	function highlightMainContent() {
		$("#navListId5").addClass("active-background");
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
</html>