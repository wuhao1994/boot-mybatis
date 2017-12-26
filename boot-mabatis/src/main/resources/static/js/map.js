// 百度地图API功能
    var localpoint ;
    var endpoint ;
	var map = new BMap.Map("l-map");
	var point = new BMap.Point(116.331398,39.897445);
	map.centerAndZoom(point,16);                   // 初始化地图,设置城市和地图级别。
	var geolocation = new BMap.Geolocation();
	//获取当前位置并将地图显示为当前
	geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
			var mk = new BMap.Marker(r.point);
			map.addOverlay(mk);
			map.panTo(r.point);
			localpoint = r.point;
			console.log(r.point.lng+','+r.point.lat);
		}
		else {
			alert('failed'+this.getStatus());
		}        
	},{enableHighAccuracy: true})

	function G(id) {
		return document.getElementById(id);
	}
	var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "suggestId"
		,"location" : map
	});

	ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
		
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		G("searchResultPanel").innerHTML = str;
	});

	var myValue;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		setPlace();
	});

	function setPlace(){
		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(){
			endpoint = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
			map.centerAndZoom(endpoint, 18);
			console.log(endpoint.lng+'--'+endpoint.lat)
			map.addOverlay(new BMap.Marker(endpoint));    //添加标注
			var i=$("#driving_way select").val();
			//DrivingRoute路线      panel 驾车路线文字结果  policy 路线方式（最短 最快 等）
			var driving = new BMap.DrivingRoute(map, {renderOptions: {map: map, panel: "r-result", autoViewport: true},policy: i});
			//导航当前地址到目标地址的驾车路线
			driving.search(localpoint,endpoint);
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
		  onSearchComplete: myFun
		});
		local.search(myValue);
	}
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	$("#result").click(function(){
		setPlace();
	});
	
//优化方向  1.搜索栏悬浮2.（可以选择起始点，结束点，目前起始点默认本地 选择目标点）	选择目标地址后弹窗公交步行驾车骑行（驾车已实现）3.不同的推荐路线（最快最短不走高速等）4.导航的实景