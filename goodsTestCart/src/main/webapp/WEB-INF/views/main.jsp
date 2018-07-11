<%@page import="org.springframework.web.filter.CharacterEncodingFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.item{
		border: solid 2px pink;
		float: left;
		margin: 10px;
	}
	
	#prev,#next{
		float: left;
		margin: 100px;
	}
	
	#cart,#br{
		display: block;
	}
	
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		//장바구니에 담을 객체를 저장할 배열
		//비어있는 배열로 만듬
		var cart_arr = [];
		
		//최초에 Ajax통신을 하여 모든 상품을 담아둘 배열
		var arr;
		
		//한화면에 보여줄 상품의 수를 4개로 설정
		var pageSIZE = 4;
		
		//전체레코드(상품)의 수를 담기 위한 변수
		var totalRecord = 1;
		
		//전체페이지수를 담기 위한 변수
		var totalPage = 1;
		
		//현재페이지를 담을 변수
		var currentPage = 1;
		
		//다음페이지를 보여주기 위한 이벤트 처리
		$("#next").click(function(){
			currentPage = currentPage + 1;
			makeNode();
		});
		
		//이전페이지를 보여주기 위한 이벤트 처리
		$("#prev").click(function(){
			currentPage = currentPage - 1;
			makeNode();
		});
		
		//장바구니에서 상품을 삭제하기 위한 함수
		//매개변수로 상품번호를 전달받아 해당상품을 cart에서 제거한다.
		var delCart = function(no)
		{	
			var sel_arr = $("#cart").find(".cart_item");
			$.each(sel_arr,function(i,c){
				var cno = $(c).attr("no");
				if(cno == no )
				{
					$(c).remove();
					return;
				}
			});
			
		}
		
		
		//Ajax통신하여 서버로 부터 모든 상품의 목록이 읽어와
		//배열 arr에 담고
		//전체레코드수와 전체페이지를 계산하고
		//현재페이지(1페이지)에 보여줄 상품노드를 생성하여 보여준다.
		var listGoods = function()
		{
			$.ajax("listGoods.do",{success:function(data){
				arr = eval("("+data+")");				
				totalRecord = arr.length;				
				totalPage = Math.ceil(totalRecord / pageSIZE);	
				makeNode();
			}});
			
		}
		
		//카트에 담길 상품의 인덱스를 증가시키기 위한 변수
		var i = 0;
		
		
		//현재페에이지에 보여줄 
		//상품의 노드를 생성한다.
		var makeNode = function()
		{	
			$("#prev").show();
			$("#next").show();
			
			if(currentPage <= 1)
			{
				$("#prev").hide();
			}
			
			if(currentPage >= totalPage)
			{
				$("#next").hide();
			}
			
			
			$("#list").empty();
			var start = (currentPage - 1) * pageSIZE;	
			//alert("시작위치:"+start)
			var arr2 = arr.slice(start, start+pageSIZE);
			
			$.each(arr2, function(idx,g){
				var d = $("<div></div>");
				$(d).addClass("cart_item")
				$(d).attr("no",g.no);
				var chk = $("<input>").attr("type","checkbox");
			
				
				$(chk).change(function(){
					var c = $(this).attr("checked");
					if(c == "checked")
					{	
						var cd = $(d).clone();
						$(cd).find(".qty").attr("name","items["+i+"].qty");
						$(cd).find(".no").attr("name","items["+i+"].no");
						
						var total = eval($("#total").val());
						$("#total").val( total + eval( $(cd).find(".price").html())*eval( $(cd).find(".qty").val()));
						
						$("#cart").append(cd);
						i++;
					}
					else
					{
						var pd = $(this).parent();
						var no =$(pd).attr("no");
						delCart(no);
					}
				});
					
				
				$(d).append(chk);
				$("<br/>").appendTo(d);
				
				$(d).addClass("item");
				var img = $("<img></img>").attr({
					src:"resources/img/"+g.fname,
					width:"200",
					height:"200"
				});
				$(d).append(img);
				$("<p></p>").html(g.item).appendTo(d);
				$("<p class='price'></p>").html(g.price).appendTo(d);
				var p_qty = $("<p></p>");
				var input_qty = $("<input class='qty' type='number' value='1'>");
				var span_qty = $("<span></span>").html("("+ g.qty +")");
				$(p_qty).append(input_qty,span_qty);
				$(d).append(p_qty);
				
				$("<input class='no' type='number'>").val(g.no).appendTo(d);
				
				//$("<p></p>").html(g.qty).appendTo(d);
				$("#list").append(d);				
			});
		}
		
		listGoods();
	});
</script>
</head>
<body>	
	
	<div id="prev"><img src="resources/img/prev.png"></div>
	<div id="list"></div>
	<div id="next"><img src="resources/img/next.png"></div>
	<br>
	<br>
	<div id="br"></div>
	<hr>
	<h4>장바구니</h4>
	<form action="insertOrder.do" method="post">
		<div id="cart"></div>
		아이디 : <input type="text" name="id" value="seng"><br>
		배송지 : <input type="text" name="addr"><br>
		총구매금액 : <input type="text" name="total" id="total" value="0"><br>
		<input type="submit" value="주문">
	</form>
	
	<%
		//CharacterEncodingFilter
	%>
</body>
</html>












