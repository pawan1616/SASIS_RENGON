jQuery.easing['jswing'] = jQuery.easing['swing'];

jQuery.extend( jQuery.easing,
		{
	def: 'easeOutQuad',
	swing: function (x, t, b, c, d) {
		//alert(jQuery.easing.default);
		return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
	},
	easeInQuad: function (x, t, b, c, d) {
		return c*(t/=d)*t + b;
	},
	easeOutQuad: function (x, t, b, c, d) {
		return -c *(t/=d)*(t-2) + b;
	},
	easeInOutQuad: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t + b;
		return -c/2 * ((--t)*(t-2) - 1) + b;
	},
	easeInCubic: function (x, t, b, c, d) {
		return c*(t/=d)*t*t + b;
	},
	easeOutCubic: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t + 1) + b;
	},
	easeInOutCubic: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t + b;
		return c/2*((t-=2)*t*t + 2) + b;
	},
	easeInQuart: function (x, t, b, c, d) {
		return c*(t/=d)*t*t*t + b;
	},
	easeOutQuart: function (x, t, b, c, d) {
		return -c * ((t=t/d-1)*t*t*t - 1) + b;
	},
	easeInOutQuart: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t + b;
		return -c/2 * ((t-=2)*t*t*t - 2) + b;
	},
	easeInQuint: function (x, t, b, c, d) {
		return c*(t/=d)*t*t*t*t + b;
	},
	easeOutQuint: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t*t*t + 1) + b;
	},
	easeInOutQuint: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t*t + b;
		return c/2*((t-=2)*t*t*t*t + 2) + b;
	},
	easeInSine: function (x, t, b, c, d) {
		return -c * Math.cos(t/d * (Math.PI/2)) + c + b;
	},
	easeOutSine: function (x, t, b, c, d) {
		return c * Math.sin(t/d * (Math.PI/2)) + b;
	},
	easeInOutSine: function (x, t, b, c, d) {
		return -c/2 * (Math.cos(Math.PI*t/d) - 1) + b;
	},
	easeInExpo: function (x, t, b, c, d) {
		return (t==0) ? b : c * Math.pow(2, 10 * (t/d - 1)) + b;
	},
	easeOutExpo: function (x, t, b, c, d) {
		return (t==d) ? b+c : c * (-Math.pow(2, -10 * t/d) + 1) + b;
	},
	easeInOutExpo: function (x, t, b, c, d) {
		if (t==0) return b;
		if (t==d) return b+c;
		if ((t/=d/2) < 1) return c/2 * Math.pow(2, 10 * (t - 1)) + b;
		return c/2 * (-Math.pow(2, -10 * --t) + 2) + b;
	},
	easeInCirc: function (x, t, b, c, d) {
		return -c * (Math.sqrt(1 - (t/=d)*t) - 1) + b;
	},
	easeOutCirc: function (x, t, b, c, d) {
		return c * Math.sqrt(1 - (t=t/d-1)*t) + b;
	},
	easeInOutCirc: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return -c/2 * (Math.sqrt(1 - t*t) - 1) + b;
		return c/2 * (Math.sqrt(1 - (t-=2)*t) + 1) + b;
	},
	easeInElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return -(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
	},
	easeOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
	},
	easeInOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d/2)==2) return b+c;  if (!p) p=d*(.3*1.5);
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		if (t < 1) return -.5*(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
		return a*Math.pow(2,-10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )*.5 + c + b;
	},
	easeInBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158;
		return c*(t/=d)*t*((s+1)*t - s) + b;
	},
	easeOutBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158;
		return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
	},
	easeInOutBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158; 
		if ((t/=d/2) < 1) return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
		return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
	},
	easeInBounce: function (x, t, b, c, d) {
		return c - jQuery.easing.easeOutBounce (x, d-t, 0, c, d) + b;
	},
	easeOutBounce: function (x, t, b, c, d) {
		if ((t/=d) < (1/2.75)) {
			return c*(7.5625*t*t) + b;
		} else if (t < (2/2.75)) {
			return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
		} else if (t < (2.5/2.75)) {
			return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
		} else {
			return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
		}
	},
	easeInOutBounce: function (x, t, b, c, d) {
		if (t < d/2) return jQuery.easing.easeInBounce (x, t*2, 0, c, d) * .5 + b;
		return jQuery.easing.easeOutBounce (x, t*2-d, 0, c, d) * .5 + c*.5 + b;
	}
		});

$(document).ready(function(){
	$(function() {
		$('#nav > div').hover(
				function () {

					var $this = $(this);
					$this.find('img').stop().animate({
						'width'     :'199px',
						'height'    :'199px',
						'top'       :'-25px',
						'left'      :'-25px',
						'opacity'   :'1.0'
					},500,'easeOutBack',function(){
						$(this).parent().find('ul').fadeIn(700);
					});

					$this.find('a:first,h2').addClass('active');
				},
				function () {
					var $this = $(this);
					$this.find('ul').fadeOut(500);
					$this.find('img').stop().animate({
						'width'     :'52px',
						'height'    :'52px',
						'top'       :'0px',
						'left'      :'0px',
						'opacity'   :'0.1'
					},5000,'easeOutBack');

					$this.find('a:first,h2').removeClass('active');
				}
		);
	});

	$(document).on("submit","#loginAuthForm",function(e){
		e.preventDefault();
		
		var actionName=$(this).attr("action");
		var usrName=$(this).find("input[name='usrName']").val();
		var password=$(this).find("input[name='password']").val();
		$.ajax({
			type: "POST",
			url: actionName,
			data:'usrName='+usrName+'&'+'password='+password,
			cache: false,
			success: function(msg){
				if(typeof(msg.errorMsgTransporter)==='undefined'){
//					alert("bhoot");
					window.location.replace("nav2template.action");
				}else if(msg.errorMsgTransporter.isErrorIn){
					$.each(msg.errorMsgTransporter.errMsg,function(i,v){
						$("#"+i).html(v);
					});
				};
			}
		}).done(function() {
			pageViewSetting();
			tabAdjPageContent();
		});
	});
	function showErrMsg(msg){
		
	}
	$(document).on("click",".item ul>li a",function(){
		var targetLink=$(this).attr("name");
		changePage(targetLink, ".pageContent", "");



	});

	function resetTabs(){
		$("#tabs a").attr("id",""); //Reset id's      
	}

	$(document).on("click","#tabs a",function(e) {
		e.preventDefault();
		if ($(this).attr("id") == "current"){ //detection for current tab
			return       
		}
		else{             
			resetTabs();
			$(this).attr("id","current"); // Activate this
			$($(this).attr('name')).fadeIn(); // Show content for current tab
			var targetLink=$(this).attr("href");
			if(targetLink!="#")
				changePage(targetLink, ".mainContent", "");
		}
	});

	$(document).on("click","#report .delete a",function(e){
		e.preventDefault();
		var indexId=$("#report .delete a").index($(this));
		roleId=$(".editableId").eq(indexId).text();
		name=$(".editableId").eq(indexId).attr("id");
		var targetLink=$(this).attr("href");
		isPrefCheck=false;
		alert(name+" "+roleId)
		if(targetLink!="#")
			changePage(targetLink, ".mainContent", name+"="+roleId);
	});
	$(document).on("click","#reportSummary .delete a",function(e){
		e.preventDefault();
		var indexId=$("#reportSummary .delete a").index($(this));
		roleId=$(".editableId").eq(indexId).text();
		name=$(".editableId").eq(indexId).attr("id");
		var targetLink=$(this).attr("href");
		isPrefCheck=false;
		if(targetLink!="#")
			changePage(targetLink, ".mainContent", name+"="+roleId);
	});
	$(document).on("click","#report  a",function(e){
		e.preventDefault();
		alert(".....fdaasd");
		var indexId=$("#report h4 a").index($(this));
		roleId=$(".editableId").eq(indexId).text();
		name=$(".editableId").eq(indexId).attr("id");
		var targetLink=$(this).attr("href");
		isPrefCheck=false;
		if(targetLink!="#")
			changePage(targetLink, ".mainContent", name+"="+roleId);
	});
	$(document).on("click","#reportSummary h4 a",function(e){
		e.preventDefault();
		var indexId=$("#reportSummary h4 a").index($(this));
		roleId=$(".editableId").eq(indexId).text();
		name=$(".editableId").eq(indexId).attr("id");
		var targetLink=$(this).attr("href");
		isPrefCheck=false;
		if(targetLink!="#")
			changePage(targetLink, ".mainContent", name+"="+roleId);
	});



	$(document).on("click","#report tr.odd",function(){
		$(this).next("tr").toggle(300);
		$(this).find(".arrow").toggleClass("up");
	});
	$(document).on("click","#reportSummary tr.odd",function(){
		$(this).next("tr").toggle(300);
		$(this).find(".arrow").toggleClass("up");
	});

	$(document).on("click",".checkBtnPage",function(){
		checkVal=$(this).find("input[name='selUsrPrefs']:checked").val();
		if(typeof(checkVal)==='undefined'){
			$(this).parent('tr').next('tr').find("input[name='rPref']").attr("checked",false);
			$(this).parent('tr').next('tr').find("input[name='wPref']").attr("checked",false);
			$(this).parent('tr').next('tr').find("input[name='ePref']").attr("checked",false);
		}else{
			$(this).parent('tr').next('tr').find("input[name='rPref']").attr("checked",true);
			$(this).parent('tr').next('tr').find("input[name='wPref']").attr("checked",true);
			$(this).parent('tr').next('tr').find("input[name='ePref']").attr("checked",true);

		}
	});
	$(document).on("click",".rweCls",function(){
		read=$(this).parent("label").parent("div .rightDiv").find("input[name='rPref']:checked").val();
		if(typeof(read)==='undefined'){
			$(this).parents("div .rightDiv").find("input[name='rPref']").parent("label").css('background','#FF0000');
			$(this).parents("tr").prev("tr").find("input[name='selUsrPrefs']").attr("checked",false);
		}
		else{
			$(this).parents("tr").prev("tr").find("input[name='selUsrPrefs']").attr("checked",true);
			$(this).parents("div .rightDiv").find("input[name='rPref']").parent("label").css('background','');
		}
	});
	$(document).on('click','.viewTblRels',function(){
		var btnId=$('.viewTblRels').index(this);
		var btchId=$('.editableId').eq(btnId).text();
		var clsTobeShow=$('.viewTblRels').eq(btnId).attr('name');
		if(clsTobeShow=='btchStds')
			getStdFromBatch(btchId,clsTobeShow,false);
		$('.'+clsTobeShow).eq(btnId).toggle(300);
	});
	
	$(document).on('click','.endSession',function(){
		var btnId=$('.endSession').index(this);
		var paramData=$('.editableId').eq(btnId).text();
		var paramName=$('.editableId').eq(btnId).attr("id");
		var clsTobeShow=$('.endSession').eq(btnId).attr('name');
		$.ajax({
			type: "POST",
			url: clsTobeShow,
			data: paramName+'='+paramData,
			cache: false,
			success: function(msg){
//				alert(msg);
			}
		}).done(function(){
			changePage("nav2InstSessSummary.action", ".mainContent", "isHistory=false");
		});
	});
	$(document).on('click','#endAllSession',function(){
		var clsTobeShow=$('#endAllSession').attr('name');
		$.ajax({
			type: "POST",
			url: clsTobeShow,
			data: "isAllSession=true",
			cache: false,
			success: function(msg){
//				alert(msg);
			}
		}).done(function(){
			changePage("nav2InstSessSummary.action", ".mainContent", "isHistory=false");
		});
	});
	$(document).on('keyup','#stdSearchInput',function(event){
		if(event.keyCode == 13){
			$('#stdSearch').click();
		}
	});
	$(document).on('click','#stdSearch',function(){
		paramNm=$('#stdSearchInput').attr('name');
		paramVal=$('#stdSearchInput').val();
		changePage("nav2SearchStdAdmission.action", ".mainContent", paramNm+"="+paramVal);
	});
	$(document).on('mouseover','.dropdownStdUID',function(){
		indexPos=$('.dropdownStdUID').index($(this));
		var position=$('.dropdownStdUID').eq(indexPos).position();
//		alert(position.left+" "+position.top);
		$(".stdEditNavMenu").css("position","absolute").css("height","200px").css("width","200px")
		.css("background-color","#FCFFD4").css("margin-left","105px").css("margin-top","15px").css("color","#000000")
		.css("top",position.top).css("left",position.left);
		dropDownHtml='<center><table style="background-color:#FCFFD4;">' 
						+"<tr><td><a class='viewProfile' href='nav2externalProfile.action?userUID="+$('.dropdownStdUID').eq(indexPos).text()+"'style='color:#000000;'>"+"<b>View Profile</b></a></td></tr>"
						+"<tr><td>-------------------------------</td></tr>"
						+"<tr><td><a href='nav2UserProfile.action?uid="+$('.dropdownStdUID').eq(indexPos).text()+"'style='color:#000000;'>"+"<b>Change Course</b></a></td></tr>"
						+"<tr><td>-------------------------------</td></tr>"
						+"<tr><td><a href='nav2UserProfile.action?uid="+$('.dropdownStdUID').eq(indexPos).text()+"'style='color:#000000;'>"+"<b>Fee Status</b></a></td></tr>"
						+"<tr><td>-------------------------------</td></tr>"
						+"<tr><td><a href='nav2UserProfile.action?uid="+$('.dropdownStdUID').eq(indexPos).text()+"'style='color:#000000;'>"+"<b>Assign Achievemente</b></a></td></tr>"
					+"</table></center>";
		$(".stdEditNavMenu").html(dropDownHtml);
	});
	$(document).on('focusout','.dropdownStdUID',function(){
		$(".stdEditNavMenu").removeAttr("style");
		$(".stdEditNavMenu").html("");
	});
	$(document).on('click','.viewProfile',function(e){
		e.preventDefault();
		paramArr=$(this).attr("href").split("?");
		changePage(paramArr[0], ".pageContent", paramArr[1]);
	});
	
	$(document).on('submit',"#formSubmit", function(e){
		e.preventDefault();
		var actionName=$(this).attr("action");
		submitUserCreate(actionName,false);
	});
	pageViewSetting();
	$(document).on("click",".profile_tabs div a",function(e){
		e.preventDefault();
		$(".profile_tabs div").removeAttr("id");
		$(".profile_tabs div").removeAttr("style");
		$(this).parent("div").attr("id","current");
		aWidth=$(".profile_tabs #current a").width();
		divWidth=$(".profile_tabs div").width();
		$(".profile_tabs #current").css("width",(1.5*(divWidth+aWidth)));
		ahref=$(this).attr("href");
		if(ahref!='#'){
			changePage(ahref, '.profile_body', "");
		}
	});
	$(document).on("click",".rightDiv a",function(e){
		e.preventDefault();
		ahref=$(this).attr("href");
		objId=$(this).parents("tr").prev("tr").find('.checkBtnPage input').val();
		if(ahref!='#'){
			changeOnlyDiv(ahref, '.editDiv', "objId="+objId);
		}
	});

	$(document).on("click",".slidernext",function(){
		liTab=$("#tabs li").size();
		if(liTab>4){
			lastTab=$("#tabs li").eq(liTab-1).attr("class");
			if(lastTab!='show'){
				$("#tabs .show").eq(0).css('display','none');
				$("#tabs .show").eq(3).next('li').fadeIn();
				$("#tabs .show").eq(3).next('li').addClass("show");
				$('#tabs .show').eq(0).removeClass("show");
			}

		}
	});
	$(document).on("click",".sliderprev",function(){
		liTab=$("#tabs li").size();
		if(liTab>4){
			firstTab=$("#tabs li").eq(0).attr("class");
			if(firstTab!='show'){
				$("#tabs .show").eq(3).css('display','none');
				$("#tabs .show").eq(0).prev('li').fadeIn();		        		
				$('#tabs .show').eq(3).removeClass("show");
				$("#tabs .show").eq(0).prev('li').addClass("show");
			}
		}

	});

	$(document).on('change','.feeSettingFilter #combobox1',function(){
		val=this.value;
		actionName=$('.feeSettingFilter #combobox1').parent('div').attr('id');
		param=$('#combobox1').attr('name');
//		alert(val+" "+actionName+" "+param);
		changePage("fee/nav2FeeSettingOption.action", ".filterContent", param+"="+val);
	});
	$(document).on('change','.summaryFilter #combobox1',function(){
		val=this.value;
		actionName=$('.summaryFilter #combobox1').parent('div').attr('id');
		param=$('#combobox1').attr('name');
		changePage(actionName, ".mainContent", param+"="+val);
	});
	$(document).on('change','input[name="isCrsHistory"]',function(){
		val=$('input[name="isCrsHistory"]:radio:checked').val();
		changePage("nav2InstResultView.action", ".mainContent", "isCrsHistory="+val);
	});
	$(document).on('change','.pageChangeOnOption',function(){
		clsIndex=$('.pageChangeOnOption').index($(this));
		actionName=$('.pageChangeOnOption').eq(clsIndex).attr("id")+".action";
		paramName=$('.pageChangeOnOption').eq(clsIndex).attr("name")
		paramVal=this.value;
		$.ajax({
			type: "POST",
			url: "getBtchNSessFromCourse.action",
			data: paramName+'='+paramVal,
			cache: false,
			success: function(msg){
				var crsSess2Html="";
				$.each(msg.instSessInfoList,function(i,v){
					crsSess2Html=crsSess2Html+"<option value="+v.instSessInfoId+">"+v.name+"</option>\n";
				});
				var crsBatch2Html="<option value='-1'>All</option>\n";
				$.each(msg.batchInfoList,function(i,v){
					crsBatch2Html=crsBatch2Html+"<option value="+v.batchId+">"+v.batchName+"</option>\n";
				});
				if(clsIndex==0){
					$('.pageChangeOnOption').eq(1).html(crsSess2Html);
					$('.pageChangeOnOption').eq(2).html(crsBatch2Html);
				}
			}
		});
		changePage(actionName, ".resultviewpanel", paramName+'='+paramVal);
	});
	$(document).on("change","#crsStd1",function(){
		crsId=this.value;
		if(this.value!=-1){
			$.ajax({
				type: "POST",
				url: "getStdFromCourse.action",
				data: 'crsInfoId='+crsId,
				cache: false,
				success: function(msg){
					var crsStd2Html="";
					$.each(msg.stdInfoList,function(i,v){
						crsStd2Html=crsStd2Html+"<option value="+v.stdId+">"+v.firstName+" "+v.lastName+"</option>\n";
					});
					$("#crsStd2").html(crsStd2Html);
				}
			});
		}
	});
	$(document).on("change","#crsBtch1",function(){
//		alert(this.value);
		crsId=this.value;
		
		if(this.value!=-1){
			
			$.ajax({
				type: "POST",
				url: "fee/getBtchFromCourse.action",
				data: 'crsInfoId='+crsId,
				cache: false,
				success: function(msg){
					var crsBtch2Html="";
					$.each(msg.batchInfoList,function(i,v){
						crsBtch2Html=crsBtch2Html+"<option value="+v.batchId+">"+v.batchName+"</option>\n";
					});
					$("#crsBtch2").html(crsBtch2Html);
					if(msg.batchInfoList.length==0)
						$("#crsBtch2").html("<option value=-1>Select</option>");					
				}
			});
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
			if($("#subexam1").html()!=null){
				$.ajax({
					type: "POST",
					url: "getSubFromCourse.action",
					data: 'courseId='+crsId,
					cache: false,
					success: function(msg){
						var crsBtch2Html="";
						$.each(msg.subInfoList,function(i,v){
							crsBtch2Html=crsBtch2Html+"<option value="+v.subjectId+">"+v.subName+"</option>\n";
						});
						$("#subexam1").html(crsBtch2Html);
						if(msg.subInfoList.length==0)
							$("#subexam1").html("<option value=-1>Select</option>");					
					}
				});
			}
			
			
		}
	});
	$(document).on("change","#sessBatch",function(){
		if(this.value!=-1){
			fetchSess=$(this).parent(".ui-widget").find("input[name='sessFetchTyp']").val();
			param='instSessId='+this.value;
			if(typeof(fetchSess)!='undefined')
				param=param+"&&sessFetchTyp="+fetchSess;
			$.ajax({
				type: "POST",
				url: "getbtchFromSess.action",
				data: param,
				cache: false,
				success: function(msg){
					var crsBtch2Html="";
					$.each(msg.batchInfoList,function(i,v){
						crsBtch2Html=crsBtch2Html+"<option value="+v.batchId+">"+v.batchName+"</option>\n";
					});
					$("#crsBtch2").html(crsBtch2Html);
					if(msg.batchInfoList.length==0)
						$("#crsBtch2").html("<option value=-1>Select</option>");					
				}
			});
		}
	});
	$(document).on('change','#btchStd',function(){
		crsName=$("#crsBtch1").attr("name");
		crsId=$("#crsBtch1").val();
		sessName=$("#sessBatch").attr("name");
		sessId=$("#sessBatch").val();
		btchName=$("#crsBtch2").attr("name");
		btchId=$("#crsBtch2").val();
		stdName=$("#btchStd").attr("name");
		stdId=$("#btchStd").val();
		if(crsId!=null&&crsId>-1&&sessId!=null&&sessId>-1&&btchId!=null&&btchId>-1&&stdId!=null&&stdId>-1){
			param=crsName+"="+crsId+"&&"+sessName+"="+sessId+"&&"+btchName+"="+btchId+"&&"+stdName+"="+stdId;
			changePage("getInstStdMarksfromSess.action", ".resultviewpanel", param);
		}else{
			alert("Some fileds are not selected please select the fields");
		}
	});
	$(document).on("click",".marksUpdate",function(e){
		e.preventDefault();
		fullParam=$(this).attr("href");
		paramArr=fullParam.split("?");
		href=paramArr[0];
		param=paramArr[1];
		changePage(href, ".mainContent", param);
	});
	$(document).on("change","#crsBtch2",function(){
		btchId=this.value;
		
		viewType=$(this).parent(".ui-widget").find("input[name='viewType']").val();
		if(viewType=='html'){
			$.ajax({
				type: "POST",
				url: "getInstStdFromBatch.action",
				data: 'btchInfoId='+btchId+"&&viewType="+viewType,
				cache: false,
				success: function(msg){
					if(typeof(msg)!=null&&msg!=null)
						$(".resultviewpanel").html(msg);
				}
			});
		}			
		else
			getStdFromBatch(btchId,'#btchStd',true);
		/*if(this.value!=-1){
			$.ajax({
				type: "POST",
				url: "getStdFromBtch.action",
				data: 'btchInfoId='+btchId,
				cache: false,
				success: function(msg){
					var crsStd2Html="";
					$.each(msg.stdInfoList,function(i,v){
						crsStd2Html=crsStd2Html+"<option value="+v.stdId+">"+v.stdId+" "+v.firstName+" "+v.lastName+"</option>\n";
					});
					$("#btchStd").html(crsStd2Html);
					if(msg.stdInfoList.length==0)
						$("#btchStd").html("<option value=-1>Select</option>");
				}
			});
		}*/
	});
	$(document).on("change","#subexam1",function(){
		subId=this.value;
		paramVl=$(this).parent(".ui-widget").find("input[name='fetchReq']").val();
		if(this.value!=-1){
			$.ajax({
				type: "POST",
				url: "getExamFromSub.action",
				data: 'subId='+subId+"&&fetchReq="+paramVl,
				cache: false,
				success: function(msg){
					var chnghtml="";
					if(typeof(msg.examInfoList)!='undefined'){
						$.each(msg.examInfoList,function(i,v){
							chnghtml=chnghtml+"<option value="+v.examId+">"+v.examName+" "+v.examDate+"</option>\n";
						});
						$("#subexam2").html(chnghtml);
						if(msg.examInfoList.length==0)
							$("#subexam2").html("<option value=-1>Select</option>");
					}
				}
			});
		}
	});
	$(document).on("change","#stdInst",function(){
//		alert(this.value);
		instAdminId=this.value;
		userUIDNm=$("#usrUID").attr("name");
		userUID=$("#usrUID").val();
		if(typeof(userUID)!='undefined'&&userUID!=null)
			param='instAdminId='+instAdminId+"&&"+userUIDNm+"="+userUID;
		else
			param='instAdminId='+instAdminId;
		
		if(this.value!=-1){
			$.ajax({
				type: "POST",
				url: "getCoursesFromInst.action",
				data: param,
				cache: false,
				success: function(msg){
					var crsStd2Html="";
					$.each(msg.courseInfoList,function(i,v){
						crsStd2Html=crsStd2Html+"<option value="+v.courseId+">"+v.courseName+"</option>\n";
					});
					$("#instCrs").html(crsStd2Html);
				}
			});
		}
	});
	$( document ).on(".altColorTab tr>odd").css('background','#3d3d3d');
	$(document).on('change','#crsExm',function(){
		val=$('#crsExm').val();
		paramNm=$('#crsExm').attr('name');
		$.ajax({
			type: "POST",
			url: "getExmTypFromCourse.action",
			data: paramNm+"="+val,
			cache: false,
			success: function(msg){
				if(typeof(msg.examtypeList)!='undefined'&&msg.examtypeList!=null){
					
					var crsExmTypHtml="";
					$.each(msg.examtypeList,function(i,v){
						crsExmTypHtml=crsExmTypHtml+"<option value="+v.examTypeId+">"+v.examTypeName+"</option>\n";
					});
					$('#exmTypSub').html(crsExmTypHtml);
				}
			}
		});		
	});
	$(document).on('change','#crsexmInfo',function(){
		courseId=this.value;
		$.ajax({
			type: "POST",
			url: "getExmNSessFromCourse.action",
			data: "courseId="+courseId,
			cache: false,
			success: function(msg){
				if(typeof(msg.examInfoList)!='undefined'&&msg.examInfoList!=null){					
					var crsExmInfoHtml="";
					$.each(msg.examInfoList,function(i,v){
						crsExmInfoHtml=crsExmInfoHtml+"<option value="+v.examId+">"+v.examName+"</option>\n";
					});
					if(typeof($('#mulSelCombo1').val())!='undefined')
						$('#mulSelCombo1').html(crsExmInfoHtml);					
					
				}
				
				if(typeof(msg.batchInfoList)!='undefined'&&msg.batchInfoList!=null){					
					var crsSessHtml="";
					$.each(msg.batchInfoList,function(i,v){
						crsSessHtml=crsSessHtml+"<option value="+v.batchId+">"+v.batchName+"</option>\n";
					});
					$('#mulSelCombo2').html(crsSessHtml);
				}
			}
		});		
	});
	$(document).on('change','#exmTypSub',function(){
		val=$('#exmTypSub').val();
		paramNm=$('#exmTypSub').attr('name');
		$.ajax({
			type: "POST",
			url: "getSubFromExmTyp.action",
			data: paramNm+"="+val,
			cache: false,
			success: function(msg){
				if(typeof(msg.subjectInfoList)!='undefined'&&msg.subjectInfoList!=null){
					var subExmTypHtml="";
					$.each(msg.subjectInfoList,function(i,v){
						subExmTypHtml=subExmTypHtml+"<option value="+v.subjectId+">"+v.subName+"</option>\n";
					});
					$('#subExm').html(subExmTypHtml);
				}
			}
		});		
	});
	$(document).on('change','#crsInstSess',function(){
		instSessId=this.value;
		courseId=$('#instCrs').val();
		userUIDNm=$("#usrUID").attr("name");
		userUID=$("#usrUID").val();
		if(typeof(userUID)!='undefined'&&userUID!=null)
			param='instSessId='+instSessId+"&&courseId="+courseId+"&&"+userUIDNm+"="+userUID;
		else
			param='instSessId='+instSessId+"&&courseId="+courseId;
		changePage("getStdMarksfromSess.action", ".resultviewpanel", param);
	});
	$(document).on("change","#instCrs",function(){
//		alert(this.value);
		courseId=this.value;
		userUIDNm=$("#usrUID").attr("name");
		userUID=$("#usrUID").val();
		if(typeof(userUID)!='undefined'&&userUID!=null)
			param='courseId='+courseId+"&&"+userUIDNm+"="+userUID;
		if(this.value!=-1){
			$.ajax({
				type: "POST",
				url: "getInstSessFromCourse.action",
				data: param,
				cache: false,
				success: function(msg){
					if(typeof(msg.instSessList)!='undefined'){
						var instSessHtml="";
						$.each(msg.instSessList,function(i,v){
							instSessHtml=instSessHtml+"<option value="+v.instSessInfoId+">"+v.name+"</option>\n";
						});
						$('#crsInstSess').html(instSessHtml);
					}
				}
			});
			changePage("getStdMarksheet.action", ".resultviewpanel", param);
			
			/*
			$.ajax({
				type: "POST",
				url: "getsubExmTypeFromCourse.action",
				data: 'courseId='+courseId,
				cache: false,
				success: function(msg){
//					alert(msg);
					var crsStd2Html="";
//					$.each(msg.subjectInfoList,function(i,v){
//						crsStd2Html=crsStd2Html+"<option value="+v.subjectId+">"+v.subName+"</option>\n";
//					});
//					$("#subexamMarks1").html(crsStd2Html);
					crsStd2Html2="";
					msHeaderFrame="";
					$.each(msg.examTypeList,function(i,v){
//						crsStd2Html2=crsStd2Html2+"<option value="+v.examTypeId+">"+v.examTypeName+"</option>\n";
						msHeaderFrame=msHeaderFrame+"<th>"+v.examTypeName+"</th>";
					});
//					$("#subexamMarks2").html(crsStd2Html2);
					mrksTbl="";
					for(i=0;i<msg.subjectInfoList.length;i++){
						mrksTbl=mrksTbl+"<tr><td>"+msg.subjectInfoList[i].subName+"</td>";
						var marksInfo=[msg.marksInfoList.length];
						subMarksIdx=0;
						for(k=0;k<msg.marksInfoList.length;k++){
							if(msg.marksInfoList[k].examInfo.subjectInfo.subjectId==msg.subjectInfoList[i].subjectId){
								marksInfo[subMarksIdx]=msg.marksInfoList[k];
								subMarksIdx++;
							}
						}
						for(j=0;j<msg.examTypeList.length;j++){
							isSkip=true;
							for(x=0;x<marksInfo.length;x++){
								
								if(typeof(marksInfo[x].examInfo)!='undefined'){
									alert(marksInfo[x].examInfo.examType.examTypeId+" "+msg.examTypeList[j].examTypeId);	
									if(marksInfo[x].examInfo.examType.examTypeId==msg.examTypeList[j].examTypeId){
										alert(marksInfo[x].marksObtained);
										mrksTbl=mrksTbl+"<td>"+marksInfo[x].marksObtained+"</td>";
										isSkip=false;
									}
								}
							}
							if(isSkip)
								mrksTbl=mrksTbl+"<td></td>";
						}
						mrksTbl=mrksTbl+"</tr>";
					}
					mrksTblHtml="<tr><th>Subjects</th>"+msHeaderFrame+"</tr>"+mrksTbl;
//					alert(mrksTblHtml);
					$('.marksheetview').html(mrksTblHtml);
				}
			});
		*/}
	});

});

function getStdFromBatch(btchId,btchStd,ifSelect){
	
	if(this.value!=-1){
		$.ajax({
			type: "POST",
			url: "getStdFromBtch.action",
			data: 'btchInfoId='+btchId,
			cache: false,
			success: function(msg){
				if(ifSelect==true){
					var crsStd2Html="";
					if(typeof(msg.stdInfoList)!='undefined'){
						$.each(msg.stdInfoList,function(i,v){
							crsStd2Html=crsStd2Html+"<option value="+v.stdId+">"+v.stdId+" "+v.firstName+" "+v.lastName+"</option>\n";
						});
						$(btchStd).html(crsStd2Html);
						if(msg.stdInfoList.length==0)
							$(btchStd).html("<option value=-1>Select</option>");
					}
				}else{
					var crsStd2Html="";
					$.each(msg.stdInfoList,function(i,v){
						crsStd2Html=crsStd2Html+"<a href='' id="+v.stdId+">"+v.stdId+" "+v.firstName+" "+v.lastName+"</a><br>\n";
					});
					$(btchStd).html(crsStd2Html);
					if(msg.stdInfoList.length==0)
						$(btchStd).html("No Student found");
				}
			}
		});
	}
}

var selUsrPrefs=[];
function limitText(limitField, limitNum) {
	var desSize=$(limitField).size();
	for(i=0;i<desSize;i++){
		if ($(limitField).eq(i).html()!=null&&$(limitField).eq(i).html().length > limitNum) {
			$(limitField).eq(i).html($(limitField).eq(i).html().substring(0, limitNum)+"...");
		} 
	}
}

function createUpdatecrInfo(submitAction,isUpdate,isRedirect){
	paramList=getFormData(submitAction);
	isValidate=instCreateValidation();
	if(isValidate==true){		
		submitAndValidate(submitAction,paramList,isRedirect,isUpdate);
	}
}

function createUpdateBasicMod(submitAction,isUpdate,isRedirect,switchName){
	paramList=getFormData(submitAction);
	isValidate=validateSwitch(switchName);
	if(isValidate==true){		
		submitAndValidate(submitAction,paramList,isRedirect,isUpdate);
	}
		
}
function pageUpdater(submitAction){
	switch(submitAction){
	case 'subjectAction.action':
		changePage('nav2Subjects.action', ".mainContent", "");
		break;
	}
}
submitResult=false;
function submitAndValidate(submitAction,paramList,isRedirect,isUpdate){
	$.ajax({
		type: "POST",
		url: submitAction,
		data: paramList,
		cache: false,
		success: function(msg){
				if(typeof(msg.errMsgTrans)!='undefined'&&msg.errMsgTrans.isErrorIn){
					$.each(msg.errMsgTrans.errMsg,function(i,v){
						$("[name='"+i+"']").parents("td").next("td").find("span").html('&nbsp;&nbsp;<img src="images/small_down_thumb.jpg">&nbsp;&nbsp;'+v);
						$("[name='"+i+"']").parents("td").next("td").find("span").css('color','#C62D2D');
					});
					submitResult=false;
				}else if(isRedirect){
					var doc=document.open("text/html","replace");
					doc.write(msg);
					doc.close();
	//				$(document).val(msg);
				}else{
					$(".submitStatusBar").html("<center>Successfully submited</center>");
					$(".submitStatusBar").fadeIn();
					window.setTimeout(function(){
						$(".submitStatusBar").fadeOut();
					},3000);
					pageUpdater(submitAction);
					if(isUpdate==true)
						cancelSubmit();
				}
				
			}
	});
}

function getFormData(submitAction){
	$("form").submit(function () { return false; });
	var paramList="";
	for(i=0;i<$(".mainContent input").size();i++){
		var inputName=$(".mainContent input").eq(i).attr("name");
		if(typeof(inputName)!='undefined'){
			var type=$(".mainContent input").eq(i).attr("type");
			if(type=='radio'){
				value=$('input[name="'+inputName+'"]:radio:checked').val();
				radioSize=$('input[name="'+inputName+'"]:radio').size();
				i=i+(radioSize-1);
				if(typeof(value)!='undefined'&&value!=null&&value!=""){
					paramList=paramList+(paramList==""?inputName+"="+value:"&"+inputName+"="+value);
				}
			}else{
				var value=$(".mainContent input").eq(i).val();
				if(typeof(value)!='undefined'&&value!=null&&value!="")
					paramList=paramList+(paramList.trim()==""?inputName+"="+value:"&"+inputName+"="+value);
			}
		}
	}

	for(i=0;i<$(".mainContent select").size();i++){
		var intRegex = /^\d+$/;
		var inputName=$(".mainContent select").eq(i).attr("name");
		var value=$(".mainContent select").eq(i).val();
		var isMultiple=$(".mainContent select").eq(i).attr("multiple");

		if(typeof(isMultiple)==='undefined'){
			if(typeof(inputName)!='undefined'&&(typeof(value)!='undefined'||value!=null)&&(intRegex.test(value)?(value>=0):true)){
				paramList=paramList+(paramList==""?inputName+"="+value:"&"+inputName+"="+value);
			}
		}else if(isMultiple=='multiple'){			
			if(typeof(inputName)!='undefined'&&(typeof(value)!='undefined'&&value!=null)){
				$.each(value,function(i,v){
					paramList=paramList+(paramList==""?inputName+"="+v:"&"+inputName+"="+v);
				});
			}
		}
	}

	for(i=0;i<$(".mainContent textarea").size();i++){
		var inputName=$(".mainContent textarea").eq(i).attr("name");
		var value=$(".mainContent textarea").eq(i).val();
		if(typeof(inputName)!='undefined'&&(typeof(value)!='undefined'||value!=null)){
			paramList=paramList+(paramList==""?inputName+"="+value:"&"+inputName+"="+value);
		}
	}
	return paramList;
}

function submitUserCreate(submitAction,isUpdate){

	$("form").submit(function () { return false; });
	var paramList="";
	for(i=0;i<$(".mainContent input").size();i++){
		var inputName=$(".mainContent input").eq(i).attr("name");
		if(typeof(inputName)!='undefined'){
			var type=$(".mainContent input").eq(i).attr("type");
			if(type=='radio'){
				value=$('input[name='+inputName+']:radio:checked').val();
				radioSize=$('input[name='+inputName+']:radio').size();
				i=i+(radioSize-1);
				if(typeof(value)!='undefined'&&value!=null&&value!=""){
					paramList=paramList+(paramList==""?inputName+"="+value:"&"+inputName+"="+value);
				}
			}else{
				var value=$(".mainContent input").eq(i).val();
				if(typeof(value)!='undefined'&&value!=null&&value!="")
					paramList=paramList+(paramList.trim()==""?inputName+"="+value:"&"+inputName+"="+value);
			}
		}
	}

	for(i=0;i<$(".mainContent select").size();i++){
		var intRegex = /^\d+$/;
		var inputName=$(".mainContent select").eq(i).attr("name");
		var value=$(".mainContent select").eq(i).val();
		var isMultiple=$(".mainContent select").eq(i).attr("multiple");

		if(typeof(isMultiple)==='undefined'){
			if(typeof(inputName)!='undefined'&&(typeof(value)!='undefined'||value!=null)&&(intRegex.test(value)?(value>=0):true)){
				paramList=paramList+(paramList==""?inputName+"="+value:"&"+inputName+"="+value);
			}
		}else if(isMultiple=='multiple'){			
			if(typeof(inputName)!='undefined'&&(typeof(value)!='undefined'&&value!=null)){
				$.each(value,function(i,v){
					paramList=paramList+(paramList==""?inputName+"="+v:"&"+inputName+"="+v);
				});
			}
		}
	}

	for(i=0;i<$(".mainContent textarea").size();i++){
		var inputName=$(".mainContent textarea").eq(i).attr("name");
		var value=$(".mainContent textarea").eq(i).val();
		if(typeof(inputName)!='undefined'&&(typeof(value)!='undefined'||value!=null)){
			paramList=paramList+(paramList==""?inputName+"="+value:"&"+inputName+"="+value);
		}
	}
//	alert(paramList);
	formSubmit(submitAction, paramList);
	if(isUpdate==true)
		cancelSubmit();
	/* $(".submitStatusBar").html("<center>Successfully submited</center>");
	  $(".submitStatusBar").fadeIn();
	  window.setTimeout(function(){
		  $(".submitStatusBar").fadeOut();
	  },2000);*/
}
function cancelSubmit(){
	$("form").submit(function () { return false; });
	var hrefAction=$("#tabs #current").attr("href");
	changePage(hrefAction, ".mainContent", "");
}
function formSubmit(actionName,formData){
	$.ajax({
		type: "POST",
		url: actionName,
		data: formData,
		cache: false,
		success: function(msg){
			$(".submitStatusBar").html("<center>Successfully submited</center>");
			$(".submitStatusBar").fadeIn();
			window.setTimeout(function(){
				$(".submitStatusBar").fadeOut();
			},3000);
		}
	});
}
/*function SelUsrPref(pageId,read,write,edit){
	this.pageId=pageId;
	this.read=read;
	this.write=write;
	this.edit=edit;
	this.getId=function(){
		return pageId;
	};
	this.getComboData=function(){
		var data="selUsrPrefs="+pageId+"~"+read+(typeof(write)==='undefined'?"":"~"+write)+(typeof(edit)==='undefined'?"":"~"+edit);
		return data;
	};
}*/
function changeOnlyDiv(targetLink,contentCls,reqData){
	$.ajax({
		type: "POST",
		url: targetLink,
		data:reqData,
		cache: false,
		success: function(msg){
			if(typeof(msg)=='object')
				alert(msg.msgCode+" "+msg.msgDescription);
			else
				$(contentCls).html(msg);
		}
	}).done(function() {
		pageViewSetting();
		tabAdjPageContent();
	});
}

function changePage(targetLink,contentCls,reqData){
	$.ajax({
		type: "POST",
		url: targetLink,
		data: reqData,
		cache: false,
		success: function(msg){
			if(typeof(msg)=='object'){
				alert(msg.msgCode+" "+msg.msgDescription);
			}else
				$(contentCls).html(msg);
		}
	}).done(function() {
		pageViewSetting();
		tabAdjPageContent();
	});
}
function showFirstTab(actionName){
	changePage(actionName, ".mainContent", "");
}
function showSumUsers(){
	var getid = $('.viewUsers').index($(this));
	alert(getid);
}
function roleSubmit(submitFor){
	var fullParam="";
	var roleId=$("input[name='usrRole.usrRoleId']").val();
	if(submitFor==2){
		fullParam=fullParam+(((typeof(roleId)==='undefined')||(roleId.trim()==""))?"usrRole.usrRoleId=":("usrRole.usrRoleId="+roleId+"&"));
	}
	var rolName=$("input[name='usrRole.roleName']").val();
	fullParam=fullParam+((rolName.trim()=="")?"usrRole.roleName=":("usrRole.roleName="+rolName));
	var description=$("textarea[name='usrRole.roleDescription']").val();
	fullParam=fullParam+((description.trim()=="")?"usrRole.roleDescription=":("&usrRole.roleDescription="+description));
	checkBtns=$(".checkBtnPage").find("input[name='selUsrPrefs']:checked");
	var checkedSize=checkBtns.size();
	for(i=0;i<checkedSize;i++){
		paramStr="selUsrPrefs=";
		paramStr=paramStr+checkBtns.eq(i).val();
		rweCheck=$(".checkBtnPage").find("input[name='selUsrPrefs']:checked").eq(i).parents("tr").next("tr").find(".rweCls").parent("label").find("input[class='rweCls']:checked");
		for(j=0;j<rweCheck.size();j++){
			paramStr=paramStr+"~"+rweCheck.eq(j).val();	
		}
		fullParam=fullParam+((fullParam=="")?paramStr:("&"+paramStr));
	}

	if(submitFor==1)
		formSubmit("userRoleAction.action", fullParam);
	else if(submitFor==2){
		formSubmit("roleUpdateAction.action", fullParam);
		cancelSubmit();
	}
}



var isPrefCheck=true;
function pageViewSetting(){
	limitText(".description", 12);
	$( ".anim_paginationTable tr:odd" ).css('background','#e6ebee');
	$("#report tr:odd").addClass("odd");
	$("#report tr:not(.odd)").hide();
	$("#report tr:first-child").show();

	$("#reportSummary tr:odd").addClass("odd");
	$("#reportSummary tr:not(.odd)").hide();
	$("#reportSummary tr:first-child").show();
	if(isPrefCheck){
		$(".checkBtnPage").find("input[name='selUsrPrefs']").attr("checked",false);
		$(".rweCls").attr("checked",false);
	}
	$( "input:submit").button();
	isPrefCheck=true;
}
function tabAdjPageContent(){
	liSize=$("#tabs li").size();
	showSize=$("#tabs .show").size();
	if(liSize>4&&showSize==0){
		for(i=4;i<liSize;i++){
			$("#tabs li").eq(i).css('display','none');
		}
		for(j=0;j<4;j++){
			$("#tabs li").eq(j).addClass("show");
		}
		if($("#sliderPrev").size()==0)
			$("#tabs").after('<div class="icons sliderprev" style="top:20px;left:450px" id="sliderPrev"></div><div class="icons slidernext" style="top:20px;left:1350px"  id="sliderNext"></div>');
	}

}
function clearForm(targetLink){
	$("form").submit(function () { return false; });
	changePage(targetLink, ".mainContent", "");
}



