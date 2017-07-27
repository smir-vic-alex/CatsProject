<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:importAttribute/>
<html>
<jsp:include page="header.jsp"/>

<body style="margin: 0;">

<div style="border-top: 5px solid #7e7e7e;"></div>
<div style="padding: 20px;">
    <div style="max-width: 1000px; margin: auto ">
        <jsp:include page="topMenuIndex.jsp"/>
    </div>
</div>
<div style="position: relative; min-height: 100%; ">
    <div style="padding-bottom: 90px; max-width: 1000px; margin: auto">
        ${data}
    </div>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
