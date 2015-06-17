<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html lang="en">
<head>
<style type="text/css">
h2{
  background-image: linear-gradient(top, #f1f3f3, #d4dae0);  
  box-sizing: border-box;
  color: #FF0000;
  display: block;
  height: 20px;
  font: 600 14px/1 'Open Sans', sans-serif;
  padding-top: 14px;
  margin: 0;
  text-align: center;
  text-shadow: 0 -1px 0 rgba(0,0,0,0.2), 0 1px 0 #fff;
}
input[type="submit"] {
  width:240px;
  height:35px;
  display:block;
  font-family:Arial, "Helvetica", sans-serif;
  font-size:16px;
  font-weight:bold;
  color:#fff;
  text-decoration:none;
  text-transform:uppercase;
  text-align:center;
  text-shadow:1px 1px 0px #37a69b;
  padding-top:6px;
  margin: 29px 0 0 29px;
  position:relative;
  cursor:pointer;
  border: none;  
  background-color: #37a69b;
  background-image: linear-gradient(top,#3db0a6,#3111);
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
  border-bottom-left-radius:5px;
  box-shadow: inset 0px 1px 0px #2ab7ec, 0px 5px 0px 0px #497a78, 0px 10px 5px #999;
}
.shadow {
  background: #000;
  border-radius: 12px 12px 4px 4px;
  box-shadow: 0 0 20px 10px #000;
  height: 12px;
  margin: 30px auto;
  opacity: 0.2;
  width: 270px;
}
input[type="submit"]:active {
  top:3px;
  box-shadow: inset 0px 1px 0px #2ab7ec, 0px 2px 0px 0px #31524d, 0px 5px 3px #999;
}

.myButton {
  height: 257px;
  margin: 20px auto 0;
  width: 298px;
}

.myButton h1 {
  background-image: linear-gradient(top, #f1f3f3, #d4dae0);
  box-sizing: border-box;
  color: #727678;
  display: block;
  height: 20px;
  font: 600 14px/1 'Open Sans', sans-serif;
  padding-top: 14px;
  margin: 0;
  text-align: center;
  text-shadow: 0 -1px 0 rgba(0,0,0,0.2), 0 1px 0 #fff;
}
</style>
<title>Home</title>
</head>
<body>
	<div class="myButton">
		<form action="/newCustomer" method="post">  
				<h1>Add a new Cutomer</h1>
				<input type="submit" value="Add Customer"/>  
		</form><br><br>
		<form action="/newProduct" method="post">  
				<h1>Add a new Product</h1>
				<input type="submit" value="Add Product"/>  
		</form>
	</div>
</body>
</html>