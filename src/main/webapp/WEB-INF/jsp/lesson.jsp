<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Lesson</title>
</head>

<body>
<BR/>
<h1>Course ID: ${courseid}</h1>
<h2>Lesson ID: ${lessonid}</h2>

<p>Welcome to the lesson page.</p>
<a href="${pageContext.request.contextPath}/course/${courseid}">Back to Course</a>
</body>

</html>