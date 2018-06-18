<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Navigation Block Start -->
			<%-- <jsp:include page="header.jsp"></jsp:include> --%>
			<%@include file="navigation-panel.jsp"%>
			<!--Navigation Block Start -->
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text"><spring:message code="manage.label.manage"/></span> 
						<span class="glyphicon glyphicon-play icon-font-size"></span>
						<span class="breadcrumb-text" id="bc-entityType"><spring:message code="merchant.label.merchantaccount"/></span> 
						<span class="glyphicon glyphicon-play icon-font-size"></span> 
						<span class="breadcrumb-text"><spring:message code="common.label.create"/></span>
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<c:if test="${fn:contains(existingFeatures,subMerchantAccountEdit) || fn:contains(existingFeatures,subMerchantAccountSuspend) || fn:contains(existingFeatures,subMerchantAccountActivate)}">
					<div class="tab-header-container-first">
						<a href="merchant-account-search" id="entitySearch"><spring:message code="common.label.search"/></a>
					</div>
					</c:if>
					<c:if test="${fn:contains(existingFeatures,subMerchantAccountCreate)}">
					<div class="tab-header-container active-background">
						<a href="#"><spring:message code="common.label.create"/></a>
					</div>
					</c:if>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder">
						<div class="row">
							<div class="col-sm-12">
								<!--Success and Failure Message Start-->
								<div class="col-xs-12">
									<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
										<span class="red-error">&nbsp;${error}</span> 
										<span class="green-error">&nbsp;${sucess}</span>
									</div>
								</div>

								<form:form action="getMerchantDetailsForAccountCreate" name="paginationForm" method="post">
									<input type="hidden" id="pageNumberId" name="pageNumber" /> 
									<input type="hidden" id="totalRecordsId" name="totalRecords" />
									<input type="hidden" name="CSRFToken" value="${tokenval}">
								</form:form>
								
								<form:form action="merchant-account-create-page" name="merchantAccountCreate" method="post">
									<input type="hidden" id="merchantCodeToCreate" name="merchantCode" />
									<input type="hidden" id="tempMerchantType" name="merchantType" />
									<input type="hidden" name="CSRFToken" value="${tokenval}">
								</form:form>
								
								<%-- <form action="#" name="viewMercahntaccountForm" method="post">
									<input type="hidden" id="merchantViewId" name="merchantViewId" />
									<input type="hidden" id="merchantType" name="merchantType" />
								</form>

								<form action="#" name="deleteMercahntAccountForm" method="post">
									<input type="hidden" id="getMerchantsId" name="getMerchantsId" />
									<input type="hidden" id="merchantType" name="merchantType" />
								</form>

								<form action="#" name="downloadReport" method="post">
									<input type="hidden" id="downloadPageNumberId" name="downLoadPageNumber" /> 
									<input type="hidden" id="downloadTypeId" name="downloadType" />
								</form> --%>

								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="merchant-details-account-create" commandName="merchant" name="merchant" method="post" >
								<input type="hidden" name="CSRFToken" value="${tokenval}">
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.merchantname"/></label>
													<form:input cssClass="form-control" path="businessName" id="businessName" onblur="this.value=this.value.trim();" />
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.merchantcode"/></label>
													<form:input cssClass="form-control" path="merchantCode" id="merchantCode" onkeypress="return numbersonly(this,event)" onblur="this.value=this.value.trim();"/>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="common.label.recordsperpage"/></label>
													<form:select cssClass="form-control" id="pageSize" path="pageSize">
														<form:option value="10">10</form:option>
														<form:option value="20">20</form:option>
														<form:option value="50">50</form:option>
														<form:option value="100">100</form:option>
														<form:option value="250">250</form:option>
														<form:option value="500">500</form:option>
														<form:option value="1000">1000</form:option>
													</form:select>
												</fieldset>
												<fieldset class="col-sm-3">
													<form:hidden path="merchantType" id="merchantType" />
													<input type="submit" class="form-control button" value='<spring:message code="common.label.search"/>' style="margin-top: 20px;width: 50px;"> 
												</fieldset>
											</div>
										</div>
										<!--Panel Action Button Start -->
										<!-- <div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">
												<input type="submit" class="form-control button pull-right" value="Search" > 
												<input type="button" class="form-control button pull-right" value="Reset" onclick="resetPage()">
											</div>
										</div> -->
										<!--Panel Action Button End -->
									</div>
								</form:form>
								<!-- Page Form End -->
							</div>
						</div>
					</div>
					<!-- Content Block End -->
					<!-- Search Table Block Start -->
					<div class="search-results-table" id="searchResults">
						<table class="table table-striped table-bordered table-condensed" style="margin: 1px;">
							<!-- Search Table Header Start -->
							<tr>
								<td colspan="10" class="search-table-header-column">
									<span class="glyphicon glyphicon-search search-table-icon-text"></span>
									<span><spring:message code="common.label.search"/></span>
									<span class="pull-right"><spring:message code="common.label.totalcount"/> : <label id="totalCount">${merchantDetails.totalRecords}</label></span>
								</td>
							</tr>
						</table>
						<!-- Search Table Header End -->
						<!-- Search Table Content Start -->
						<table id="serviceResults" class="table table-striped table-bordered table-responsive table-condensed tablesorter">
							<thead>
								<tr>
									<th width="400px"><spring:message code="merchant.label.merchantname"/></th>
									<th width="200px"><spring:message code="common.label.status"/></th>
									<th width="200px" class="sorter-false tablesorter-header tablesorter-headerUnSorted"><spring:message code="common.label.action"/></th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty merchantDetails || !(fn:length(merchantDetails.merchantDetailsList) eq 0) }">
										<c:forEach items="${merchantDetails.merchantDetailsList}" var="merchantData">
											<tr data-merchantCode="${merchantData.merchantCode}">
												<td>${merchantData.merchantName}</td>
												<td>${merchantData.status}</td>
												<td>
													<c:choose>
														<c:when test="${merchantData.status == 'Active'}">
															<input type="button" class="button buttonP45 margin0" value='<spring:message code="merchant-details-account-create.label.createaccountbutton"/>' onclick="showMerchantAccountCreateForm(this)" />
														</c:when>
														<c:otherwise>
															<input type="button" class="disable-btn buttonP45 margin0" value='<spring:message code="merchant-details-account-create.label.createaccountbutton"/>' disabled="disabled" style="background: #919191;"/>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr><td colspan="10" style="color: red;"><spring:message code="merchant.label.nomerchantsfound"/></td></tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<c:if test="${ !(fn:length(merchantDetails.merchantDetailsList) eq 0)}">
							<table class="table table-striped table-bordered table-condensed">
								<tr class="table-footer-main">
									<td colspan="10" class="search-table-header-column">
										<div class="col-sm-12 row">
											<ul class="pagination custom-table-footer-pagination">
												<c:if test="${portalListPageNumber gt 1}">
													<li><a href="javascript:getPortalOnPageWithRecords('1','${totalRecords}')"> &laquo;</a></li>
													<li><a href="javascript:getPortalPrevPageWithRecords('${portalListPageNumber }','${totalRecords}')">&lsaquo; </a></li>
												</c:if>

												<c:forEach var="page" begin="${beginPortalPage }" end="${endPortalPage}" step="1" varStatus="pagePoint">
													<c:if test="${portalListPageNumber == pagePoint.index}">
														<li class="${portalListPageNumber == pagePoint.index?'active':''}">
															<a href="javascript:">${pagePoint.index}</a>
														</li>
													</c:if>
													<c:if test="${portalListPageNumber ne pagePoint.index}">
														<li class="">
															<a href="javascript:getPortalOnPageWithRecords('${pagePoint.index }','${totalRecords}')">${pagePoint.index}</a>
														</li>
													</c:if>
												</c:forEach>

												<c:if test="${portalListPageNumber lt portalPages}">
													<li>
														<a href="javascript:getPortalNextPageWithRecords('${portalListPageNumber }','${totalRecords}')">&rsaquo;</a>
													</li>
													<li>
														<a href="javascript:getPortalOnPageWithRecords('${portalPages }','${totalRecords}')">&raquo;</a>
													</li>
												</c:if>
											</ul>
										</div>
									</td>
								</tr>
							</table>
						</c:if>
						<!-- Search Table Content End -->
					</div>
					<!-- Search Table Block End -->
				</div>
			</article>
			<!--Article Block End-->
			<footer class="footer">
				<jsp:include page="footer.jsp"></jsp:include>
			</footer>
		</div>
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
<script src="../js/utils.js"></script>
	<script src="../js/jquery.cookie.js"></script>
	<script src="../js/messages.js"></script>
	<script src="../js/sortable.js"></script>
	<script src="../js/common-lib.js"></script>
	<script type="text/javascript" src="../js/backbutton.js"></script>
	<script src="../js/jquery.popupoverlay.js"></script>
	<script src="../js/merchant.js"></script>
	<script type="text/javascript" src="../js/browser-close.js"></script>
	
	<script>
		$(document).ready(function() {
			
			$("#navListId6").addClass("active-background");
			
			$('#merchantCode').attr('placeholder','Numercis Only');
			
			var href;
			if($('#merchantType').val() == 'Merchant') {
				$('#bc-entityType').text('Merchant Account');
				href = "merchant-account-search";
			} else {
				$('#bc-entityType').text('Sub-Merchant Account');
				href = "sub-merchant-account-search";
			}
			$('#entitySearch').attr('href',href);
			
		});
		
		
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