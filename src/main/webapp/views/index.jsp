<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	Hi There!

	<!-- <form action="add">
        Enter num1 : <input type="text" name="num1"><br>
        Enter num2 : <input type="text" name="num2"><br>
        <input type="submit">
    </form> -->

	<main>
		<section> 
			<p>Add alien...</p>
			<form action="addAlien" method="post">
				Enter Id : <input type="text" name="aid"><br> Enter
				Name : <input type="text" name="aname"><br> <input
					type="submit">
			</form>
		</section>
		<br>
		<section>
			<p>Fetch alien...</p>
			<form action="getAlien" method="get">
				Enter Id : <input type="text" name="aid"><br> <input
					type="submit">
			</form>
		</section>
		<br>
		<section>
			<p>Fetch alien...</p>
			<form action="getAlienByName" method="get">
				Enter Name : <input type="text" name="aname"><br> <input
					type="submit">
			</form>
		</section>
		<br>
		<section>
			<p>Update alien name ...</p>
			<form action="updateAlienName" method="get">
				Enter Id : <input type="text", name="aid">
				Enter Name : <input type="text" name="aname"><br> <input
					type="submit">
			</form>
		</section>
	</main>

</body>
</html>