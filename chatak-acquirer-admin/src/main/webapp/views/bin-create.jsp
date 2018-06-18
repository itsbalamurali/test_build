<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page  import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
  int year = Calendar.getInstance().get(Calendar.YEAR);
%>
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
</head>
<body>
<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block Start -->

			<!--Header Block End -->
			<!--Navigation Block Start -->
			<nav class="col-sm-12 nav-bar" id="main-navigation">
			<%-- <jsp:include
					page="header.jsp" /> --%>
					<%@include file="navigation-panel.jsp"%>
					</nav>
			<!--Navigation Block Start -->
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text"><spring:message code="setup.label.setup"/></span> 
						<span class="glyphicon glyphicon-play icon-font-size"></span>
						<span class="breadcrumb-text"><spring:message code="bin.label.onus"/></span> 
						<span class="glyphicon glyphicon-play icon-font-size"></span> 
						<span class="breadcrumb-text"><spring:message code="common.label.create"/></span>
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<c:if test="${fn:contains(existingFeatures,ONUSBINEdit)||fn:contains(existingFeatures,ONUSBINDelete)||fn:contains(existingFeatures,ONUSBINCreate)||fn:contains(existingFeatures,ONUSBINView)}">
					<div class="tab-header-container-first">
						<a href="bin-search-show">Search
						</a>
					</div>
					</c:if>
					<c:if test="${fn:contains(existingFeatures,ONUSBINCreate)}">
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
									<div class="discriptionMsg" data-toggle="tooltip" data-placement="top" title="">
										<span class="red-error">${error}</span> <span
											class="green-error">${sucess}</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<form:form action="bin-save-update" commandName="binDTO" name="binDTO">
								<input type="hidden" name="CSRFToken" value="${tokenval}">
									<div class="col-sm-12 paddingT20">
										<div class="row">
											<!-- Account Details Content Start -->
											<section class="field-element-row account-details-content">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="bin.label.binnumber"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="binNumber"
															id="binNumber" maxlength="6"
															onblur="this.value=this.value.trim();validateBinNumber()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="binNumberEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="bin.label.dccsupport"/><span class="required-field">*</span></label><br>
													<input type="radio" id="dccSupported"
														   name="dccSupported" value="1" onclick="validateRadio1()"><spring:message code="bin.label.yes"/>
														   
													<input type="radio" id="noDccSupported"
														   name="dccSupported" value="0" onclick="validateRadio1()"><spring:message code="bin.label.no"/>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="dccSupportedErr" class="red-error">&nbsp;</span>
													</div>
													</fieldset>
													
													<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="bin.label.emvsupport"/><span class="required-field">*</span></label><br>
													<input type="radio" id="emvSupported"
														   name="emvSupported" value="1" onclick="validateRadio2()"><spring:message code="bin.label.yes"/>
														   
													<input type="radio" id="noEmvSupported"
														   name="emvSupported" value="0" onclick="validateRadio2()"><spring:message code="bin.label.no"/>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="emvSupportedErr" class="red-error">&nbsp;</span>
													</div>
													</fieldset>
													
													<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="switch.label.switchname"/>
													<span class="required-field">*</span></label><br>
													<form:select path="switchId" id="switchId"
														cssClass="form-control" onblur="validateSwitchForBin()">
														<form:option value=""><spring:message code="reports.option.select"/></form:option>
															<c:forEach items="${switchName}" var="switchName">
															<form:option value="${switchName.id}">${switchName.switchName}</form:option>
														</c:forEach>
														</form:select>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span id="switchNameErr"  class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="submit"
															class="form-control button pull-right acc-next"
															value='<spring:message code="common.label.create"/>' onclick="return validateBinCreate()"> <input 
															type="button"
															class="form-control button pull-right marginL10"
															value='<spring:message code="common.label.cancel"/>'onclick="openCancelConfirmationPopup()"> 
															<input type="reset" class="form-control button pull-right marginL10"
										                     value='<spring:message code="common.label.reset"/>' onclick="resetBin()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- Account Details Content End -->
											</div>
										</div>	
								</form:form> 
								<!-- Page Form End -->
								</div>
						</div>
					</div>
					<!-- Content Block End -->
				</div>
				<div id="my_popup1" class="popup-void-refund voidResult">
					<span class="glyphicon glyphicon-remove closePopupMes"
						onclick="closeCancelConfirmationPopup()"></span>
					<div class="fw-b-fs15" style="padding: 20px;">
						<spring:message code="cancle.conformation.lable.currency" />
					</div>
					<div class="col-sm-12">

						<input type="button"
							class="form-control button pull-right margin5 close-btn"
							value="<spring:message code="bin.label.no"/>"
							onclick="closeCancelConfirmationPopup()"> <input
							type="submit" class="form-control button pull-right margin5"
							value="<spring:message code="bin.label.yes"/>"
							onclick="resetBinCreate()">
					</div>
				</div>
			</article>
			<!--Article Block End-->
		<div class="footer-container">
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</div>
		<!--Container block End -->
	</div>
	
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
<script src="../js/utils.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/jquery.cookie.js"></script>
	<script src="../js/jquery.datetimepicker.js"></script>
	<script src="../js/validation.js"></script>
	<script src="../js/chatak-ajax.js"></script>
	<script src="../js/messages.js"></script>
	<script src="../js/bin.js"></script>
    <script src="../js/jquery.popupoverlay.js"></script>
	<script type="text/javascript" src="../js/backbutton.js"></script>
	<script type="text/javascript" src="../js/browser-close.js"></script>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#navListId2").addClass("active-background");
	});
	$('#my_popup1').popup({
		blur : false
	});
	
	function resetBinCreate(){
		 window.location.href = 'bin-search-show';
	}
	</script>
	</html>