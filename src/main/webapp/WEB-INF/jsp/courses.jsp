<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>SOFTENG754 Learn a new language!</title>
</head>

<body>
    <form action="${pageContext.request.contextPath}/courses/1" method="get">
        <input type="submit" value="Go to Course 1" id="course-button">
    </form>
	<BR/>
	${name}, the courses are :
	 <c:forEach items="${courselists}" var="entry">
        <div class="course-item">
           ID ${entry.id} <br/>
           name ${entry.name} <br/>
           <div class="interest-tag">${entry.interest}</div>
           <div class="progress-tag">${entry.progress}</div>
            <form action="${pageContext.request.contextPath}/courses/toggleInterest" method="post">
                <input type="hidden" name="id" value="${entry.id}">
                <input type="submit" value="Toggle Interest" class="interestButton">
            </form>

        </div>
    </c:forEach>


</body>

</html>