<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Course Categories</title>
</head>

<body>

<br/>
<h2>All Categories</h2>
<c:forEach items="${categoryList}" var="entry">
    <div class="category-item">
        <p class="category-name">${entry.name}</p>
    </div>
</c:forEach>
</body>

</html>