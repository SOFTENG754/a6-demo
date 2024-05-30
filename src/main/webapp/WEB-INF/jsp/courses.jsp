<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>SOFTENG754 Learn a new language!</title>
</head>

<body>
	<BR/>
	${name}, the courses are :
	 <c:forEach items="${courselists}" var="entry">
        <div class="course-item">
           ID ${entry.id} <br/>
           name ${entry.name} <br/>
           <div class="interest-tag"></div>
           <div class="progress-tag">Not Started</div>
        </div>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/course/1">Go to Course 1</a>

</body>

</html>