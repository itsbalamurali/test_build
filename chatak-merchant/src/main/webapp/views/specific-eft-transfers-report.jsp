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
			<!--Header Block Start -->
			<jsp:include page="header.jsp"></jsp:include>
			<!--Header Block End -->
			<!--Navigation Block Start -->
			<nav class="col-sm-12 nav-bar" id="main-navigation">
				<%-- <jsp:include page="main-navigation.jsp"></jsp:include> --%>
				<%@include file="navigation-panel.jsp"%>
			</nav>
			<!--Navigation Block Start -->
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text"><spring:message code="reports.label.reports"/></span><span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text"><spring:message code="reportseft.label.efttransfer"/></span>
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<!-- <div class="tab-header-container-first active-background">
						<a href="merchant-search">Specific User</a>
					</div> -->
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="col-sm-12">
						<!--Success and Failure Message Start-->
						<div class="col-xs-12">
							<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
								<span class="red-error" style="font-size: 13px;">&nbsp;${error }</span> <span
									class="green-error">&nbsp;${sucess }</span>
							</div>
						</div>
						<form action="downloadSpecificEFTTransferReport" name="downloadReport" method="post">
							<input type="hidden" id="downloadPageNumberId" name="downLoadPageNumber" /> 
							<input type="hidden" id="downloadTypeId" name="downloadType" /> 
							<input type="hidden" id="totalRecords" name="totalRecords" /> 
							<input type="hidden" id="downloadAllRecords" name="downloadAllRecords" />
							<input type="hidden" name="CSRFToken" value="${tokenval}">
						</form>

						<form action="processSpecificEFTTransfers" name="processSpecificEFTTransfers">
									<input type="hidden" id="fromDate" name="fromDate" />
									<input type="hidden" id="toDate" name="toDate" />
									<input type="hidden" id="currency" name="currency" />
									<input type="hidden" id="merchant_Code" name="merchantCode" />
									<input type="hidden" name="CSRFToken" value="${tokenval}">
								</form>


						<!-- Content Block End -->
						<!-- Search Table Block Start -->
						<div id="showDates">
												<fieldset class="col-sm-12">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="reports.label.selectdaterange"/>:</label>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="reports.label.fromdate"/><span class="required-field">*</span></label>
													<div class="input-group focus-field">
														<input name="" id="transFromDate" onblur="return clientValidation('transFromDate', 'startDate','transFromDateErrorDiv');"
															class="form-control effectiveDate" />
														<span class="input-group-addon"><span
															class="glyphicon glyphicon-calendar"></span></span>
													</div>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="transFromDateErrorDiv">&nbsp;</span>
													</div>
												</fieldset>
												
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="reports.label.todate"/><span class="required-field">*</span></label>
													<div class="input-group focus-field">
														<input name="" class="form-control effectiveDate" id="transToDate"
														onblur="return clientValidation('transToDate', 'endDate','transToDateErrorDiv');" />
														<span class="input-group-addon"><span
															class="glyphicon glyphicon-calendar"></span></span>
													</div>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="transToDateErrorDiv">&nbsp;</span>
													</div>
												</fieldset>
												
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="reports.label.currency"/>:<span class="required-field">*</span></label>
														<select class="form-control" name="" id="currencyType" >
															<option value="USD"><spring:message code="reports.label.USD"/></option>
														</select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
													<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="reports.label.merchantcode"/></label>
													<select name="" id="merchantCode"  onkeypress="return numbersonly(this,event)" class="form-control">
														<option value=""><spring:message code="common.label.search"/></option>
														<c:forEach items="${merchantList}" var="merchants">
															<option value="${merchants.value}">${merchants.label}</option>
														</c:forEach>
														</select>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												
												<div class="col-sm-10 form-action-buttons" style="width: 100%;">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">
												<!-- <input type="button" class="form-control button pull-right"
													value="Search">  -->
													<a type="button" onclick="submitSpecificEFTTransfersDateRange()" class="form-control button pull-right"><spring:message code="reports.label.generate"/></a>
													<a type="button" href="dash-board" class="form-control button pull-right"><spring:message code="common.label.back"/></a>
											</div>
										</div>
											</div>

						<div class="search-results-table table-scroll" style="display: none;padding:10px;" id="transinfo">
							<table class="table table-striped table-bordered table-condensed"
								style="margin: 1px;">
								<thead>
									<tr>
										<!-- <th>Merchant Code</th> -->
										<th><spring:message code="reportseft.label.companyname"/></th>
										<th><spring:message code="reports.label.startdate"/></th>
										<th><spring:message code="reports.label.enddate"/></th>
										<th><spring:message code="reports.label.currency"/></th>
										<th><spring:message code="reportseft.label.totalcredit"/></th>
										<th><spring:message code="reportseft.label.totaldebit"/></th>
									</tr>
								</thead>
								<%-- <tr>
									<td>${merchantCode}</td>
									<td>${startDate}</td>
									<td>${endDate}</td>
									<td>${currency}</td>
									<td>$${totalCredit/100}</td>
									<td>$${totalDebit/100}</td>
								</tr> --%>
								
								<c:choose>
									<c:when
										test="${!(fn:length(searchDetails) eq 0) }">
										<c:forEach items="${searchDetails}" var="searchDetail">
											<tr>
											<td>${searchDetail.companyName}</td>
												<%-- <td>${searchDetail.merchantCode}</td> --%>
												<td>${searchDetail.fromDate}</td>
												<td>${searchDetail.toDate}</td>
												<%-- <fmt:parseDate value="${searchDetail.fromDate}" var="date" pattern="dd/MM/yyyy"/>
												<td><fmt:formatDate value="${date}" pattern="MM/dd/yyyy" /></td>
												<fmt:parseDate value="${searchDetail.toDate}" var="date1" pattern="dd/MM/yyyy"/>
												<td><fmt:formatDate value="${date1}" pattern="MM/dd/yyyy" /></td>  --%>
												<td>${searchDetail.currency}</td>
												<%-- <td>${searchDetail.tranferAmountCredit}</td> --%>
												<td>$0.00</td>
												<td>$${searchDetail.tranferAmountDebit/100}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="12" style="color: red;"><spring:message code="reportseft.label.notransfersfound"/></td>
										</tr>
									</c:otherwise>
								</c:choose>
								
								
							</table>

						</div>

						<div class="search-results-table table-scroll" id="checkb" style="display: none; padding:10px;">

							<table id="serviceResults" class="table table-striped table-bordered table-responsive table-condensed tablesorter">
								<thead>
									<tr>
										<th style="width: 100px;"><spring:message code="reports.label.datetime"/></th>
										<th style="width: 100px;"><spring:message code="reports.label.username"/></th>
										<th style="width: 150px;"><spring:message code="reports.label.companyorfullname"/></th>
										<th style="width: 90px;"><spring:message code="reports.label.accountnumber"/></th>
										<th style="width: 75px;"><spring:message code="reportseft.label.accounttype"/></th>
										<th style="width: 55px;"><spring:message code="reportseft.label.transferID"/></th>
										<th style="width: 125px;"><spring:message code="reportseft.label.transactiondescription"/></th>
										<th style="width: 50px;"><spring:message code="reports.label.currency"/></th>
										<th style="width: 50px;"><spring:message code="reportseft.label.credit"/></th>
										<th style="width: 50px;"><spring:message code="reportseft.label.debit"/></th>
									</tr>
								</thead>
								<c:choose>
									<c:when
										test="${!(fn:length(eftTransferReportList) eq 0) }">
										<c:forEach items="${eftTransferReportList}"
											var="transaction">
											<tr>
												<td>${transaction.dateTime }</td>
												<td>${transaction.userName }</td>
												<td>${transaction.companyName }</td>
												<td>${transaction.accountNumber }</td>
												<td>${transaction.accountType }</td>
												<td style="cursor: pointer;text-decoration: underline;" onclick="doAjaxFetchTxnIdList('${transaction.transactionId}')">${transaction.transactionId}</td>
												<td><div class="feeDescDiv">${transaction.description }</div></td>
												<td>${transaction.currency }</td>
												<c:choose>
												<c:when test="${transaction.paymentMethod eq 'credit' }">
												<td>${transaction.amount }</td>
												<td></td>
												</c:when>
												<c:otherwise>
												<td></td>
												<td>${transaction.amount }</td>
												</c:otherwise>
												</c:choose>
												
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="12" style="color: red;"><spring:message code="reportseft.label.notransfersfound"/></td>
										</tr>
									</c:otherwise>
								</c:choose>
								</table>
							<table class="table table-striped table-bordered table-condensed" style="margin-bottom: 0px;">
								<c:if test="${ !(fn:length(eftTransferReportList) eq 0)}">
									<tr class="table-footer-main">
										<td colspan="14" class="search-table-header-column">
											<div class="col-sm-12">
												<div class="col-sm-3">
													<div class="btn-toolbar" role="toolbar">
														<div class="btn-group custom-table-footer-button">
															<a
																href="javascript:downloadReport('${portalListPageNumber}', '<%=Constants.XLS_FILE_FORMAT%>')">
																<button type="button" class="btn btn-default">
																	<img src="../images/excel.png">
																</button>
															</a> <a
																href="javascript:downloadReport('${portalListPageNumber}', '<%=Constants.PDF_FILE_FORMAT%>')">
																<button type="button" class="btn btn-default">
																	<img src="../images/PDF.png">
																</button>
															</a>
															<a>
															<input type="checkbox" class="autoCheck check" id="totalRecordsDownload">
															<spring:message code="common.label.downloadall"/> 
														</a>
														</div>
													</div>
												</div>
											</div>
										</td>
									</tr>
								</c:if>
							</table>
							<div class="col-sm-8 form-action-buttons" style="width: 96%;">
						<div class="col-sm-5"></div>
						<div class="col-sm-7">
							<!-- <input type="button" class="form-control button pull-right"
													value="Search">  -->
							<a type="button" href="specific-user-eftTransfers-show" class="form-control button pull-right"><spring:message code="common.label.back"/></a>
						</div>
					</div>
						</div>
						
					</div>
					
					<!-- Search Table Block End -->
				</div>
					<div id="my_popup" class="locatioin-list-popup" style="display: none;">
					<span class="glyphicon glyphicon-remove" onclick="closePopup()"></span>
					<fieldset class="col-sm-12 padding0">
							<div id="popUpTxnResult" ></div>
					</fieldset>
					<!-- Form Button Information Start -->
					<div class="col-sm-12">
						 <input	type="button" class="form-control button pull-right"
							value='<spring:message code="reportseft.label.okpopup"/>' onclick="closePopup()">
					</div>
					<!-- Form Button Information End -->
				</div>
			</article>
			<!--Article Block End-->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script> <script src="../js/utils.js"></script>
	<script src="../js/sortable.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/validation.js"></script>
	<script src="../js/jquery.datetimepicker.js"></script>
	<script src="../js/reports.js"></script>
	<script src="../js/jquery.popupoverlay.js"></script>
	<script type="text/javascript" src="../js/backbutton.js"></script>
	<script src="../js/jquery.cookie.js"></script>
	<script src="../js/messages.js"></script>
	<script>

	$(document).ready(function() {
		$(".focus-field").click(function() {
			$(this).children('.effectiveDate').focus();
		});

		$('.effectiveDate').datetimepicker({
			timepicker : false,
			format : 'm/d/Y',
			formatDate : 'Y/m/d',
		});
		
		  if ("${transactionDiv}" == "true"){
			 $('#checkb').show();
			 $('#transinfo').show();
			 $('#showDates').hide();
		   }  
	});
		/* Common Navigation Include Start */
		$(function() {
			//$("#main-navigation").load("main-navigation.html");
			highlightMainContent();
		});
		function highlightMainContent() {
			$("#navListId7").addClass("active-background");
		}
		/* Common Navigation Include End */
			 /* Common Pagination Include Start */
		 
						$(function() {
							highlightMainContent('navListId1');
							var rowsShown = 20;
							var pageShown=10;
							var rowsTotal = $('#serviceResults tbody tr').length;
							var numPages = rowsTotal / rowsShown;
							var startPagePoint=1;
							var endPagePoint=startPagePoint+pageShown-1;
							$('#serviceResults')
							.after(
									'<table style="width: 100%; margin-top: -20px;"><tr class="table-footer-main"><td class="search-table-header-column" colspan="10"><div class="col-sm-12">	<div class="col-sm-3">&nbsp;</div><div class="col-sm-9"><ul class="pagination custom-table-footer-pagination"><li id="liIdLeft"><a href="#" rel="'+startPagePoint+'">&laquo;</a></li><li id="liId"></a></li><li id="liIdRight"><a href="#" rel="'+endPagePoint+'">&raquo;</a></li></ul></div></div></td></tr></table>');
							for (i = 0; i < numPages; i++) {
								var pageNum = i + 1;
								$('#liId').append(
										'<a href="#" rel="'+i+'" id="rel'+i+'">' + pageNum
												+ '</a> ');
							}
							if(numPages<=pageShown){
								$('#liIdRight a').hide();
								$('#liIdLeft a').hide();
								}
							$('#liIdLeft a').hide();
							$('#serviceResults tbody tr').hide();
							$('#serviceResults tbody tr').slice(0, rowsShown).show();
							$('#liId a:first').addClass('active');
							$('#liId a').hide(); 
							$('#liId a').slice(0, pageShown).show(); 
							$('#liId a').bind(
									'click',
									function() {
										$('#liId a').removeClass('active');
										$(this).addClass('active');
										var currPage = parseInt($(this).attr('rel'));
										var startItem = currPage * rowsShown;
										var endItem = startItem + rowsShown;
										$('#serviceResults tbody tr').css('opacity',
												'0.0').hide().slice(startItem,
												endItem).css('display',
												'table-row').animate({
											opacity : 1
										}, 300);
									});
							$('#liIdLeft a').bind(
									'click',
									function() {
										var currPage1 = parseInt($(this).attr('rel'));
										$('#liId a').hide();
										$('#liId a').slice(currPage1-pageShown,currPage1).show();
										if((currPage1-pageShown)<=0){
											startPagePoint=0;
											$('#liIdLeft a').hide();
											$(this).attr('rel',1);
											}
										else{
											startPagePoint=(currPage1-pageShown);
											$('#liIdLeft a').show();
											$(this).attr('rel',startPagePoint);
									     	}
										endPagePoint=startPagePoint+pageShown;
										$('#liIdRight a').attr('rel',endPagePoint);
										if(endPagePoint>=numPages){
											$('#liIdRight a').hide();
											}else{
												$('#liIdRight a').show();
												}
										if(startPagePoint>0&&startPagePoint<=(numPages)){
											$('#liIdLeft a').show();
											}else{
												$('#liIdLeft a').hide();
												}
										var t='rel'+(startPagePoint);
										$('#'+t).click();
									});
							$('#liIdRight a').bind(
									'click',
									function() {
										var currPage2 = parseInt($(this).attr('rel'));
										$('#liId a').slice(0,currPage2).hide();
										$('#liId a').slice(currPage2,currPage2+pageShown).show();
										startPagePoint=parseInt(currPage2);
										endPagePoint=parseInt(startPagePoint)+pageShown;
										$(this).attr('rel',endPagePoint);
										$('#liIdLeft a').attr('rel',startPagePoint);
										if(endPagePoint>=numPages){
											$('#liIdRight a').hide();
											}
										if(startPagePoint>0&&startPagePoint<=numPages){
											$('#liIdLeft a').show();
											}
										var t='rel'+(startPagePoint);
										$('#'+t).click();
									});
						});
		
				  /* Common Pagination Include End */
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