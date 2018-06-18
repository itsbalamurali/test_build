<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.pan-btn {
	padding: 10px
}

.head-border {
	border-bottom: 2px solid #bfbfbf;
}

.radio-btn-align {
	float: left;
	width: 17px;
}

.radio-btn-input-align {
	width: 160px;
	margin-left: 5px;
	font-size: 11px !important;
	margin-top: 5px;
}

.last-input-field {
	margin-left: -100px;
	width: 15%;
}

.add-btn-style {
	margin: 10px 30px
}

.other-fee-label {
	border-bottom: 2px solid #bfbfbf
}

.final-create-btn {
	margin-right: 20px
}

.bck-color {
	background: #dddddd;
}

.filter-content {
	margin-bottom: 20px;
}

.dollar {
	color: #373737;
	font-size: 13px;
	left: 20px;
	position: absolute;
	top: -14px;
}

.flat-dollar {
	color: #373737;
	font-size: 13px;
	left: 20px;
	position: absolute;
	top: 8px;
}
.marginML-25{
	margin-left:-25px;
	width:18.66%
}
.dynamicData
{
   margin-left: -15px;margin-right: 2px;
}
.dynamicradio
{
	padding: 0px; margin-left: -12px;
}
.padding-left_25px
{

	padding-left:25px;
	
}
</style>
</head>
<body>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block Start -->
			<header class="col-sm-12 all-page-header">
				<!--Header Logo Start -->
				<!-- <div class="col-sm-4">
					<img src="images/chatak_logo.jpg" height="35px" alt="Logo"/>
				</div> -->
				<!--Navigation Block Start -->
				<%-- <jsp:include page="header.jsp"></jsp:include> --%>
				<%@include file="navigation-panel.jsp"%>
				<!--Navigation Block Start -->
				<!--Header Logo End -->
			</header>
			<!--Header Block End -->
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text"><spring:message code="fee-program-edit.label.programs" /></span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text"><spring:message code="fee-program-edit.label.feeprogram" /></span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text"><spring:message code="fee-program-edit.label.edit" /></span>
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<div class="tab-header-container-first">
						<a href="show-fee-program-search"><spring:message code="fee-program-edit.label.searchtab" /></a>
					</div>
					<div class="tab-header-container active-background">
						<a href="#"><spring:message code="fee-program-edit.label.edittab" /></a>
					</div>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<form:form action="updateFeeProgram" modelAttribute="feeProgramDTO" method="post">
						<form:hidden path="feeProgramId" />
						<input type="hidden" name="CSRFToken" value="${tokenval}">
						<div class="col-sm-12">
							<!-- Page Form Start -->
							<div class="form-horizontal main-content-holder bck-color" style= "height:215px">
								<div class="row">
									<div class="field-element-row margin0 paddingLR15"></div>
								</div>
								<div class="col-xs-12">
									<div class="descriptionMsg col-xs-12">
										<span class="red-error">&nbsp;${error }</span> <span
											class="green-error">&nbsp;${sucess }</span>
									</div>
								</div>
								<!--Panel Action Button Start -->
								<div class="col-sm-12 added-row">
									<div class="form-group pan-btn">
										<fieldset class="col-sm-6">
											<label class="control-label col-sm-6"><spring:message code="fee-program-edit.label.feeprogramname" />
												 <span class='required-field'>*</span>
											</label>
											<div class="col-sm-5">
												<form:input path="feeProgramName" id="feeProgramName"
													cssClass="form-control feeProgramName" readonly="true"/>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="feeProgramNameEr" class="red-error">&nbsp;</span>
														</div>
											</div>
										</fieldset>
									</div>
									<fieldset class="col-sm-12" style="margin-top: -13px;">
										<label class="col-sm-2 head-border"><spring:message code="fee-program-edit.label.discountrate" /></label>
									</fieldset>
									<c:forEach var="rows" items="${feeProgramDTO.feeValueList}"
										varStatus="status">
										<fieldset class="col-sm-12 padding0 filter-content" style="margin-left: 12px;">
											<fieldset class="col-sm-2" style="width:18.66%">
												<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="fee-program-edit.label.cardtype" /><span class='required-field'>*</span></label>
												<form:select path="feeValueList[${status.index}].cardType"
													cssClass="form-control marginB5 cardType" id="feeValueList[${status.index}].cardType">
													<form:option value=""><spring:message code="fee-program-edit.label.select" /></form:option>
													<form:option value="IP" cssClass="ip"><spring:message code="fee-program-create.label.ipsidy" /></form:option>
												</form:select>
												<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="feeValueList[${status.index}].cardTypeEr" class="red-error">&nbsp;</span>
														</div>

											</fieldset>
											<fieldset class="col-sm-2 marginML-25">
												<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="fee-program-edit.label.%value" /><span class='required-field'>*</span></label>
												<form:input
													path="feeValueList[${status.index}].feePercentage" maxlength="10"
													cssClass="form-control feePercentage" id="feeValueList[${status.index}].feePercentage" onblur="this.value=this.value.trim();"/>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="feeValueList[${status.index}].feePercentageEr" class="red-error">&nbsp;</span>
														</div>
											</fieldset>
											<fieldset class="col-sm-2 marginML-25">
												<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="fee-program-edit.label.flatfee" /><span class='required-field'>*</span></label>
												<form:input path="feeValueList[${status.index}].flatFee" maxlength="10"
													cssClass="form-control flatFee" id="feeValueList[${status.index}].flatFee" onblur="this.value=this.value.trim();"/>
												<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="feeValueList[${status.index}].flatFeeEr" class="red-error">&nbsp;</span>
														</div>
											</fieldset>
											<fieldset class="col-sm-2 marginML-25" style="width: 52%">
												<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="fee-program-edit.label.credtto" /><span class='required-field'>*</span></label>
												<div class="col-sm-12" >
													<fieldset class="col-sm-6 padding0 dynamicradio">
														<span class="radio-btn-align"><form:radiobutton
																path="feeValueList[${status.index}].accountType"
																value="SYS" id="feeValueList[${status.index}].accountTypeSYS" /></span><label class="radio-btn-input-align">
															<spring:message code="fee-program-edit.label.systemrevenueaccount" />
														</label>
													</fieldset>
													<fieldset class="col-sm-6 padding0 dynamicradio">
														<span class="radio-btn-align"><form:radiobutton
																path="feeValueList[${status.index}].accountType" id="feeValueList[${status.index}].accountTypeOTH"
																value="OTH" /></span><label class="radio-btn-input-align"><spring:message code="fee-program-edit.label.specifiedaccount" />
														</label>
													</fieldset>
												</div>
												<div class="discriptionMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="feeValueList[${status.index}].accountTypeOTHEr" class="red-error">&nbsp;</span>
														</div>
											</fieldset>
											<fieldset class="col-sm-1"
												style="margin-left:-128px;width: 15%;">
												<label data-toggle="tooltip" data-placement="top" title="">&nbsp;</label>
												<form:input
													path="feeValueList[${status.index}].accountNumber"
													cssClass="form-control accountNumber" id="feeValueList[${status.index}].accountNumber" />
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="feeValueList[${status.index}].accountNumberEr" class="red-error accountNumberEr">&nbsp;</span>
														</div>
											</fieldset>
											<fieldset class='col-sm-1 textCenter marginT30'
												style='margin: -40px 0px 15px 758px'>
												<span class='glyphicon glyphicon-trash delete-icon'
													style='cursor: pointer ;margin-left: 55px;'></span>
											</fieldset>
										</fieldset>
									</c:forEach>
								</div>
								<!--Panel Action Button End -->
								<!-- Page Form End -->
							</div>
							<div class="form-horizontal main-content-holder otherfees bck-color">
								<fieldset class="col-sm-12">
									<label class="col-sm-2 other-fee-label"><spring:message code="fee-program-edit.label.otherfee" /></label>
								</fieldset>
								<div class="form-group">
									<label class="control-label col-sm-2"><spring:message code="fee-program-edit.label.setupfee" />
									</label>
									<div class="col-sm-3">
										<form:input path="otherFee.setupFee" id="otherFee.setupFee" maxlength="10"
											cssClass="form-control padding-left_25px setupFee" onblur="this.value=this.value.trim();"/>

										<h3 class="dollar"><spring:message code="fee-program-edit.label.$" /></h3>
										<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="otherFee.setupFeeEr" class="red-error">&nbsp;</span>
														</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2"><spring:message code="fee-program-edit.label.settlementfee" /></label>
									<div class="col-sm-3">
										<form:input path="otherFee.settlementFee" id="otherFee.settlementFee" maxlength="10"
											cssClass="form-control padding-left_25px settlementFee" onblur="this.value=this.value.trim();"/>
										<h3 class="dollar"><spring:message code="fee-program-edit.label.$" /></h3>
										<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="otherFee.settlementFeeEr" class="red-error">&nbsp;</span>
														</div>
									</div>
									<label class="control-label col-sm-2"><spring:message code="fee-program-edit.label.charge" /></label>
									<div class="col-sm-3">
										<form:select path="otherFee.chargeFrequency" id="otherFee.chargeFrequency"
											cssClass="form-control chargeFrequency">
											<form:option value="M"><spring:message code="fee-program-edit.label.monthly" /></form:option>
											<form:option value="W"><spring:message code="fee-program-edit.label.weekly" /></form:option>
											<form:option value="A"><spring:message code="fee-program-edit.label.annually" /></form:option>
										</form:select>
										<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="otherFee.chargeFrequencyEr" class="red-error">&nbsp;</span>
														</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2"><spring:message code="fee-program-edit.label.chargebackfee" /><span
										class='required-field'>*</span>
									</label>
									<div class="col-sm-3">
										<form:input path="otherFee.chargeBacKFee" id="otherFee.chargeBacKFee" maxlength="10"
											cssClass="form-control padding-left_25px chargeBacKFee" onblur="this.value=this.value.trim();"/>
										<h3 class="dollar"><spring:message code="fee-program-edit.label.$" /></h3>
										<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="otherFee.chargeBacKFeeEr" class="red-error">&nbsp;</span>
														</div>
									</div>
								</div>
								<p>
									<span class='required-field'>*</span><spring:message code="fee-program-edit.label.manuallytriggeredfee" />
								</p>

							</div>
							<div class="col-sm-12 button-content">
								<fieldset class="col-sm-7 pull-right">
								<input type="submit" class="form-control button pull-right marginL10" value="<spring:message code="fee-program-edit.label.updatebutton" />" id="updateFeePgm" />
								<input type="button" class="form-control button pull-right marginL10" value="<spring:message code="fee-program-edit.label.cancelbutton" />" onclick="openCancelConfirmationPopup()"/>
								</fieldset>
							</div>
						</div>
					</form:form>
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
							onclick="resetFeeSearch()">
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
	<!--Body Wrapper block End -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
<script src="../js/utils.js"></script>
	<script src="../js/jquery.cookie.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/feeprogram.js"></script>
	 <script src="../js/messages.js"></script>
	 <script src="../js/jquery.popupoverlay.js"></script>
	 <script type="text/javascript" src="../js/browser-close.js"></script>
	<script>
		var row = 0;

		$(document).ready(function() {
			$( "#navListId3" ).addClass( "active-background" );
			
			/* $('.cardType').each(function() {
				var selOptionClass = $(this).find('option:selected').attr('class');
				$(this).addClass('active');
				$('.cardType').each(function() {
					if(!$(this).hasClass('active')) {
						$('.cardType').find('.'+selOptionClass).hide();
					}
				});
				$(this).removeClass('active');
			}); */

			$('.filter-content').eq(0).find('fieldset').last().remove();
			
			row = $('.added-row fieldset.filter-content').length;

			$(".addRow").click(function() {
				//if ($('.added-row fieldset.filter-content').length < 4) {
					row++;
					var newFilterRow = "<fieldset class='col-sm-12 padding0 filter-content' style='margin-left: 12px;'><fieldset class='col-sm-2' style='width:18.66%'> <label data-toggle='tooltip' data-placement='top' title=''><spring:message code='fee-program-create.label.cardtype' /><span class='required-field'>*</span></label><select class='form-control marginB5 cardType' name='feeValueList["+row+"].cardType' id='feeValueList["+row+"].cardType'><option value=''><spring:message code='fee-program-create.label.select' /></option><option value='IP' class='ip'><spring:message code='fee-program-create.label.ipsidy' /></option></select><div class='discriptionErorMsg'><span id='feeValueList["+row+"].cardTypeEr' class='red-error'>&nbsp;</span></div></fieldset><fieldset class='col-sm-2 marginML-25'><label><spring:message code='fee-program-create.label.%value' /><span class='required-field'>*</span></label><input type='text' value='0.00' maxlength='10' name='feeValueList["+row+"].feePercentage' class='form-control feePercentage' id='feeValueList["+row+"].feePercentage'><div class='discriptionErrorMsg'><span id='feeValueList["+row+"].feePercentageEr' class='red-error'>&nbsp;</span></div></fieldset><fieldset class='col-sm-2 marginML-25'><label><spring:message code='fee-program-create.label.flatfee' /><span class='required-field'>*</span></label><input type='text' value='0.00' maxlength='10' name='feeValueList["+row+"].flatFee' class='form-control flatFee' id='feeValueList["+row+"].flatFee'><div class='discriptionErrorMsg'><span id='feeValueList["+row+"].flatFeeEr' class='red-error'>&nbsp;</span></div></fieldset><fieldset class='col-sm-2 marginML-25' style='width:52%'> <label><spring:message code='fee-program-create.label.creditto' /><span class='required-field'>*</span></label><div class='col-sm-12' style=margin-left: -15px;margin-right: 2px;'><fieldset class='col-sm-6 padding0 dynamicradio'><span class='radio-btn-align'><input type='radio' value='SYS' name='feeValueList["+row+"].accountType' id='feeValueList["+row+"].accountTypeSYS'></span><label class='radio-btn-input-align'><spring:message code='fee-program-create.label.systemrevenueaccount' /></label></fieldset><fieldset class='col-sm-6 padding0 dynamicradio'><span class='radio-btn-align'><input type='radio' value='OTH' name='feeValueList["+row+"].accountType' id='feeValueList["+row+"].accountTypeOTH'></span><label class='radio-btn-input-align'><spring:message code='fee-program-create.label.specifiedaccount' /></label></fieldset><div class='discriptionErrorMsg' style='float: left;'><span id='feeValueList["+row+"].accountTypeOTHEr' class='red-error'>&nbsp;</span></div></div></fieldset><fieldset class='col-sm-1' style='margin-left:-128px;width: 15%;'><label>&nbsp;</label><input type='text' value='' name='feeValueList["+row+"].accountNumber' id='feeValueList["+row+"].accountNumber' class='form-control accountNumber' placeholder='<spring:message code='fee-program-create.label.specifiedaccount' />'><div class='discriptionErrorMsg'><span id='feeValueList["+row+"].accountNumberEr' class='red-error accountNumberEr'>&nbsp;</span></div></fieldset><fieldset class='col-sm-1 textCenter marginT30' style='margin:-40px 0px 15px 758px'><span class='glyphicon glyphicon-trash delete-icon' style='cursor:pointer;margin-left: 55px;'></span></fieldset></fieldset>";
					$(".added-row").append(newFilterRow);

					/* $('.cardType').each(function() {
						var selOptionClass = $(this).find('option:selected').attr('class');
						$('.cardType').last().find('.'+selOptionClass).hide();
					}); */
				//}
			});

			$('body').on('click', '.delete-icon', function() {
				var deletedSelctOption = $(this).parent().siblings().eq(0).find('.cardType').find('option:selected').attr('class');
				$(this).parent().parent().remove();
				/* $('.cardType').each(function() {
					if(!$(this).hasClass('active')) {
						$(this).find('.'+deletedSelctOption).show();
					}
				}); */
			});

			var prevOptionClass;
			$('body').on('focus','.cardType',function() {
				prevOptionClass = $(this).find('option:selected').attr('class');
			});

			/* $('body').on('change','.cardType',function() {
				$(this).addClass('active');
				var selOptionClass = $(this).find('option:selected').attr('class');

				if (selOptionClass == undefined && prevOptionClass != selOptionClass) {
					$('.cardType').each(function() {
						if (!$(this).hasClass('active')) {
							$(this).find('.'+ prevOptionClass).show();
						}
					});
				} else {
					$('.cardType').each(function() {
					if (!$(this).hasClass('active')) {
							$(this).find('.'+ selOptionClass).hide();
						}
					});
				}
				$(this).removeClass('active');
			}); */
			
			$('body').on('blur','.cardType',function() {
				validateCardType($(this));
			});
			
			$('body').on('blur','.feePercentage',function() {
				validateFeeAmount($(this)," %Value",true);
			});
			
			$('body').on('blur','.flatFee',function() {
				validateFeeAmount($(this)," Flat Fee",true);
			});
			
			$('body').on('blur','.settlementFee',function() {
				validateFeeAmount($(this)," Settlement Fee",false);
			});
			
			$('body').on('blur','.setupFee',function() {
				validateFeeAmount($(this)," SetUp Fee",false);
			});
			
			$('body').on('blur','.chargeBacKFee',function() {
				validateFeeAmount($(this)," Charge Back Fee",true);
			});
		

			$('body').on('blur','.accountNumber',function() {
				validateSpecifiedAccountNo($(this));
			});
			
			$('body').on('click','[id$=".accountTypeSYS"],[id$=".accountTypeOTH"]', function() {
				if($(this).is(':checked')) {
					if($(this).attr('id').indexOf('SYS') > 0) {
						$('.accountNumberEr').text('');
					}
					
					$(this).closest('div').find('div').find('span').text(''); 
				}
			});

			$('#updateFeePgm').on('click', function() {
				$('.cardType,.feePercentage,.flatFee,.settlementFee,.setupFee,.chargeBacKFee,.accountNumber').trigger('blur');
				var preAttrName = "";
				$('*[name*=accountType]').each(function() {
				    var attrName = $(this).attr('name');
				    if(preAttrName != attrName) {
				    	var id;
				    	if($("input:radio[name='"+attrName+"']:checked").length == 0) {
					    	id = $("input:radio[name*='"+attrName+"']").eq(1).attr('id');
					    	setError(get(id), 'Please Select Credit To Account ');
						} else {
							id = $("input:radio[name*='"+attrName+"']").eq(1).attr('id');
							setError(get(id), '');
						}
					}
				});

				var isValid = true;
				$("[id$='Er']").each(function() {
					if($(this).text().trim().length > 0) {
						isValid = false;
						return false;
					}
				});

				return isValid;
			});

			$('#cancel').on('click', function() {
				window.location.href = 'show-fee-program-search';
			});
		});Cancel
		$('#my_popup1').popup({
			blur : false
		});
	</script>
</body>
</html>