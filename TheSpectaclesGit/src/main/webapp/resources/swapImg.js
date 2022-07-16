$(document).ready(function carousel() {
	function onImg()
	{ 
		var img1=<%=bean.getImage()%>
		var img2=<%=bean.getImage2()%>
		this.setAttribute("src","images/shop/products/"+img2);
	}
	function outImg()
	{
		var img1=<%=bean.getImage()%>
		var img2=<%=bean.getImage2()%>
		this.setAttribute("src","images/shop/products/"+img1);
	}
})