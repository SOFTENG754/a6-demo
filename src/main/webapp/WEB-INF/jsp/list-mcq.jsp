<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>SOFTENG754 Learn a new language!</title>
</head>

<body>
	<BR/>
	${name}, the questions are :
	 <c:forEach items="${lists}" var="entry">
           ID ${entry.id} <br/>
           name ${entry.name} <br/>
    </c:forEach>
</body>

</html>