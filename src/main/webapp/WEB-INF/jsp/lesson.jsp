<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Lesson</title>
    <script>
        function getDefinition() {
            var word = document.getElementById("word").innerText;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/lesson/getDefinition", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    if (this.responseText === "Unable to find definition") {
                        alert("Unable to find definition");
                    }else if (this.responseText === "Connection error") {
                        alert("Connection error");
                    } else {
                        document.getElementById("definition").innerText = this.responseText;
                    }
                }
            }
            xhr.send("word=" + encodeURIComponent(word));
        }
        function getExample() {
            var word = document.getElementById("word").innerText;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/lesson/getExample", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    if (this.responseText === "Unable to find any examples") {
                        alert("Unable to find any examples");
                    }else if (this.responseText === "Connection error") {
                        alert("Connection error");
                    } else {
                        document.getElementById("example").innerText = this.responseText;
                    }
                }
            }
            xhr.send("word=" + encodeURIComponent(word));
        }
        function getSynonymsAndAntonyms() {
            var word = document.getElementById("word").innerText;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/lesson/getSynonymsAndAntonyms", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    if (this.responseText === "Unable to find any synonyms or antonyms") {
                        alert("Unable to find any synonyms or antonyms");
                    }else if (this.responseText === "Connection error") {
                        alert("Connection error");
                    } else {
                        document.getElementById("synonymsAndAntonyms").innerText = this.responseText;
                    }
                }
            }
            xhr.send("word=" + encodeURIComponent(word));
        }
    </script>
</head>

<body>
<BR/>
<h1>Course ID: ${courseid}</h1>
<h2>Lesson ID: ${lessonid}</h2>

<p>Welcome to the lesson page.</p>
<a href="${pageContext.request.contextPath}/course/${courseid}">Back to Course</a>
<p id="word">valid word</p>
<button id="definitionButton" onclick="getDefinition()">Get Definition</button>
<p id="definition">${definition}</p>
<button id="exampleButton" onclick="getExample()">Get Example</button>
<p id="example">${example}</p>
<button id="synonymsAndAntonymsButton" onclick="getSynonymsAndAntonyms()">Get Synonyms And Antonyms</button>
<p id="synonymsAndAntonyms">${synonymsAndAntonyms}</p>
</body>

</html>