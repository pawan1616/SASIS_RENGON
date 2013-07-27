$(document).ready(function(){
	
	$(document).on('change','#installCourseCombo',function(){
		val=this.value;
		param=$('#installCourseCombo').attr('name');
		changePage("fee/changeCourseInstallment.action", ".filterContent", param+"="+val);
	});
	$(document).on("change","#crsInstallments",function(){
//		alert(this.value);
		crsId=this.value;
		
		if(this.value!=-1){
			
			$.ajax({
				type: "POST",
				url: "fee/getInstallmentsFromCourse.action",
				data: 'courseId='+crsId,
				cache: false,
				success: function(msg){
					var crsBtch2Html="";
					$.each(msg.installList,function(i,v){
						crsBtch2Html=crsBtch2Html+"<option value="+v.installmentId+">"+v.dueDate+" "+v.amnt+"</option>\n";
					});
					$("#divideToInstall").html(crsBtch2Html);
					if(msg.installList.length==0)
						$("#divideToInstall").html("<option value=-1>Select</option>");					
				}
			});
		}
		if(typeof($("#sessBatch").val())!='undefined'){
			fetchSess=$(this).parent(".ui-widget").find("input[name='sessFetchTyp']").val();
			param='courseId='+crsId;
			if(typeof(fetchSess)!='undefined')
				param=param+"&&sessFetchTyp="+fetchSess;
			$.ajax({
				type: "POST",
				url: "getActiveInstSessFromCourse.action",
				data: param,
				cache: false,
				success: function(msg){
					var crsSess2Html="";
					$.each(msg.instSessList,function(i,v){
						crsSess2Html=crsSess2Html+"<option value="+v.instSessInfoId+">"+v.name+"</option>\n";
					});
					$("#sessBatch").html(crsSess2Html);
					if(msg.instSessList.length==0)
						$("#sessBatch").html("<option value=-1>Select</option>");					
				}
			});
		}
	});
});

function saveInstallmentValues(){
	params="";
	for(i=1;i<$('#installTblDisplay tr').size();i++){
		param="installmentsSaveList";
		param=param+'='+$('#installTblDisplay tr').eq(i).find('td').eq(0).find('input').val()+"~"+$('#installTblDisplay tr').eq(i).find('td').eq(1).find('input').val()+"&";
		params=params+param;
	}
	formSubmit('fee/saveInstallments',params);
}
function createInstallments(){
	$("form").submit(function () { return false; });
	paramList=getFormData("fee/createInstallments.action");
	changePage("fee/createInstallments.action", ".filterContent", paramList);
}
