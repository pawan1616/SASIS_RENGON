var reg = /[0-9 -()+]+$/;
var floatReg=/^[-+]?[0-9]*\.?[0-9]+$/;
var passwordReg=/(?=.*\d)(?=.*[a-zA-Z])(?=.*[@#$%]).{6,20}/;
$(document).ready(function(){
	$(document).on('blur','.normalTextBoxReq',normalTxtReq);
	$(document).on('blur','#mobileReq1',specialMobileReq);
});


	function validateSwitch(validatorName){
		var result=false;
		$("form").submit(function () { return false; });
		switch(validatorName){
		case 'subCreate':
			result=subCreateValidation();
			break;
		case 'courseCreate':
			result=courseCreateValidation();
			break;
		case 'exmTypeCreate':
			result=exmTypeCreateValidation();
			break;
		case 'examCreate':
			result=examCreateValidation();
			break;
		case 'batchCreate':
			result=batchCreateValidation();
		break;
		default:
			alert('default calls');
			break;
		}
		return result;
	}
	function txtReq(normalTxtReq,normalTxtReqDesc){
		if(normalTxtReq.val().trim().length<1){
			errorCls=normalTxtReq.parent('td').next('td').find(normalTxtReqDesc);
			errorCls.text("--->   This field is required");
			errorCls.css('color','#C62D2D');
			$('.normalTextBoxReq').css({'border-width':'5px','border-color':'#C62D2D'});
			return false;
		}else{
			okCls=normalTxtReq.parent('td').next('td').find(normalTxtReqDesc);
			okCls.removeAttr("style");
			okCls.html('<img src="images/small green ok.jpg">');
			if(normalTxtReq.attr('style')!='undefined')
				normalTxtReq.removeAttr('style');
			return true;
		}
	}
	function admissionReq(){
		for(i=0;i<=10;i++){
			if($('.normalTextBoxReq').eq(i).val().trim().length<1){
				$('.normalTextBoxReq').eq(i).css({'border-width':'5px','border-color':'#C62D2D'});
			}else{
				$('.normalTextBoxReq').eq(indexId).removeAttr('style');
			}
		}
	}
	function normalTxtReq(){
		indexId=$('.normalTextBoxReq').index($(this));
		alert(indexId);
		$('.normalTextBoxReq').eq(indexId).css({'border-width':'5px','border-color':'#C62D2D'});
	}
	function specialMobileReq(){
		
	}
