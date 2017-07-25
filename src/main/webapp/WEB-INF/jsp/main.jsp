<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:importAttribute/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>

    <div id="wrapper" class="wrapper">
        <jsp:include page="header.jsp"/>
        <section>
            <tiles:insert attribute="data"/>
        </section>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>