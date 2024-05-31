<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Course</title>
</head>

<body>
<BR/>
<h1>Course ID: ${courseid}</h1>
<p id="course-one-progress">${progress}</p>
<a href="${pageContext.request.contextPath}/courses">Back to Courses</a>
<a href="${pageContext.request.contextPath}/course/${courseid}/lesson/1">Go to lesson 1</a>
</body>

</html>